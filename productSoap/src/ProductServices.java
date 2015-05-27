package webServices;

import java.util.List;
import javax.jws.*;
import javax.xml.ws.Endpoint;

import dao.*;
import model.*;
@WebService()
public class ProductServices {
	
	private ProductDao pdao = DaoFactory.getInstance().getProductDao();
	
	@WebMethod()
	public List<Product> getAllProducts(){
		return pdao.getAllProducts();
	}
	
	@WebMethod()
	public Product getProductById(int productId) {
		return pdao.getProductById(productId);
	}
	
	@WebMethod()
	public int addProduct(Product product) {
		int productId = product.getProductId();
		if (productId != -1){ //an old resource
			pdao.updateProduct(product);
			return productId;
		}else{
			pdao.addProduct(product);
			return product.getProductId();
		}
	}
	

	public static void main(String[] args) {

	      Endpoint.publish(
	         "http://localhost:9090/shoppingCart/productServices",
	         new ProductServices());

	}

}
