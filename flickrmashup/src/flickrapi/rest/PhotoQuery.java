package flickrapi.rest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;

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
public class PhotoQuery {
	
	public void call(){		
		try{
			String callUrlStr = Constants.REST_ENDPOINT+"?method="+Constants.METHOD+
			"&format=rest"+"&per_page="+Constants.DEFAULT_NUMBER+"&api_key="+Constants.API_KEY;
			URL callUrl = new URL(callUrlStr);			
			HttpURLConnection urlConnection = (HttpURLConnection)callUrl.openConnection();
			InputStream urlStream = urlConnection.getInputStream();
		
			DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document response = db.parse(urlStream);
			
			//print out all titles
			System.out.println("The titles returned are: ");
			NodeList nl = response.getElementsByTagName("photo");
			for (int i = 0; i < nl.getLength(); i ++){
				System.out.println(nl.item(i).
						getAttributes().getNamedItem("title").getTextContent());
			}
			urlConnection.disconnect();
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	
	public static void main(String argv[]){	

		System.setProperty("http.proxyHost", "www-cache.usyd.edu.au");
		System.setProperty("http.proxyPort","8080");
		
		PhotoQuery pq = new PhotoQuery();
		pq.call();
	}
}
