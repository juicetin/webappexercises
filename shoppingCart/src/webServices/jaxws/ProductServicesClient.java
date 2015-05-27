package webServices.jaxws;
import javax.xml.ws.WebServiceRef;

import model.Product;
import webServices.ProductServices;
public class ProductServicesClient {
	@WebServiceRef(wsdlLocation="http://localhost:9090/shoppingCart/ProductServices?wsdl")
	
	public static void main(String[] argv){
		
		ProductServices port = new ProductServices().getProductServicesPort();
		Product prod = port.getProductById(1);
		System.out.println(prod.getTitle());
	}
	
}
