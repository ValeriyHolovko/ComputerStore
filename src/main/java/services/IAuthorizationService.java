package services;

import exceptions.NoUserFoundException;
import model.UserEntity;

/**
 * Created by Valeriy Holovko on 13.04.2016.
 */
public interface IAuthorizationService {

    UserEntity login(String login, String password) throws NoUserFoundException;

    void register(UserEntity newUser);
}
