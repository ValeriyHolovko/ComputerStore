package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Valeriy Holovko on 12.04.2016.
 */
@WebServlet(urlPatterns = "/login")
public class LoginServlet extends BaseServlet {


    public static final String MAIN_JSP = "index.jsp";
    public static final String LOGIN_JSP = "/WEB-INF/pages/login.jsp";
    public static final String AUTHORIZATION_ERROR_HTML = "/pages/authorization-error.html";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(LOGIN_JSP).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        try {
            //TODO logging in is needed
            authorizationService.login(login,password);

            HttpSession httpSession = req.getSession(true);
            httpSession.setAttribute("inSystem",true);
            httpSession.setAttribute("currentUserName",login);

            resp.sendRedirect(MAIN_JSP);

        } catch (Exception e) {

            resp.sendRedirect("/" + APP_NAME + AUTHORIZATION_ERROR_HTML);
        }

    }
}
