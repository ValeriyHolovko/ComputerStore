package model;

import javax.persistence.*;

/**
 * Created by 1 on 01.02.2016.
 */
@Entity
@Table(name = "products")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(
        name="type",
        discriminatorType=DiscriminatorType.STRING
)
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column()
    protected String brand;
    @Column
    protected String model;
    @Column
    protected double price;

    public ProductEntity() {
    }

    public ProductEntity(String brand, String model, double price) {
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

    @Override
    public String toString() {
        return "ProductEntity{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                '}';
    }
}
