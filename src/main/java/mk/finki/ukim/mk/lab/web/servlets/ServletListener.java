package mk.finki.ukim.mk.lab.web.servlets;

import org.apache.catalina.SessionEvent;
import org.apache.catalina.SessionListener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ServletListener implements ServletContextListener, SessionListener, ServletRequestListener {

    @Override
    public void sessionEvent(SessionEvent sessionEvent) {
        //  System.out.println("[WP-Log] {sessionEvent}");

    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("[WP-Log] {contextInitialized}");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //  System.out.println("[WP-Log] {contextDestroyed}");

    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        //   System.out.println("[WP-Log] {requestDestroyed}");

    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        //  System.out.println("[WP-Log] {requestInitialized}");

    }
}
