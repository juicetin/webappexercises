package soap;
import  javax.xml.soap.*;
import 	commons.*;
/**
 * This showcase the request for flickr panda service using SOAP protocol
 * @author zhouy
 *
 */
public class PhotoQuery {

	public void call(){
		try{
			MessageFactory mf = MessageFactory.newInstance();
			SOAPFactory sf = SOAPFactory.newInstance();
			SOAPMessage msg = mf.createMessage();
			SOAPPart sp = msg.getSOAPPart();
			SOAPEnvelope env = sp.getEnvelope();
			env.addNamespaceDeclaration("xsi","http://www.w3.org/1999/XMLSchema-instance");
			env.addNamespaceDeclaration("xsd","http://www.w3.org/1999/XMLSchema");
			env.setEncodingStyle("http://schemas.xmlsoap.org/soap/encoding/");

			SOAPBody bd = env.getBody();
			// create the main element of the body
			SOAPElement be = sf.createElement(env.createName("FlickrRequest","x","urn:flickr"));
			// create the method element
			SOAPElement method = sf.createElement("method");
			method.setValue(Constants.METHOD);
			// create the parameter "per_page"
			SOAPElement perPagePara = sf.createElement("per_page");
			perPagePara.setValue(Constants.DEFAULT_NUMBER);		
			// create the api_key element
			SOAPElement apiKey = sf.createElement("api_key");
			apiKey.setValue(Constants.API_KEY);
			
			// create the format element
			SOAPElement soapFormat = sf.createElement("format");
			soapFormat.setValue(Constants.SOAP2);
			
			// link them together
			be.addChildElement(method);
			be.addChildElement(perPagePara);
			be.addChildElement(apiKey);
			be.addChildElement(soapFormat);
			bd.addChildElement(be);
			
			// view input
			msg.writeTo(System.out);
			System.out.println();
			
			//create the connection
			SOAPConnection conn = SOAPConnectionFactory.newInstance().createConnection();
			SOAPMessage response= conn.call(msg, Constants.SOAP_ENDPOINT);
			
			//view the output
			response.writeTo(System.out);
			System.out.println();
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		
	}

	public static void main(String argv[]){	
		//The following three lines are there for passing through the proxy
		//	change the proxyHost to "www-cache.usyd.edu.au" and proxyPort to "8080" if running in Carslaw lab
		//	uncomment the authentication line if proxy requests authentication
		//	comment all three lines if funning at home
		
		//Authenticator.setDefault(new ProxyAuthenticator("yourUserName", "yourPasswd"));  
		System.setProperty("http.proxyHost", "www-cache.cs.usyd.edu.au");
		System.setProperty("http.proxyPort","8000");
		
		PhotoQuery pq = new PhotoQuery();
		
		pq.call();
	}
}
