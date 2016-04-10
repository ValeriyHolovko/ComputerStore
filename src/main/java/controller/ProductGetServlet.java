package controller;

import exceptions.NoBookFoundException;
import model.ProductEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Valeriy Holovko on 05.04.2016.
 * localhost/book?Id=*
 */

//@WebServlet(urlPatterns = {"/product/get"})
public class ProductGetServlet extends BaseServlet {


    public static final String PRODUCT_INFO_JSP = "/WEB-INF/pages/product-info.jsp";
    public static final String PRODUCT_NOT_FOUND_ERROR_JSP = "/WEB-INF/pages/product-not-found.jsp";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // String query = req.getQueryString(); //url
        String id = req.getParameter("id"); // parameter is key-sensitive!

        if (id == null){
            resp.sendRedirect("/" + APP_NAME + GENERAL_ERROR);
        }

        ProductEntity product = null;
        try {
            product = adminService.getProductById(Integer.parseInt(id));

            req.setAttribute("product",product);
            req.getRequestDispatcher(PRODUCT_INFO_JSP).forward(req,resp);

        } catch (NoBookFoundException e) {

            req.setAttribute("errMessage", "Product with id=" + id + " was not found.");
            req.getRequestDispatcher(PRODUCT_NOT_FOUND_ERROR_JSP).forward(req,resp);
        }


    }
}
