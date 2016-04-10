package controller;

import dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import services.CustomerService;
import services.AdminService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * Created by Valeriy Holovko on 09.04.2016.
 */
public class BaseServlet extends HttpServlet {


    // Services you need to load
    /*TODO here must be one general service??
    Like the guest one
    OR like abstract service, which has general operations?
    */
    public static final String APP_NAME = "computer_store";
    public static final String GENERAL_ERROR = "/pages/general-error.html";

    protected AdminService adminService;
    protected CustomerService customerService;

    @Override
    public void init() throws ServletException {

        ApplicationContext springContext = (ApplicationContext) getServletContext().getAttribute("springContext");
        adminService = (AdminService) springContext.getBean("adminService");
        customerService = (CustomerService) springContext.getBean("customerService");

    }
}
