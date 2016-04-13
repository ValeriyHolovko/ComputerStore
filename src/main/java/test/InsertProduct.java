package test;

import model.AddressEntity;
import model.ProductEntity;
import model.products.Cpu;
import model.products.Ram;
import model.users.Admin;
import model.users.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

/**
 * Created by 1 on 03.02.2016.
 */
public class InsertProduct {

    public static void main(String[] args) {

        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("hibernate-unit");
        EntityManager manager = managerFactory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        ProductEntity cpu1 = new Cpu("Intel","i7",2.7,4,5000);
        Cpu cpu2 = new Cpu("Intel","i5",1.44,4,3000);
        Ram ram = new Ram("Kingston","K400",2,4,400);

        try {
            transaction.begin();

            manager.persist(cpu1);
            manager.persist(cpu2);
            manager.persist(ram);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            manager.close();
            managerFactory.close();
        }

    }
}
