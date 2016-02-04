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
//@Table(name = "admins")
@Table(name = "users")
@DiscriminatorValue("admin")
public class Admin extends UserEntity {

    @Column
    private double salary;

    public Admin() {
    }

    public Admin(String name, String phone, Date birthday, AddressEntity addressEntity, double salary) {
        super(name, phone, birthday, addressEntity);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
