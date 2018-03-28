package edu.wyu.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 *
 *
 *
 */
@Entity
@Table(name = "product", schema = "os", catalog = "")
public class ProductEntity {
    private Boolean ison;
    private Timestamp date;
    private String pic3;
    private String pic2;
    private String pic1;
    private String detail3;
    private String detail2;
    private String detail1;
    private String overview;
    private Double price;
    private String name2;
    private String name;
    private int pid;
    private Integer sales;
    private SysBrandEntity brand;
    private SysTypeEntity type;

    @Basic
    @Column(name = "ison")
    public Boolean getIson() {
        return ison;
    }

    public void setIson(Boolean ison) {
        this.ison = ison;
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

        if (pid != that.pid) return false;
        if (ison != null ? !ison.equals(that.ison) : that.ison != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (pic3 != null ? !pic3.equals(that.pic3) : that.pic3 != null) return false;
        if (pic2 != null ? !pic2.equals(that.pic2) : that.pic2 != null) return false;
        if (pic1 != null ? !pic1.equals(that.pic1) : that.pic1 != null) return false;
        if (detail3 != null ? !detail3.equals(that.detail3) : that.detail3 != null) return false;
        if (detail2 != null ? !detail2.equals(that.detail2) : that.detail2 != null) return false;
        if (detail1 != null ? !detail1.equals(that.detail1) : that.detail1 != null) return false;
        if (overview != null ? !overview.equals(that.overview) : that.overview != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (name2 != null ? !name2.equals(that.name2) : that.name2 != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (sales != null ? !sales.equals(that.sales) : that.sales != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ison != null ? ison.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (pic3 != null ? pic3.hashCode() : 0);
        result = 31 * result + (pic2 != null ? pic2.hashCode() : 0);
        result = 31 * result + (pic1 != null ? pic1.hashCode() : 0);
        result = 31 * result + (detail3 != null ? detail3.hashCode() : 0);
        result = 31 * result + (detail2 != null ? detail2.hashCode() : 0);
        result = 31 * result + (detail1 != null ? detail1.hashCode() : 0);
        result = 31 * result + (overview != null ? overview.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (name2 != null ? name2.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + pid;
        result = 31 * result + (sales != null ? sales.hashCode() : 0);
        return result;
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
}
