package model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by 1 on 01.02.2016.
 */

@MappedSuperclass
@Table(name = "products")
// , uniqueConstraints = {@UniqueConstraint(columnNames = {"city","street"})}
public class ProductEntity extends IdEntity{

    @Column
    private ProductType productType;
    @Column
    private String brand;
    @Column
    private String model;
    @Column
    private double price;

    public ProductEntity(ProductType productType, String brand, String model, double price) {
        this.productType = productType;
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    protected enum ProductType {
        StorageDevice,CPU,RAM,Display,VideoAdapter
    }
}
