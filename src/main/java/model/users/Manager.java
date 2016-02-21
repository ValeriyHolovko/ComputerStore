package model.users;

import model.AddressEntity;
import model.SaleEntity;
import model.UserEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by 1 on 01.02.2016.
 */

@Entity
@Table(name = "managers")
@DiscriminatorValue("MANAGER")
public class Manager extends UserEntity{

    @Column
    private String name;

    public Manager() {

    }

    public Manager(String login, String password, String name) {
        super(login, password);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
