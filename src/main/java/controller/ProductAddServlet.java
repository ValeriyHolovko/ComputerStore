package controller;

import model.ProductEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Valeriy Holovko on 10.04.2016.
 */
@WebServlet(urlPatterns = {"/product/add"})
public class ProductAddServlet extends BaseServlet{

    public static final String PRODUCT_ADD_JSP = "/WEB-INF/pages/product-add.jsp";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String brand = req.getParameter("brand");
        String model = req.getParameter("model");
        String price = req.getParameter("price");

        try {
            ProductEntity product = new ProductEntity(brand,model,Double.parseDouble(price));
            adminService.addNewProduct(product);

        } catch (ClassCastException e) {
            resp.sendRedirect("/" + APP_NAME + GENERAL_ERROR);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        req.getRequestDispatcher(PRODUCT_ADD_JSP).forward(req,resp);
    }
}
