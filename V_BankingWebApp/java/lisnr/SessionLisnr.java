package lisnr;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionLisnr implements HttpSessionListener {
	public SessionLisnr() {
	 
    }

    public void sessionCreated(HttpSessionEvent se)  { 
    	System.out.println("Session got started");
    }

    public void sessionDestroyed(HttpSessionEvent se)  { 
    	System.out.println("Session got destroyed");
    }
	
}
