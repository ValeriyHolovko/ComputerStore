package test;

import model.ProductEntity;
import model.products.Cpu;

import java.util.List;

/**
 * Created by 1 on 21.02.2016.
 */
public class CustomerTest {

    public static void main(String[] args) {
        ICustomerController customerController = new CustomerController(new model.users.Customer());

        List<ProductEntity> list = customerController.getFilteredProducts(Cpu.class, 0, 200000);

        for (ProductEntity productEntity : list) {
            System.out.println(productEntity.toString());
        }



    }


}
