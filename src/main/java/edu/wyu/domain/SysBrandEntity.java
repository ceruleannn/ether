package edu.wyu.domain;

import javax.persistence.*;
import java.util.Objects;

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
        return bid == that.bid &&
                Objects.equals(icon, that.icon) &&
                Objects.equals(detail, that.detail) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(icon, detail, name, bid);
    }
}
