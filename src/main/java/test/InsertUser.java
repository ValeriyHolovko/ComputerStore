package test;

import model.AddressEntity;
import model.UserEntity;
import model.users.Admin;
import model.users.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

/**
 * Created by 1 on 21.02.2016.
 */
public class InsertUser {

    public static void main(String[] args) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("hibernate-unit");
        EntityManager manager = managerFactory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        AddressEntity address = new AddressEntity("Kiev", "Kopernika", "12", 30);

        UserEntity user1 = new UserEntity("user1","mail@ua","123");
        UserEntity user2 = new Customer("user2","mail123@ua","123","Vasia","Petichkin", "+380555", address, new Date());
        UserEntity user3 = new Admin("user3","mail123@ua","123");

        try {
            transaction.begin();

            manager.persist(user1);
            manager.persist(user2);
            manager.persist(user3);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            manager.close();
            managerFactory.close();
        }

    }
}
