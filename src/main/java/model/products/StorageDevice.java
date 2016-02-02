package model.products;

import model.ProductEntity;

import javax.persistence.*;

/**
 * Created by 1 on 01.02.2016.
 */
@Entity
@Table(name = "storage_devices")
public class StorageDevice extends ProductEntity {

    @Column
    private int capacity;
    @Column
    @Enumerated(EnumType.STRING)
    private StorageDeviceType storageDeviceType;

    public StorageDevice() {
    }

    public StorageDevice(String brand, String model, double price, int capacity, StorageDeviceType storageDeviceType) {
        super(ProductType.StorageDevice, brand, model, price);
        this.capacity = capacity;
        this.storageDeviceType = storageDeviceType;
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

    private enum StorageDeviceType {
        HDD,SSD
    }
}
