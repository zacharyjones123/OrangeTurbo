import java.net.*;
import java.io.*;

/**
 * If you run this program will print out the entire HTML file
 * @author Zachary Jones
 *
 */
public class URLReader {
	public static void main(String[] args) throws Exception {
		URL oracle = new URL("http://www.oracle.com/");
		BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream())); //Opens the stream for the URL
		
		String inputLine;
		while ((inputLine = in.readLine()) != null)
			System.out.println(inputLine);
		in.close();
	}

}
