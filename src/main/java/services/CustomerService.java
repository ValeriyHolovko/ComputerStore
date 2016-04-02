package services;

import dao.IDao;
import dao.ProductDao;
import dao.SaleDao;
import model.ProductEntity;
import model.SaleEntity;
import model.users.Customer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 1 on 21.02.2016.
 */
public class CustomerService implements ICustomerService {

    Customer customer;
    IDao<ProductEntity> productDao;
    IDao<SaleEntity> saleDao;

    List<ProductEntity> bucket;

    public CustomerService(Customer customer) {
        this.customer = customer;
        productDao = new ProductDao();
        saleDao = new SaleDao();
    }

    @Override
    public List<ProductEntity> getAllProducts() {
        return productDao.getAll();
    }

    @Override
    public ProductEntity getProduct(String brand, String model) {


        for (ProductEntity product : productDao.getAll()) {
            if (product.getBrand().equals(brand) &&
                    product.getModel().equals(model)){
                return product;
            }
        }

        return null;
    }

    @Override
    public List<ProductEntity> getFilteredProducts(Class<? extends ProductEntity> productType, int minPrice, int maxPrice) {

        List<ProductEntity> forReturn = new ArrayList<>();

        for (ProductEntity product : productDao.getAll()) {
            if (productType.isInstance(product) &&
                    product.getPrice() <= maxPrice &&
                    product.getPrice() >= minPrice){

                forReturn.add(product);
            }
        }

        return forReturn;
    }

    @Override
    public List<ProductEntity> getFilteredProducts(Class<? extends ProductEntity> productType, int minPrice, int maxPrice, String brand) {

        List<ProductEntity> forReturn = new ArrayList<>();

        for (ProductEntity product : getFilteredProducts(productType,minPrice,maxPrice)) {
            if (product.getBrand().equals(brand)){
                forReturn.add(product);
            }
        }

        return forReturn;
    }

    @Override
    public List<ProductEntity> getFilteredProducts(Class<? extends ProductEntity> productType, int minPrice, int maxPrice, String brand, String model) {

        List<ProductEntity> forReturn = new ArrayList<>();

        for (ProductEntity product : getFilteredProducts(productType,minPrice,maxPrice,brand)) {
            if (product.getModel().equals(model)){
                forReturn.add(product);
            }
        }

        return forReturn;
    }

    @Override
    public boolean addToBucket(ProductEntity product) {
        if (bucket == null){
            bucket = new ArrayList<ProductEntity>();
        }
        if (bucket.contains(product)){
            return false;
        }

        bucket.add(product);
        return true;
    }

    @Override
    public List<ProductEntity> getBucket() {
        return bucket;
    }

    @Override
    public boolean deleteFromBucket(ProductEntity product) {
        boolean result = bucket.remove(product);
        if (bucket.size() == 0){
            clearBucket();
        }
        return result;
    }

    @Override
    public boolean clearBucket() {
        bucket = null;
        return true;
    }

    @Override
    public boolean buy() {
        if (bucket == null){
            return false;
        }

        SaleEntity sale = new SaleEntity(bucket,new Date(),customer);

        try {
            saleDao.insert(sale);
        } catch (Exception e) {
            return false;
        }

        this.clearBucket();
        return true;
    }
}
