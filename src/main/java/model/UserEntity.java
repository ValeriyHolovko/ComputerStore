package model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by 1 on 01.02.2016.
 */

@MappedSuperclass
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String name;
    @Column
    private String phone;
    @Column
    private Date birthday;
    @Column
    private AddressEntity addressEntity;


    public UserEntity() {
    }

    public UserEntity(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public UserEntity(String name, String phone, Date birthday, AddressEntity addressEntity) {
        this.name = name;
        this.phone = phone;
        this.birthday = birthday;
        this.addressEntity = addressEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        return id == that.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}
