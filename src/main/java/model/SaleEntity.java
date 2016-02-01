package model;

import model.users.Customer;
import model.users.Seller;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by 1 on 01.02.2016.
 */
@Entity
@Table(name = "sales")
public class SaleEntity {

    @OneToMany
    private List<ProductEntity> productList;
    @Temporal(TemporalType.DATE)
    private Date date;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "customer_id",
            referencedColumnName = "id")
    private Customer customer;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "seller_id",
            referencedColumnName = "id")
    private Seller seller;

}
