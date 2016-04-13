package controller;

import model.AddressEntity;
import model.ProductEntity;
import model.UserEntity;
import model.users.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by Valeriy Holovko on 13.04.2016.
 */
@WebServlet(urlPatterns = "/registration")
public class RegisterServlet extends BaseServlet{

    public static final String REGISTRATION_JSP = "/WEB-INF/pages/registration.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(REGISTRATION_JSP).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String mail = req.getParameter("mail");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String phone = req.getParameter("phone");

        String city = req.getParameter("city");
        String street = req.getParameter("street");
        String building = req.getParameter("building");
        String apartment = req.getParameter("apartment");

        String year = req.getParameter("year");
        String month = req.getParameter("month");
        String day = req.getParameter("day");

        try {
            UserEntity newUser = new Customer(login,mail,password,name,surname,phone,
                    new AddressEntity(city,street,building,Integer.parseInt(apartment)),
                    new Date(Integer.parseInt(year),Integer.parseInt(month),Integer.parseInt(day)));

            //TODO logging in is needed

            authorizationService.register(newUser);

        } catch (Exception e) {
            resp.sendRedirect("/" + APP_NAME + GENERAL_ERROR);
        }

    }
}
