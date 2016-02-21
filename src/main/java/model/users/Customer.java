package model.users;

import model.AddressEntity;
import model.SaleEntity;
import model.UserEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 1 on 01.02.2016.
 */
@Entity
@Table(name = "customers")
@DiscriminatorValue("CUSTOMER")
public class Customer extends UserEntity{

    @Column
    private String name;
    @Column
    private String phone;
    @Temporal(TemporalType.DATE)
    private Date birthday;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "address_id",
            referencedColumnName = "id")
    private AddressEntity address;

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    private List<SaleEntity> purchases;

    public Customer() {
    }


    public Customer(String login, String password, String name, String phone, Date birthday, AddressEntity address) {
        super(login, password);
        this.name = name;
        this.phone = phone;
        this.birthday = birthday;
        this.address = address;
        this.purchases = new ArrayList<SaleEntity>();
    }

    public List<SaleEntity> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<SaleEntity> purchases) {
        this.purchases = purchases;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }
}