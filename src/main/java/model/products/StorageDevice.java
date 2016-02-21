package model.products;

import model.ProductEntity;

import javax.persistence.*;

/**
 * Created by 1 on 01.02.2016.
 */
@Entity
@Table(name = "storage_devices")
@DiscriminatorValue("STORAGE_DEVICE")
public class StorageDevice extends ProductEntity {

    @Column
    private String brand;
    @Column
    private String model;
    @Column
    private int capacity;
    @Column
    @Enumerated(EnumType.STRING)
    private StorageDeviceType storageDeviceType;
    @Column
    private double price;

    public StorageDevice() {
    }

    public StorageDevice(String brand, String model, int capacity, StorageDeviceType storageDeviceType, double price) {
        this.brand = brand;
        this.model = model;
        this.capacity = capacity;
        this.storageDeviceType = storageDeviceType;
        this.price = price;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public StorageDeviceType getStorageDeviceType() {
        return storageDeviceType;
    }

    public void setStorageDeviceType(StorageDeviceType storageDeviceType) {
        this.storageDeviceType = storageDeviceType;
    }

    public enum StorageDeviceType {
        HDD,SSD
    }

    @Override
    public String toString() {
        return "StorageDevice{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", capacity=" + capacity +
                ", storageDeviceType=" + storageDeviceType +
                ", price=" + price +
                '}';
    }
}
