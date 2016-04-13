package test;

import model.ProductEntity;
import model.products.Cpu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import services.CustomerService;
import services.ICustomerService;

import java.util.List;

/**
 * Created by 1 on 21.02.2016.
 */
public class CustomerServiceTest {

    CustomerService customerService;

    public void initContext(){

        ApplicationContext springContext = new ClassPathXmlApplicationContext("app-context.xml");
        CustomerService customerService =  springContext.getBean(CustomerService.class);
    }




    public void testGetAll() {

        List<ProductEntity> products = customerService.getAllProducts();

        for (ProductEntity productEntity : products) {
            System.out.println(productEntity.toString());
        }

    }


    public void GetFilteredProducts(){

        List<ProductEntity> list = customerService.getFilteredProducts(Cpu.class, 0, 200000);

        for (ProductEntity productEntity : list) {
            System.out.println(productEntity.toString());
        }
    }


}
