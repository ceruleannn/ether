package edu.wyu.domain;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;

/**
 *
 *
 *
 */
@Entity
@Table(name = "order", schema = "os", catalog = "")
public class OrderEntity {
    private Timestamp date;
    private String phone;
    private String address;
    private Double totalPrice;
    private int oid;
    private String deliverCompany;
    private Integer deliverid;
    private String status;

    private Set<OrderDetailEntity> details;
    private UserEntity user;

    @Basic
    @Column(name = "date")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "totalPrice")
    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Id
    @Column(name = "oid")
    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    @Basic
    @Column(name = "deliverCompany")
    public String getDeliverCompany() {
        return deliverCompany;
    }

    public void setDeliverCompany(String deliverCompany) {
        this.deliverCompany = deliverCompany;
    }

    @Basic
    @Column(name = "deliverid")
    public Integer getDeliverid() {
        return deliverid;
    }

    public void setDeliverid(Integer deliverid) {
        this.deliverid = deliverid;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @OneToMany(mappedBy = "order")
    public Set<OrderDetailEntity> getDetails() {
        return details;
    }

    public void setDetails(Set<OrderDetailEntity> details) {
        this.details = details;
    }

    @OneToOne
    @JoinColumn(name = "uid", referencedColumnName = "uid")
    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
