package com.c0821g1.sprint1.entity.contract;

import com.c0821g1.sprint1.entity.customer.Customer;
import com.c0821g1.sprint1.entity.employee.Employee;
import com.c0821g1.sprint1.entity.floor.Floors;
import com.c0821g1.sprint1.entity.space.Spaces;

import javax.persistence.*;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer contractId;

    private String contractExpired;
    private String contractDateStart;
    private String contractDateEnd;
    private String price;
    private String contractTotal;
    private String contractContent;
    private Boolean contractDeleteFlag;


    @ManyToOne
    @JoinColumn(name = "customer_id",nullable = true)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "employee_id",nullable = true)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "space_id",nullable = true)
    private Spaces spaces;

    public Contract() {
    }

    public Contract(Integer contractId, String contractExpired, String contractDateStart, String contractDateEnd, String price, String contractTotal, String contractContent, Boolean contractDeleteFlag, Customer customer, Employee employee, Spaces spaces) {
        this.contractId = contractId;
        this.contractExpired = contractExpired;
        this.contractDateStart = contractDateStart;
        this.contractDateEnd = contractDateEnd;
        this.price = price;
        this.contractTotal = contractTotal;
        this.contractContent = contractContent;
        this.contractDeleteFlag = contractDeleteFlag;
        this.customer = customer;
        this.employee = employee;
        this.spaces = spaces;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Spaces getSpaces() {
        return spaces;
    }

    public void setSpaces(Spaces spaces) {
        this.spaces = spaces;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public String getContractExpired() {
        return contractExpired;
    }

    public void setContractExpired(String contractExpired) {
        this.contractExpired = contractExpired;
    }

    public String getContractDateStart() {
        return contractDateStart;
    }

    public void setContractDateStart(String contractDateStart) {
        this.contractDateStart = contractDateStart;
    }

    public String getContractDateEnd() {
        return contractDateEnd;
    }

    public void setContractDateEnd(String contractDateEnd) {
        this.contractDateEnd = contractDateEnd;
    }

    public String getContractTotal() {
        return contractTotal;
    }

    public void setContractTotal(String contractTotal) {
        this.contractTotal = contractTotal;
    }

    public String getContractContent() {
        return contractContent;
    }

    public void setContractContent(String contractContent) {
        this.contractContent = contractContent;
    }

    public Boolean getContractDeleteFlag() {
        return contractDeleteFlag;
    }

    public void setContractDeleteFlag(Boolean contractDeleteFlag) {
        this.contractDeleteFlag = contractDeleteFlag;
    }

}
