package test;

import model.ProductEntity;
import model.products.Cpu;
import services.CustomerService;
import services.ICustomerService;

import java.util.List;

/**
 * Created by 1 on 21.02.2016.
 */
public class CustomerTest {

    public static void main(String[] args) {
        ICustomerService customerService = new CustomerService(new model.users.Customer());

        List<ProductEntity> list = customerService.getFilteredProducts(Cpu.class, 0, 200000);

        for (ProductEntity productEntity : list) {
            System.out.println(productEntity.toString());
        }



    }


}
