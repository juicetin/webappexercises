package flickrapi.rest;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import flickrapi.commons.Constants;

/**
 * This showcase the request for flickr panda service using REST style
 * @author zhouy
 *
 */
public class PhotoSearchQuery {
	
	public void call(){		
		try{
			
			Scanner scanner = new Scanner(System.in);
			System.out.println("Please enter comma separated tags you wish to search by");
			String tags = scanner.nextLine();
			while (tags.length() <= 0) {
				System.out.println("Please enter comma-delimited tags.");
				tags = scanner.nextLine();
			}
			
			String callUrlStr = Constants.REST_ENDPOINT
					+"?method="
					+Constants.METHOD
					+"&format=rest"
					+"&per_page="
					+500
					+"&api_key="
					+Constants.API_KEY
					+"&tags="
					+tags
					+"&extras=tags";
			
			System.out.println(callUrlStr);
			
			URL callUrl = new URL(callUrlStr);			
			HttpURLConnection urlConnection = (HttpURLConnection)callUrl.openConnection();
			InputStream urlStream = urlConnection.getInputStream();
		
			DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document response = db.parse(urlStream);
			
			//print out all titles
			System.out.println("The titles returned are: ");
			NodeList nl = response.getElementsByTagName("photo");
			for (int i = 0; i < nl.getLength(); i ++){
				
				String photo = nl.item(i).
						getAttributes().getNamedItem("title").getTextContent();
				System.out.println("===Photo Title===");
				System.out.println(photo);
				System.out.println("===Tags for " + photo + "===");
				System.out.println(nl.item(i).getAttributes().getNamedItem("tags").getTextContent());
				System.out.println();
			}
			urlConnection.disconnect();
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	
	public static void main(String argv[]){	

		System.setProperty("http.proxyHost", "www-cache.usyd.edu.au");
		System.setProperty("http.proxyPort","8080");
		
		PhotoSearchQuery pq = new PhotoSearchQuery();
		pq.call();
	}
}
