package edu.wyu.domain;

import javax.persistence.*;

/**
 *
 *
 *
 */
@Entity
@Table(name = "sys_brand", schema = "os", catalog = "")
public class SysBrandEntity {
    private String icon;
    private String detail;
    private String name;
    private int bid;

    @Basic
    @Column(name = "icon")
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Basic
    @Column(name = "detail")
    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
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
    @Column(name = "bid")
    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysBrandEntity that = (SysBrandEntity) o;

        if (bid != that.bid) return false;
        if (icon != null ? !icon.equals(that.icon) : that.icon != null) return false;
        if (detail != null ? !detail.equals(that.detail) : that.detail != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = icon != null ? icon.hashCode() : 0;
        result = 31 * result + (detail != null ? detail.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + bid;
        return result;
    }
}
