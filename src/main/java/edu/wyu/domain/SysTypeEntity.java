package edu.wyu.domain;

import javax.persistence.*;
import java.util.Objects;

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
        return tid == that.tid &&
                Objects.equals(detail, that.detail) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(detail, name, tid);
    }
}
