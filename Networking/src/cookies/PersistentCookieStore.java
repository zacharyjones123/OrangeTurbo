package cookies;

import java.net.*;
import java.util.*;

public class PersistentCookieStore implements CookieStore, Runnable {
	CookieStore store;
	
	public PersistentCookieStore() {
		// get the default in memory cookie store
		store = new CookieManager().getCookieStore();
		
		// TODO: read in cookies from persistent storage
		// and add then to store
		
		// add a shutdown hook to write out the in memory cookies
		Runtime.getRuntime().addShutdownHook(new Thread(this));
	}
	
	public void run() {
		//TODO: write cookies in store in persistent storage
	}
	
	public void add(URI uri, HttpCookie cookie) {
		store.add(uri, cookie);
	}
	
    public List<HttpCookie> get(URI uri) {
        return store.get(uri);
    }

    public List<HttpCookie> getCookies() {
        return store.getCookies();
    }
    
    public List<URI> getURIs() {
        return store.getURIs();
    }

    public boolean remove(URI uri, HttpCookie cookie) {
        return store.remove(uri, cookie);
    }

    public boolean removeAll()  {
        return store.removeAll();
    }

}
