package edu.wyu.domain;

import javax.persistence.*;
import java.util.Objects;

/**
 *
 *
 *
 */
@Entity
@Table(name = "user", schema = "os", catalog = "")
public class UserEntity {
    private String password;
    private String phone;
    private int uid;
    private String username;

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Id
    @Column(name = "uid")
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return uid == that.uid &&
                Objects.equals(password, that.password) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {

        return Objects.hash(password, phone, uid, username);
    }
}
