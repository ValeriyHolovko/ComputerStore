package controller;

import dao.IDao;
import dao.ProductDao;
import dao.SaleDao;
import dao.UserDao;
import model.ProductEntity;
import model.SaleEntity;
import model.UserEntity;
import model.users.Customer;
import model.users.Manager;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by 1 on 05.02.2016.
 */
public class ManagerController implements IManagerController {

    IDao<ProductEntity> productDao;
    IDao<UserEntity> userDao;
    IDao<SaleEntity> saleDao;

    Manager manager;
    List<ProductEntity> bucket;

    public ManagerController(Manager manager) {
        this.manager = manager;

        productDao = new ProductDao();
        userDao = new UserDao();
        saleDao = new SaleDao();
    }

    @Override
    public boolean addCustomer(Customer customer) {
        try {
            userDao.insert(customer);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public List<Customer> findCustomers(String name) {

        List<Customer> customersForReturn = new ArrayList<Customer>();

        List<UserEntity> usersList = userDao.getAll();

        for (UserEntity userEntity : usersList) {
            if (userEntity instanceof Customer) {

                Customer customer = (Customer) userEntity;
                /*if (customer.getName()) {
                    customersForReturn.add((Customer) userEntity);
                }*/
            }
        }
        return customersForReturn;
    }


    @Override
    public Customer findCustomerById(int id) {

        UserEntity user = userDao.findById(id);

        if (!(user instanceof Customer)){
            throw new NoSuchElementException();
        }
        return  (Customer) user;
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
    public boolean clearBucket() {
        bucket = null;
        return true;
    }

    @Override
    public boolean sale(Customer customer) {
        // customer must have id

        if (bucket == null){
            return false;
        }
        if (userDao.findById(customer.getId()) == null){
            this.addCustomer(customer);
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

    @Override
    public List<SaleEntity> getAllSales() {
        return saleDao.getAll();
    }

    @Override
    public List<ProductEntity> getAllProducts() {
        return productDao.getAll();
    }

    @Override
    public List<Class<? extends ProductEntity>> getProductsByType(Class<? extends ProductEntity> productType) {



        return null;
    }

    @Override
    public List<Class<? extends ProductEntity>> getTypedProductsByPriceLimit(List<? extends ProductEntity> concreteProductsList, int min, int max) {



        return null;
    }

    @Override
    public List<Class<? extends ProductEntity>> getTypedProductsByBrand(List<? extends ProductEntity> concreteProductsList, String brand) {


        return null;
    }

    @Override
    public ProductEntity findProductByBrandAndModel(String brand, String model) {


        return null;
    }
}
