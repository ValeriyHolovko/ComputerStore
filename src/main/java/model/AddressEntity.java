package model;

import javax.persistence.*;

/**
 * Created by 1 on 01.02.2016.
 */
@Entity
@Table(name = "addresses")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String city;
    @Column
    private String street;
    @Column
    private String building;
    @Column
    private int apartment;

    public AddressEntity() {
    }

    public AddressEntity(String city, String street, String building, int apartment) {
        this.city = city;
        this.street = street;
        this.building = building;
        this.apartment = apartment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public int getApartment() {
        return apartment;
    }

    public void setApartment(int apartment) {
        this.apartment = apartment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddressEntity addressEntity = (AddressEntity) o;

        return id == addressEntity.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}
