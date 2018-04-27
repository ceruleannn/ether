package edu.wyu.domain;

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
    private BigDecimal price;
    private int oid;
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
    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderEntity that = (OrderEntity) o;
        return oid == that.oid &&
                Objects.equals(date, that.date) &&
                Objects.equals(price, that.price) &&
                Objects.equals(deliverid, that.deliverid) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {

        return Objects.hash(date, price, oid, deliverid, status);
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
