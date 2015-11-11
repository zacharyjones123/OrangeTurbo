import java.io.IOException;
import java.net.*;


public class Example {
	
	public static void main(String[] args) throws Exception {
	
		//Create a URl
	
		//Example with port number
		//URL gamelan = new URL("http", "example.com", 80, "pages/page1.html");
	
		try {
			URL myURL = new URL("http://www4.ncsu.edu/~zrjones/index2.html");
			URLConnection myURLConnection = myURL.openConnection();
			URL page1URL = new URL(myURL, "page1.html");
			URL page2URL = new URL(myURL, "page2.html");

		} catch (MalformedURLException e) {
			// new URL() failed
			// ...
		} catch (IOException e) {
			// openConnection() failed
			// ...
		}
	}
}
