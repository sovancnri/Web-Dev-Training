package lisnr;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class RequestResponseLisnr implements HttpSessionListener {

    public RequestResponseLisnr() {
    }

    public void sessionCreated(HttpSessionEvent se)  { 
    	System.out.println("Server Received a request");
    }
    
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	System.out.println("Response Went Off");
    }
	
}
