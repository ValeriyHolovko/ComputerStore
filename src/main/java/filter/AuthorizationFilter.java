package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static controller.BaseServlet.APP_NAME;


/**
 * Created by Valeriy Holovko on 13.04.2016.
 */
public class AuthorizationFilter implements Filter{


    public static final String NOT_IN_SYSTEM_ERROR_JSP = "/pages/not-in-system-error.jsp";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("currentUserName") == null){
            resp.sendRedirect("/" + APP_NAME + NOT_IN_SYSTEM_ERROR_JSP);
        } else {
            filterChain.doFilter(req,resp);
        }

       /* if (session.getAttribute("currentUserName") == null ||
                session.getAttribute("inSystem") == )*/
    }

    @Override
    public void destroy() {

    }
}
