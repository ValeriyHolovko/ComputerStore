package model;

import javax.persistence.*;

/**
 * Created by 1 on 01.02.2016.
 */

@MappedSuperclass
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    @Enumerated(EnumType.STRING)
    private ProductType productType;
    @Column
    private String brand;
    @Column
    private String model;
    @Column
    private double price;

    public ProductEntity() {
    }

    public ProductEntity(ProductType productType, String brand, String model, double price) {
        this.productType = productType;
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductEntity productEntity = (ProductEntity) o;

        return id == productEntity.id;

    }

    @Override
    public int hashCode() {
        return id;
    }



    protected enum ProductType {
        StorageDevice,CPU,RAM,Display,VideoAdapter
    }
}
