package model;

import model.users.Customer;
import model.users.Manager;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by 1 on 01.02.2016.
 */
@Entity
@Table(name = "sales")
public class SaleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @OneToMany
    private List<ProductEntity> productList;
    @Temporal(TemporalType.DATE)
    private Date date;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "customer_id",
            referencedColumnName = "id",nullable = false)
    private Customer customer;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "manager_id",
            referencedColumnName = "id")
    private Manager manager;

    public SaleEntity() {
    }

    public SaleEntity(List<ProductEntity> productList, Date date, Customer customer) {
        this.productList = productList;
        this.date = date;
        this.customer = customer;
    }

    public SaleEntity(List<ProductEntity> productList, Date date, Customer customer, Manager manager) {
        this.productList = productList;
        this.date = date;
        this.customer = customer;
        this.manager = manager;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ProductEntity> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductEntity> productList) {
        this.productList = productList;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "SaleEntity{" +
                "id=" + id +
                ", productList=" + productList +
                ", date=" + date +
                ", customer=" + customer.getName() +
                '}';
    }
}
