package model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by 1 on 01.02.2016.
 */
@Entity
@Table(name = "users",uniqueConstraints = {@UniqueConstraint(columnNames = {"login"})})
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(
        name="type",
        discriminatorType=DiscriminatorType.STRING
)
@DiscriminatorValue(value = "UNDEFINED")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String login;
    @Column
    private String mail;
    @Column
    private String password;


    public UserEntity() {
    }

    public UserEntity(String login, String mail, String password) {
        this.login = login;
        this.mail = mail;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", login='" + login + '\'' +
//                ", password='" + password + '\'' +
                '}';
    }
}
