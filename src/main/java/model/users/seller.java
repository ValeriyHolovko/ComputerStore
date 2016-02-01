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
@Table(name = "sellers")
public class Seller extends UserEntity{

    @Column
    private double salary;
    @OneToMany(mappedBy = "seller", fetch = FetchType.EAGER)
    private List<SaleEntity> sales;

    public Seller() {
    }

    public Seller(String name, String phone, Date birthday, AddressEntity addressEntity, double salary) {
        super(name, phone, birthday, addressEntity);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<SaleEntity> getSales() {
        return sales;
    }

    public void setSales(List<SaleEntity> sales) {
        this.sales = sales;
    }
}
