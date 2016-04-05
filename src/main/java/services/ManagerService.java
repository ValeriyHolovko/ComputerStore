package services;

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
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by 1 on 05.02.2016.
 */
public class ManagerService implements IManagerService {

    ProductDao productDao;
    IDao<UserEntity> userDao;
    IDao<SaleEntity> saleDao;

    Manager manager;

    public ManagerService(Manager manager) {
        this.manager = manager;

        productDao = new ProductDao();
        userDao = new UserDao();
        saleDao = new SaleDao();
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
    public boolean sale(SaleEntity unacceptedSale) {

        try {
            if (!productDao.delete(unacceptedSale.getProductList())){
                return false;
            }
        } catch (Exception e) {
            return false;
        }

        unacceptedSale.setManager(this.manager);
        saleDao.update(unacceptedSale);

        return true;
    }

    @Override
    public List<SaleEntity> getAcceptedSalesSales() {
        List<SaleEntity> forReturn = new ArrayList<>();
        List<SaleEntity> sales = saleDao.getAll();

        for (SaleEntity sale : sales) {
            if (sale.getManager() != null){
                forReturn.add(sale);
            }
        }

        return forReturn;
    }

    @Override
    public List<SaleEntity> getUnacceptedSales() {
        List<SaleEntity> forReturn = new ArrayList<>();
        List<SaleEntity> sales = saleDao.getAll();

        for (SaleEntity sale : sales) {
            if (sale.getManager() == null){
                forReturn.add(sale);
            }
        }

        return forReturn;
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


}
