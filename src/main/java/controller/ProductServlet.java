package controller;

import model.ProductEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

/**
 * Created by Valeriy Holovko on 05.04.2016.
 * localhost/book?Id=*
 */
public class ProductServlet extends HttpServlet {

    public static final String APP_NAME = "computer_store";
    public static final String PRODUCT_NOT_FOUND_ERROR = "/pages/product-not-found-error.html";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String query = req.getQueryString(); //url
        String id = req.getParameter("Id"); // parameter is key-sensitive!

        if (id == null){
            //302 - redirect
            resp.sendRedirect("/" + APP_NAME + PRODUCT_NOT_FOUND_ERROR);
        }

        //TODO Getting from the database is needed
        ProductEntity product = new ProductEntity("Samsung","G570",2680.35);

        PrintWriter writer = resp.getWriter();
        writer.printf("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Product info</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <h1>Product</h1>\n" +
                "     Brand %s Model %s Price %.2f" +
                "</body>\n" +
                "</html>",product.getBrand(),product.getModel(),product.getPrice());
        writer.flush();

    }
}
