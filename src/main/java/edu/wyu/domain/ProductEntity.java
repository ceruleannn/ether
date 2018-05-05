package edu.wyu.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 *
 *
 *
 */
@Entity
@Table(name = "product", schema = "os", catalog = "")
public class ProductEntity {
    private String status;
    private Timestamp date;
    private String pic3;
    private String pic2;
    private String pic1;
    private String detail3;
    private String detail2;
    private String detail1;
    private String overview;
    private Double price;
    private Double oldprice;
    private String name2;
    private String name;
    private int pid;
    private Integer sales;
    private SysBrandEntity brand;
    private SysTypeEntity type;

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "date")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "pic3")
    public String getPic3() {
        return pic3;
    }

    public void setPic3(String pic3) {
        this.pic3 = pic3;
    }

    @Basic
    @Column(name = "pic2")
    public String getPic2() {
        return pic2;
    }

    public void setPic2(String pic2) {
        this.pic2 = pic2;
    }

    @Basic
    @Column(name = "pic1")
    public String getPic1() {
        return pic1;
    }

    public void setPic1(String pic1) {
        this.pic1 = pic1;
    }

    @Basic
    @Column(name = "detail3")
    public String getDetail3() {
        return detail3;
    }

    public void setDetail3(String detail3) {
        this.detail3 = detail3;
    }

    @Basic
    @Column(name = "detail2")
    public String getDetail2() {
        return detail2;
    }

    public void setDetail2(String detail2) {
        this.detail2 = detail2;
    }

    @Basic
    @Column(name = "detail1")
    public String getDetail1() {
        return detail1;
    }

    public void setDetail1(String detail1) {
        this.detail1 = detail1;
    }

    @Basic
    @Column(name = "overview")
    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    @Basic
    @Column(name = "price")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "oldprice")
    public Double getOldprice() {
        return oldprice;
    }

    public void setOldprice(Double oldprice) {
        this.oldprice = oldprice;
    }

    @Basic
    @Column(name = "name2")
    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    @Column(name = "pid")
    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    @Basic
    @Column(name = "sales")
    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        return pid == that.pid &&
                Objects.equals(status, that.status) &&
                Objects.equals(date, that.date) &&
                Objects.equals(pic3, that.pic3) &&
                Objects.equals(pic2, that.pic2) &&
                Objects.equals(pic1, that.pic1) &&
                Objects.equals(detail3, that.detail3) &&
                Objects.equals(detail2, that.detail2) &&
                Objects.equals(detail1, that.detail1) &&
                Objects.equals(overview, that.overview) &&
                Objects.equals(price, that.price) &&
                Objects.equals(oldprice, that.oldprice) &&
                Objects.equals(name2, that.name2) &&
                Objects.equals(name, that.name) &&
                Objects.equals(sales, that.sales);
    }

    @Override
    public int hashCode() {

        return Objects.hash(status, date, pic3, pic2, pic1, detail3, detail2, detail1, overview, price, oldprice, name2, name, pid, sales);
    }

    @OneToOne
    @JoinColumn(name = "bid", referencedColumnName = "bid")
    public SysBrandEntity getBrand() {
        return brand;
    }

    public void setBrand(SysBrandEntity brand) {
        this.brand = brand;
    }

    @OneToOne
    @JoinColumn(name = "tid", referencedColumnName = "tid")
    public SysTypeEntity getType() {
        return type;
    }

    public void setType(SysTypeEntity type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
                "status='" + status + '\'' +
                ", date=" + date +
                ", pic3='" + pic3 + '\'' +
                ", pic2='" + pic2 + '\'' +
                ", pic1='" + pic1 + '\'' +
                ", detail3='" + detail3 + '\'' +
                ", detail2='" + detail2 + '\'' +
                ", detail1='" + detail1 + '\'' +
                ", overview='" + overview + '\'' +
                ", price=" + price +
                ", oldprice=" + oldprice +
                ", name2='" + name2 + '\'' +
                ", name='" + name + '\'' +
                ", pid=" + pid +
                ", sales=" + sales +
                ", brand=" + brand +
                ", type=" + type +
                '}';
    }
}
