package controller;

import model.ProductEntity;
import model.users.Customer;

import java.util.List;

/**
 * Created by 1 on 21.02.2016.
 */
public interface ICustomerController {

    List<ProductEntity> getAllProducts();

    List<ProductEntity> getFilteredProducts(Class<? extends ProductEntity> productType, int minPrice, int maxPrice);

    List<ProductEntity> getFilteredProducts(Class<? extends ProductEntity> productType, int minPrice, int maxPrice, String brand);

    List<ProductEntity> getFilteredProducts(Class<? extends ProductEntity> productType, int minPrice, int maxPrice, String brand, String model);

    boolean addToBucket(ProductEntity product);

    List<ProductEntity> getBucket();

    boolean deleteFromBucket(ProductEntity product);

    boolean clearBucket();

    boolean buy();

}
