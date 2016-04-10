package services;

import dao.IDao;
import exceptions.NoBookFoundException;
import model.ProductEntity;
import model.SaleEntity;
import model.UserEntity;
import model.users.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by 1 on 05.02.2016.
 */
@Component
public class AdminService implements IAdminService {

    @Autowired
    IDao<ProductEntity> productDao;
    @Autowired
    IDao<UserEntity> userDao;
    @Autowired
    IDao<SaleEntity> saleDao;

    public AdminService() {
            /*productDao = new ProductDao();
        userDao = new UserDao();
        saleDao = new SaleDao();*/

    }

    public IDao<ProductEntity> getProductDao() {
        return productDao;
    }

    public void setProductDao(IDao<ProductEntity> productDao) {
        this.productDao = productDao;
    }

    public IDao<UserEntity> getUserDao() {
        return userDao;
    }

    public void setUserDao(IDao<UserEntity> userDao) {
        this.userDao = userDao;
    }

    public IDao<SaleEntity> getSaleDao() {
        return saleDao;
    }

    public void setSaleDao(IDao<SaleEntity> saleDao) {
        this.saleDao = saleDao;
    }

    @Override
    public List<Customer> findCustomers(String name) {

        List<Customer> customersForReturn = new ArrayList<Customer>();

        List<UserEntity> usersList = userDao.getAll();

        for (UserEntity userEntity : usersList) {
            if (userEntity instanceof Customer) {

                Customer customer = (Customer) userEntity;
                if (customer.getName().toLowerCase().equals(name.toLowerCase())) {
                    customersForReturn.add((Customer) userEntity);
                }
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

            for (ProductEntity productEntity : unacceptedSale.getProductList()) {
                try {
                    if (!productDao.delete(productEntity)) {
                        return false;
                    }

                } catch (NoSuchElementException e) {
                    return false;
                }
            }
        } catch (Exception e) {
            return false;
        }

        //unacceptedSale.setManager(this.manager);
        saleDao.update(unacceptedSale);

        return true;
    }

    @Override
    public List<SaleEntity> getProcessedSales() {
        List<SaleEntity> forReturn = new ArrayList<>();
        List<SaleEntity> sales = saleDao.getAll();

        for (SaleEntity sale : sales) {
            if (sale.isProcessed()){
                forReturn.add(sale);
            }
        }

        return forReturn;
    }

    @Override
    public List<SaleEntity> getNewSales() {
        List<SaleEntity> forReturn = new ArrayList<>();
        List<SaleEntity> sales = saleDao.getAll();

        for (SaleEntity sale : sales) {
            if (!sale.isProcessed()){
                forReturn.add(sale);
            }
        }

        return forReturn;
    }

    @Override
    public void addNewProduct(ProductEntity product) {
        productDao.insert(product);
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
    public ProductEntity getProductById(int id) throws NoBookFoundException {

        ProductEntity product = productDao.findById(id);
        if (product == null){
            throw new NoBookFoundException("Book with id " + id + " was not found.");
        }
        return product;

    }


}
