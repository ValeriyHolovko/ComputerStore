package services;

import model.ProductEntity;
import model.SaleEntity;
import model.users.Customer;

import java.util.List;

/**
 * Created by 1 on 04.02.2016.
 */
public interface IManagerService {

    List<Customer> findCustomers(String name);

    Customer findCustomerById(int id);

    boolean sale(SaleEntity unacceptedSale);

    List<SaleEntity> getAcceptedSalesSales();

    List<SaleEntity> getUnacceptedSales();

    ProductEntity getProduct(String brand, String model);

    List<ProductEntity> getAllProducts();

    List<ProductEntity> getFilteredProducts(Class<? extends ProductEntity> productType, int minPrice, int maxPrice);

    List<ProductEntity> getFilteredProducts(Class<? extends ProductEntity> productType, int minPrice, int maxPrice, String brand);

    List<ProductEntity> getFilteredProducts(Class<? extends ProductEntity> productType, int minPrice, int maxPrice, String brand, String model);


}
