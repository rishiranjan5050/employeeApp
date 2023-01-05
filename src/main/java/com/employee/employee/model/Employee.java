package com.employee.employee.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table
public class Employee {


    public Employee(long employeId,String name, String dob, String pan, String address, long departmentId) {
        this.employeId = employeId;
        this.name = name;
        this.dob = dob;
        this.pan = pan;
        this.address = address;
        this.departmentId = departmentId;
    }
    public Employee(){

    }
    private  @Id @GeneratedValue @Column
    Long employeId;
    @Column
    private String name;
    @Column
    private String dob;
    @Column
    private String pan;
    @Column
    private String address;
    @Column
    private long departmentId;

    public void setEmployeId(long employeId) {
        this.employeId = employeId;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }

    public long getEmployeId() {
        return employeId;
    }

    public String getDob() {
        return dob;
    }

    public String getPan() {
        return pan;
    }

    public String getAddress() {
        return address;
    }

    public long getDepartmentId() {
        return departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return departmentId == employee.departmentId && Objects.equals(employeId, employee.employeId) && Objects.equals(name, employee.name) && Objects.equals(dob, employee.dob) && Objects.equals(pan, employee.pan) && Objects.equals(address, employee.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeId, name, dob, pan, address, departmentId);
    }
}
