package com.employee.employee.model;

import javax.persistence.*;
import java.util.Objects;
@Table
@Entity
public class Department {
    public Department(){}

    public Department(long deptId, String deptName, String deptHead) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.deptHead = deptHead;
    }

    private @Id @GeneratedValue @Column
    Long deptId;
    @Column
    private String deptName;
    @Column
    private String deptHead;

    public long getDeptId() {
        return deptId;
    }

    public void setDeptId(long deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptHead() {
        return deptHead;
    }

    public void setDeptHead(String deptHead) {
        this.deptHead = deptHead;
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", deptHead=" + deptHead +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return deptId == that.deptId && deptName.equals(that.deptName) && deptHead.equals(that.deptHead);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deptId, deptName, deptHead);
    }
}
