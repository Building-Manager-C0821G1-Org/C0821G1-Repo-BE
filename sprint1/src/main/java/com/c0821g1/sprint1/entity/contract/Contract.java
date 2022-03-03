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

    private String contractExpred;
    @Column()
    private Date contractDateStart;
    private Date contractDateEnd;
    private String contractTotal;
    private String contractContent;
    private Boolean contractDeleteFlag;


    @ManyToOne
    @JoinColumn(name = "customer_id",nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "employee_id",nullable = false)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "space_id",nullable = false)
    private Spaces spaces;

    public Contract() {
    }

    public Contract(int contractId, String contractExpred, Date contractDateStart, Date contractDateEnd, String contractTotal, String contractContent, Boolean contractDeleteFlag, Customer customer, Employee employee, Spaces spaces) {
        this.contractId = contractId;
        this.contractExpred = contractExpred;
        this.contractDateStart = contractDateStart;
        this.contractDateEnd = contractDateEnd;
        this.contractTotal = contractTotal;
        this.contractContent = contractContent;
        this.contractDeleteFlag = contractDeleteFlag;
        this.customer = customer;
        this.employee = employee;
        this.spaces = spaces;
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


    public Date getContractDateStart() {
        return contractDateStart;
    }

    public void setContractDateStart(Date contractDateStart) {
        this.contractDateStart = contractDateStart;
    }

    public Date getContractDateEnd() {
        return contractDateEnd;
    }

    public void setContractDateEnd(Date contractDateEnd) {
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
