package test;

import model.ProductEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import services.CustomerService;

/**
 * Created by Valeriy Holovko on 10.04.2016.
 */
public class CustomerServiceTestRun {

    public static void main(String[] args) {

        ApplicationContext springContext = new ClassPathXmlApplicationContext("app-context.xml");
        CustomerService customerService =  springContext.getBean(CustomerService.class);

        for (ProductEntity product  : customerService.getAllProducts()) {
            System.out.println(product.toString());
        }



    }
}
