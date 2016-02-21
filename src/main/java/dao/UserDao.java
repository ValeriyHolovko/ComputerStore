package dao;

import model.UserEntity;

import java.util.List;

/**
 * Created by 1 on 03.02.2016.
 */
public class UserDao implements IDao<UserEntity> {

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
