package model.products;

import model.ProductEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by 1 on 01.02.2016.
 */
@Entity
@Table(name = "ram")
public class Ram extends ProductEntity{

    @Column
    private int capacity;
    @Column
    private int frequency;

    public Ram(String brand, String model, double price, int capacity, int frequency) {
        super(ProductType.RAM, brand, model, price);
        this.capacity = capacity;
        this.frequency = frequency;
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
}
