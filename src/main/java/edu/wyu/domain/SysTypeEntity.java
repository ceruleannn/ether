package edu.wyu.domain;

import javax.persistence.*;

/**
 *
 *
 *
 */
@Entity
@Table(name = "sys_type", schema = "os", catalog = "")
public class SysTypeEntity {
    private String detail;
    private String name;
    private int tid;

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
    @Column(name = "tid")
    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysTypeEntity that = (SysTypeEntity) o;

        if (tid != that.tid) return false;
        if (detail != null ? !detail.equals(that.detail) : that.detail != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = detail != null ? detail.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + tid;
        return result;
    }
}
