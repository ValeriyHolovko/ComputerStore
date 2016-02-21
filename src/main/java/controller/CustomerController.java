package controller;

import dao.IDao;
import dao.ProductDao;
import dao.SaleDao;
import model.ProductEntity;
import model.SaleEntity;
import model.UserEntity;
import model.products.Cpu;
import model.users.Customer;
import model.users.Manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 1 on 21.02.2016.
 */
public class CustomerController implements ICustomerController {

    Customer customer;
    IDao<ProductEntity> productDao;
    IDao<SaleEntity> saleDao;

    List<ProductEntity> bucket;

    public CustomerController(Customer customer) {
        this.customer = customer;
        productDao = new ProductDao();
        saleDao = new SaleDao();
    }

    @Override
    public List<ProductEntity> getAllProducts() {
        return productDao.getAll();
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
        return bucket.remove(product);
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

        for (ProductEntity product : bucket) {
            try {
                productDao.delete(product);
            } catch (Exception e) {
                return false;
            }
        }

        this.clearBucket();
        return true;
    }
}
