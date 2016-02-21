package model.users;

import model.AddressEntity;
import model.UserEntity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by 1 on 01.02.2016.
 */
@Entity
@Table(name = "admins")
@DiscriminatorValue("ADMIN")
public class Admin extends UserEntity {


    public Admin() {
    }

    public Admin(String login, String password) {
        super(login, password);
    }
}
