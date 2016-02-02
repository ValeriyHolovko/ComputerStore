package test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by 1 on 02.02.2016.
 */
public class InitTables {

    public static void main(String[] args) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("hibernate-unit");
        managerFactory.close();
    }
}
