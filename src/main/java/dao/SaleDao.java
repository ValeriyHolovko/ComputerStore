package dao;

import model.ProductEntity;
import model.SaleEntity;

import javax.persistence.*;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by 1 on 05.02.2016.
 */
public class SaleDao implements IDao<SaleEntity>{

    private final EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("hibernate-unit");

    public SaleDao() {
    }

    @Override
    public void insert(SaleEntity obj) {
        EntityManager manager = managerFactory.createEntityManager();
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
    public void update(SaleEntity obj) {

        EntityManager manager = managerFactory.createEntityManager();
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
    public List<SaleEntity> getAll() {
        EntityManager manager = managerFactory.createEntityManager();

        TypedQuery<SaleEntity> query = manager.createQuery("SELECT p FROM ProductEntity p", SaleEntity.class);

        return query.getResultList();
    }

    @Override
    public SaleEntity findById(int id) {
        EntityManager manager = managerFactory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        try {
            SaleEntity sale = manager.find(SaleEntity.class, id);
            return sale;
        } finally {
            manager.close();
        }
    }

    @Override
    public boolean delete(SaleEntity objKey) {
        EntityManager manager = managerFactory.createEntityManager();
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
