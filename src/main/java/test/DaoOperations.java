package test;

import dao.ProductDao;
import model.ProductEntity;
import model.products.StorageDevice;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by 1 on 04.02.2016.
 */
public class DaoOperations {

    public static void main(String[] args) {

        ProductDao dao = new ProductDao();
        ///////////////////////////////////////////////////
        //  GET ALL
        List<ProductEntity> products = dao.getAll();

        for (ProductEntity product : products) {
            System.out.println(product.toString());
        }
        ///////////////////////////////////////////////////
        //  INSERT
        dao.insert(new StorageDevice("Samsung", "G630", 500, StorageDevice.StorageDeviceType.SSD, 3250));

        products = dao.getAll();

        for (ProductEntity product : products) {
            System.out.println(product.toString());
        }
        ///////////////////////////////////////////////////
        //  FIND BY ID
        ProductEntity product = dao.findById(3);
        System.out.println(product.toString());

        ///////////////////////////////////////////////////
        //  UPDATE
        product.setPrice(100000);
        System.out.println("Changed but not added:" + product.getPrice());
        dao.update(product);
        System.out.println("After adding:" + product.getPrice());

        System.out.println(dao.findById(3).toString());

        ///////////////////////////////////////////////////
        //  DELETE

        dao.insert(new StorageDevice("Samsung", "G630", 500, StorageDevice.StorageDeviceType.SSD, 3250));


        try {
            dao.delete(dao.findById(10));

        } catch (NoSuchElementException e) {
            System.out.println("No such element in db.");
        }
        try {
            System.out.println(dao.findById(2).toString());
        } catch (NullPointerException e) {
            System.out.println("Deleted");
        }


    }
}
