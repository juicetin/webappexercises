package rest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.core.*;
import javax.xml.bind.JAXBElement;

import java.util.*;
import dao.DaoFactory;
import dao.ProductDao;
import model.Product;
/**
 * Representing the ProductResource in Rest web Services 
 */
@Path("/products")
public class ProductResource {
	private ProductDao pdao = DaoFactory.getInstance().getProductDao();
	@Context UriInfo uriInfo; //like an instance variable definition
	
	/**
	 * Get all product. A simplified implementation without exception handling
	 */
	
	@GET
	@Produces(MediaType.TEXT_XML)
	public List<Product> getAllProducts() {
		return pdao.getAllProducts();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.TEXT_XML)
	public Product getProductById(@PathParam(value="id") int productId) {
		return pdao.getProductById(productId);
	}
	

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public Response addProduct(JAXBElement<Product> productXML) {
		Response res = null;
		Product product = productXML.getValue();
		int productId = product.getProductId();
		if (productId != -1){ //an old resource
			pdao.updateProduct(product);
			res =Response.noContent().build();
		}else{
			pdao.addProduct(product);
			res = Response.created(uriInfo.getAbsolutePath()).build();
		}
		return res;
	}
}
