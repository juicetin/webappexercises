package webServices.test;
import javax.xml.ws.WebServiceRef;
public class ProductServicesClient {
	@WebServiceRef(wsdlLocation="http://localhost:9090/shoppingCart/ProductServices?wsdl")
	
	public static void main(String[] argv){
		
		ProductServices port = new ProductServicesService().getProductServicesPort();
		Product prod = port.getProductById(1);
		System.out.println(prod.getTitle());
	}
	
}
