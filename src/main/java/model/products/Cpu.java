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
@Table(name = "cpu")
@DiscriminatorValue("CPU")
public class Cpu extends ProductEntity {

    @Column
    private double frequency;
    @Column
    private int coresNumber;


    public Cpu() {
    }

    public Cpu(String brand, String model, double frequency, int coresNumber, double price) {
        super.brand = brand;
        super.model = model;
        super.price = price;
        this.frequency = frequency;
        this.coresNumber = coresNumber;

    }

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    public int getCoresNumber() {
        return coresNumber;
    }

    public void setCoresNumber(int coresNumber) {
        this.coresNumber = coresNumber;
    }

    @Override
    public String toString() {
        return "Cpu{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", frequency=" + frequency +
                ", coresNumber=" + coresNumber +
                ", price=" + price +
                '}';
    }
}
