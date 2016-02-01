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
@Table(name = "sellers")
public class Seller extends UserEntity{

    @Column
    private double salary;
    @Column
    private List<ProductEntity> sales;



}
