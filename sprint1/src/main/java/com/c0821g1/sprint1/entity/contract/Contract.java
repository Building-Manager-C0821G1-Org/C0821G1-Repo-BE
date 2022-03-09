package com.c0821g1.sprint1.entity.contract;

import com.c0821g1.sprint1.entity.customer.Customer;
import com.c0821g1.sprint1.entity.employee.Employee;
import com.c0821g1.sprint1.entity.floor.Floors;
import com.c0821g1.sprint1.entity.space.Spaces;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contractId;
    private String contractCode;

    private String contractExpred;
    @Column()
    private String contractDateStart;
    private String contractDateEnd;
    private String contractTotal;
    private String contractContent;
    private Boolean contractDeleteFlag;
    private int checkFlag;


    @ManyToOne
    @JoinColumn(name = "customer_id",nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "employee_id",nullable = false)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "space_id",nullable = false)
    private Spaces spaces;



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

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public String getContractExpred() {
        return contractExpred;
    }

    public void setContractExpred(String contractExpred) {
        this.contractExpred = contractExpred;
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

    public int getCheckFlag() {
        return checkFlag;
    }

    public void setCheckFlag(int checkFlag) {
        this.checkFlag = checkFlag;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }
}
