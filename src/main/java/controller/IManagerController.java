package controller;

import model.ProductEntity;
import model.SaleEntity;
import model.users.Customer;

import java.util.List;

/**
 * Created by 1 on 04.02.2016.
 */
public interface IManagerController {

    boolean addCustomer(Customer customer);

    List<Customer> findCustomers(String name);

    Customer findCustomerById(int id);

    boolean addToBucket(ProductEntity product);

    boolean clearBucket();

    boolean sale(Customer customer);

    List<SaleEntity> getAllSales();

    List<ProductEntity> getAllProducts();

    List<Class<? extends ProductEntity>> getProductsByType(Class<? extends ProductEntity> productType);

    List<Class<? extends ProductEntity>> getTypedProductsByPriceLimit(List<? extends ProductEntity> concreteProductsList, int min, int max);

    List<Class<? extends ProductEntity>> getTypedProductsByBrand(List<? extends ProductEntity> concreteProductsList, String brand);

    ProductEntity findProductByBrandAndModel(String brand, String model);


}
