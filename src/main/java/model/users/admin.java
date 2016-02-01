package model.users;

import model.UserEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by 1 on 01.02.2016.
 */
@Entity
@Table(name = "admins")
public class Admin extends UserEntity {

    @Column
    private double salary;



}
