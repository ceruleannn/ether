package edu.wyu.domain;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 *
 *
 */
@Entity
@Table(name = "order_detail", schema = "os", catalog = "")
public class OrderDetailEntity {
    private Double price;
    private Integer number;
    private Integer pid;
    private int odid;
    private OrderEntity order;
    private ProductEntity product;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "number")
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Basic
    @Column(name = "pid")
    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Id
    @Column(name = "odid")
    public int getOdid() {
        return odid;
    }

    public void setOdid(int odid) {
        this.odid = odid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetailEntity that = (OrderDetailEntity) o;
        return odid == that.odid &&
                Objects.equals(price, that.price) &&
                Objects.equals(number, that.number) &&
                Objects.equals(pid, that.pid);
    }

    @Override
    public String toString() {
        return "OrderDetailEntity{" +
                "price=" + price +
                ", number=" + number +
                ", pid=" + pid +
                ", odid=" + odid +
                ", order=" + order +
                ", product=" + product +
                '}';
    }

    @Override
    public int hashCode() {

        return Objects.hash(price, number, pid, odid);
    }

    @ManyToOne
    @JoinColumn(name = "oid", referencedColumnName = "oid")
    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    @OneToOne
    @JoinColumn(name = "pid", referencedColumnName = "pid")
    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }
}
