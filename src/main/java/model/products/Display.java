package model.products;

import model.ProductEntity;

import javax.persistence.*;

/**
 * Created by 1 on 01.02.2016.
 */
@Entity
@Table(name = "displays")
@DiscriminatorValue("DISPLAY")
public class Display extends ProductEntity {

    @Column
    private double size;
    @Column
    private int resolution;
    @Column
    @Enumerated(EnumType.STRING)
    private DisplayType displayType;

    public Display() {
    }

    public Display(String brand, String model, double size, int resolution, DisplayType displayType, double price) {
        super.brand = brand;
        super.model = model;
        super.price = price;
        this.size = size;
        this.resolution = resolution;
        this.displayType = displayType;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public int getResolution() {
        return resolution;
    }

    public void setResolution(int resolution) {
        this.resolution = resolution;
    }

    public DisplayType getDisplayType() {
        return displayType;
    }

    public void setDisplayType(DisplayType displayType) {
        this.displayType = displayType;
    }

    public enum DisplayType {
        LED,LCD,IPS,AMOLED
    }

    @Override
    public String toString() {
        return "Display{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", size=" + size +
                ", resolution=" + resolution +
                ", displayType=" + displayType +
                ", price=" + price +
                '}';
    }
}
