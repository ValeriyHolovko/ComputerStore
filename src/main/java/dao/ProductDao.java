package dao;

import model.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by 1 on 03.02.2016.
 */
@Component
public class ProductDao implements IDao<ProductEntity> {

    @Autowired
    private EntityManagerFactory entityManagerFactory;
    //private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-unit");

    public ProductDao() {
    }

    @Override
    public void insert(ProductEntity obj) {
        EntityManager manager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        try {
            transaction.begin();
            manager.persist(obj);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            manager.close();
        }
    }

    @Override
    public void update(ProductEntity obj) {
        EntityManager manager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        try {
            transaction.begin();
            manager.merge(obj);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            manager.close();
        }


    }


    @Override
    public ProductEntity findById(int id) {
        EntityManager manager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        try {
            ProductEntity product = manager.find(ProductEntity.class, id);
            return product;
        } finally {
            manager.close();
        }

    }

    @Override
    public List<ProductEntity> getAll() {
        EntityManager manager = entityManagerFactory.createEntityManager();

        TypedQuery<ProductEntity> query = manager.createQuery("SELECT p FROM ProductEntity p", ProductEntity.class);

        return query.getResultList();
    }

    @Override
    public boolean delete(ProductEntity objKey) throws NoSuchElementException{
        EntityManager manager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        ProductEntity objActual = manager.find(ProductEntity.class, objKey.getId());

        if (objActual == null){
            throw new NoSuchElementException();
        }

        try {
            transaction.begin();
            manager.remove(objActual);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            return false;
        } finally {
            manager.close();
        }

        return true;
    }

}
