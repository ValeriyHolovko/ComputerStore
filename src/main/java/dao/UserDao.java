package dao;

import model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManagerFactory;
import java.util.List;

/**
 * Created by 1 on 03.02.2016.
 */
@Component
public class UserDao implements IDao<UserEntity> {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Override
    public void insert(UserEntity obj) {

    }

    @Override
    public void update(UserEntity obj) {

    }

    @Override
    public List<UserEntity> getAll() {
        return null;
    }

    @Override
    public UserEntity findById(int id) {
        return null;
    }

    @Override
    public boolean delete(UserEntity obj) {
        return false;
    }

}
