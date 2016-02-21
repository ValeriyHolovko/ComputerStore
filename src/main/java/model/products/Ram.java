package model.products;

import model.ProductEntity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by 1 on 01.02.2016.
 */
@Entity
@Table(name = "ram")
@DiscriminatorValue("RAM")
public class Ram extends ProductEntity{

    @Column
    private String brand;
    @Column
    private String model;
    @Column
    private int capacity;
    @Column
    private int frequency;
    @Column
    private double price;

    public Ram() {
    }

    public Ram(String brand, String model, int capacity, int frequency, double price) {
        this.brand = brand;
        this.model = model;
        this.capacity = capacity;
        this.frequency = frequency;
        this.price = price;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "Ram{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", capacity=" + capacity +
                ", frequency=" + frequency +
                ", price=" + price +
                '}';
    }
}
