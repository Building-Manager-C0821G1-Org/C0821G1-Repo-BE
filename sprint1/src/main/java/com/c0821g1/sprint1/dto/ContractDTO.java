package com.c0821g1.sprint1.dto;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ContractDTO implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }

    private int contractId;

    @NotNull
    @NotBlank
    private String contractExpred;

    @NotNull
    @NotBlank
    private String contractDateStart;

    @NotNull
    @NotBlank
    private String contractDateEnd;


    @NotBlank
    private String price;

    @NotBlank
    private String contractTotal;

    @NotBlank
    @Length(min = 5)
    private String contractContent;

    private Integer employeeId;
    private Integer customerId;
    private Integer spaceId;
    private Boolean contractDeleteFlag;

    public ContractDTO() {
    }

    public ContractDTO(int contractId, String contractExpred, String contractDateStart, String contractDateEnd, String price, String contractTotal, String contractContent, Integer employeeId, Integer customerId, Integer spaceId, Boolean contractDeleteFlag) {
        this.contractId = contractId;
        this.contractExpred = contractExpred;
        this.contractDateStart = contractDateStart;
        this.contractDateEnd = contractDateEnd;
        this.price = price;
        this.contractTotal = contractTotal;
        this.contractContent = contractContent;
        this.employeeId = employeeId;
        this.customerId = customerId;
        this.spaceId = spaceId;
        this.contractDeleteFlag = contractDeleteFlag;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(Integer spaceId) {
        this.spaceId = spaceId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
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
}
