package com.c0821g1.sprint1.entity.customer;

//import com.c0821g1.sprint1.entity.contract.Contract;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Integer customerId;
    @JoinColumn(name = "customer_code", nullable = false)
    private String customerCode;
    @JoinColumn(name = "customer_name", nullable = false)
    private String customerName;
    @JoinColumn(name = "customer_identify_number", nullable = false)
    private String customerIdentifyNumber;
    @JoinColumn(name = "customer_email", nullable = false)
    private String customerEmail;
    @JoinColumn(name = "customer_phone", nullable = false)
    private String customerPhone;
    @JoinColumn(name = "customer_date_of_birth", nullable = false)
    private String customerDateOfBirth;
    @JoinColumn(name = "customer_address", nullable = false)
    private String customerAddress;
    @JoinColumn(name = "customer_status", nullable = false)
    private String customerStatus;
    @JoinColumn(name = "customer_delete_flag", nullable = false)
    private Boolean customerDeleteFlag;

//    @OneToMany(mappedBy = "customer")
//    @JsonBackReference
//    private List<Contract> contractList;


    public Customer() {
    }



//    public List<Contract> getContractList() {
//        return contractList;
//    }
//
//    public void setContractList(List<Contract> contractList) {
//        this.contractList = contractList;
//    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerIdentifyNumber() {
        return customerIdentifyNumber;
    }

    public void setCustomerIdentifyNumber(String customerIdentifyNumber) {
        this.customerIdentifyNumber = customerIdentifyNumber;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerDateOfBirth() {
        return customerDateOfBirth;
    }

    public void setCustomerDateOfBirth(String customerDateOfBirth) {
        this.customerDateOfBirth = customerDateOfBirth;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(String customerStatus) {
        this.customerStatus = customerStatus;
    }

    public Boolean getCustomerDeleteFlag() {
        return customerDeleteFlag;
    }

    public void setCustomerDeleteFlag(Boolean customerDeleteFlag) {
        this.customerDeleteFlag = customerDeleteFlag;
    }
}

