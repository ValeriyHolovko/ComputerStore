package listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class SpringInitContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        String springLocation = servletContext.
                getInitParameter("spring-location");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(springLocation);
        servletContext.setAttribute("springContext",applicationContext);

        servletContext.setAttribute("APP_NAME", servletContext.getInitParameter("appName"));

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
