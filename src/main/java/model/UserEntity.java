package model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by 1 on 01.02.2016.
 */
@Entity
@Table(name = "users")
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name="type",
        discriminatorType=DiscriminatorType.STRING
)
@DiscriminatorValue(value="user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String name;
    @Column
    private String phone;
    @Temporal(TemporalType.DATE)
    private Date birthday;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "address_id",
            referencedColumnName = "id")
    private AddressEntity address;


    public UserEntity() {
    }

    public UserEntity(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public UserEntity(String name, String phone, Date birthday, AddressEntity address) {
        this.name = name;
        this.phone = phone;
        this.birthday = birthday;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
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
