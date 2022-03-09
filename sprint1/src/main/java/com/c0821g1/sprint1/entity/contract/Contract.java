package com.c0821g1.sprint1.entity.contract;

import com.c0821g1.sprint1.entity.customer.Customer;
import com.c0821g1.sprint1.entity.employee.Employee;
import com.c0821g1.sprint1.entity.space.Spaces;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Contract  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer contractId;

    private String contractCode;
    private Integer contractExpired;
    private String contractDateStart;
    private String contractDateEnd;
    private Integer price;
    private Integer contractTotal;
    private Integer contractDeposit;
    private String contractTaxCode;
    private String contractContent;
    private String contractImageUrl;
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
//        contructor
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public String getContractImageUrl() {
        return contractImageUrl;
    }

    public void setContractImageUrl(String contractImageUrl) {
        this.contractImageUrl = contractImageUrl;
    }

    public String getContractTaxCode() {
        return contractTaxCode;
    }

    public void setContractTaxCode(String contractTaxCode) {
        this.contractTaxCode = contractTaxCode;
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

    public Integer getContractExpired() {
        return contractExpired;
    }

    public void setContractExpired(Integer contractExpired) {
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getContractTotal() {
        return contractTotal;
    }

    public void setContractTotal(Integer contractTotal) {
        this.contractTotal = contractTotal;
    }

    public Integer getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(Integer contractDeposit) {
        this.contractDeposit = contractDeposit;
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
