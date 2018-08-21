package SessionListener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
@WebListener
public class ListenerSession implements  HttpSessionListener{

	public void sessionCreated(HttpSessionEvent sessionEvent) {
		// TODO Auto-generated method stub
		System.out.println("Session Created:: ID="+sessionEvent.getSession().getId());
	}

	public void sessionDestroyed(HttpSessionEvent sessionEvent) {
		// TODO Auto-generated method stub
		System.out.println("Session Destroyed:: ID="+sessionEvent.getSession().getId());
	}

	

}
