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
@Table(name = "customers")
public class Customer extends UserEntity{

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    private List<SaleEntity> purchases;

    public Customer() {
    }

    public Customer(String name, String phone) {
        super(name, phone);
    }

    public Customer(String name, String phone, Date birthday, AddressEntity addressEntity) {
        super(name, phone, birthday, addressEntity);
    }

    public List<SaleEntity> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<SaleEntity> purchases) {
        this.purchases = purchases;
    }
}