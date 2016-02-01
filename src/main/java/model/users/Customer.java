package model.users;

import model.ProductEntity;
import model.UserEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by 1 on 01.02.2016.
 */
@Entity
@Table(name = "customers")
public class Customer extends UserEntity{

    ///////////////////////////////////////
    @Column
    private List<ProductEntity> purchases;

}