package services;

import dao.UserDao;
import exceptions.NoUserFoundException;
import model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Created by Valeriy Holovko on 13.04.2016.
 */
@Component
public class AuthorizationService implements IAuthorizationService {

    @Autowired
    UserDao userDao;

    @Override
    public UserEntity login(String login, String password) throws NoUserFoundException {
        ArrayList<UserEntity> users = (ArrayList<UserEntity>) userDao.getAll();
        for (UserEntity user : users) {
            if (user.getLogin().toLowerCase().equals(login.toLowerCase()) &&
                    user.getPassword().equals(password)){
                return user;
            }
        }
        throw new NoUserFoundException("No user found. Incorrect login or password.");
    }

    @Override
    public void register(UserEntity newUser) {
        //TODO add checking if user is registered and adding exception if insertion is failed
        userDao.insert(newUser);
    }
}
