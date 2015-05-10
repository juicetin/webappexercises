package controller;

import java.util.List;

import javax.validation.Valid;

import model.Product;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.DaoFactory;
import dao.ProductDao;

@Controller
@RequestMapping("/products")
public class ProductController {

	private final ProductDao pdao = DaoFactory.getInstance().getProductDao();
	
	@RequestMapping(method = RequestMethod.GET)
	public String listAll(Model model){
		
		List<Product> products = pdao.getAllProducts();
		model.addAttribute("products", products);
		return "productlist";
	}
	
	@RequestMapping(value="/new", method = RequestMethod.GET)
	public String add(Model model){
		Product product = new Product(); // create an empty product
		model.addAttribute("product", product);
		return "product";
	}
	
	// this is the method for inserting a new product or updating an existing prouct
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute("product") Product product, BindingResult result){
		
		if (result.hasErrors()) {
	        return "product";
		}
		// add your code here to save a new produce or update the existing product
		// a new product will have an initial id of -1
		product.setDescription(result.getFieldValue("description").toString());
		product.setPrice(Double.parseDouble(result.getFieldValue("price").toString()));
		product.setTitle(result.getFieldValue("title").toString());
		
		if (product.getProductId() == -1) {
			pdao.addProduct(product);
		} else {
			pdao.updateProduct(product);
		}
		
		// we redirect to the product list page
		// which will call the listAll method and show updated product list
		return "redirect:/products";
	}
	
	@RequestMapping("/edit/{productId}")
	public String edit(@PathVariable int productId, Model model){
		//add your code here to find a product based on its id
		//and put it in the model
		model.addAttribute(pdao.getProductById(productId));
		return "product";
	}
	
	@RequestMapping("/delete/{productId}")
	public String delete(@PathVariable int productId, Model model){
		pdao.deleteProduct(productId);
		return "redirect:/products";
	}
}
