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
    private String brand;
    @Column
    private String model;
    @Column
    private double frequency;
    @Column
    private int coresNumber;
    @Column
    private double price;


    public Cpu() {
    }

    public Cpu(String brand, String model, double frequency, int coresNumber, double price) {
        this.brand = brand;
        this.model = model;
        this.frequency = frequency;
        this.coresNumber = coresNumber;
        this.price = price;
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


}
