package com.c0821g1.sprint1.entity.employee;

import com.c0821g1.sprint1.entity.contract.Contract;
import com.c0821g1.sprint1.entity.security.AppUser;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "employee_position_id", nullable = false)
    private int employeeId;

    @JoinColumn(name = "employee_position_id", nullable = false)
    private String employeeCode;

    @JoinColumn(name = "employee_position_id", nullable = false)
    private String employeeName;

    @JoinColumn(name = "employee_position_id", nullable = false)
    private String employeeDateOfBirth;

    @JoinColumn(name = "employee_position_id", nullable = false)
    private String employeeGender;

    @JoinColumn(name = "employee_position_id", nullable = false)
    private String employeeAddress;

    @JoinColumn(name = "employee_position_id", nullable = false)
    private String employeePhone;

    @JoinColumn(name = "employee_position_id", nullable = false)
    private String employeeEmail;

    @JoinColumn(name = "employee_position_id", nullable = false)
    private String employeeStartDate;

    @JoinColumn(name = "employee_position_id", nullable = false)
    private String employeeImage;

    @JoinColumn(name = "employee_position_id", nullable = false)
    private Boolean employeeDeleteFlag;

    @OneToMany(mappedBy = "employee")
    @JsonBackReference
    private List<Contract> contractList;

    @ManyToOne
    @JoinColumn(name = "employee_position", nullable = false)
    private EmployeePosition employeePosition;

//    @OneToMany(mappedBy = "employee")
//    private List<AppUser> appUserList;


    @OneToOne(targetEntity = AppUser.class, cascade = {CascadeType.PERSIST})
    private AppUser appUser;

    public Employee() {
    }

    public Employee(int employeeId, String employeeCode, String employeeName, String employeeDateOfBirth, String employeeGender, String employeeAddress, String employeePhone, String employeeEmail, String employeeStartDate, String employeeImage, Boolean employeeDeleteFlag, List<Contract> contractList, EmployeePosition employeePosition, AppUser appUser) {
        this.employeeId = employeeId;
        this.employeeCode = employeeCode;
        this.employeeName = employeeName;
        this.employeeDateOfBirth = employeeDateOfBirth;
        this.employeeGender = employeeGender;
        this.employeeAddress = employeeAddress;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
        this.employeeStartDate = employeeStartDate;
        this.employeeImage = employeeImage;
        this.employeeDeleteFlag = employeeDeleteFlag;
        this.contractList = contractList;
        this.employeePosition = employeePosition;
        this.appUser = appUser;
    }

    public Employee(int employeeId, String employeeCode, String employeeName, String employeeDateOfBirth) {
        this.employeeId = employeeId;
        this.employeeCode = employeeCode;
        this.employeeName = employeeName;
        this.employeeDateOfBirth = employeeDateOfBirth;

    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }

    public Boolean getCustomerDeleteFlag() {
        return employeeDeleteFlag;
    }

    public void setCustomerDeleteFlag(Boolean customerDeleteFlag) {
        this.employeeDeleteFlag = customerDeleteFlag;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    public Boolean getEmployeeDeleteFlag() {
        return employeeDeleteFlag;
    }

    public void setEmployeeDeleteFlag(Boolean employeeDeleteFlag) {
        this.employeeDeleteFlag = employeeDeleteFlag;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeDateOfBirth() {
        return employeeDateOfBirth;
    }

    public void setEmployeeDateOfBirth(String employeeDateOfBirth) {
        this.employeeDateOfBirth = employeeDateOfBirth;
    }

    public String getEmployeeGender() {
        return employeeGender;
    }

    public void setEmployeeGender(String employeeGender) {
        this.employeeGender = employeeGender;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeStartDate() {
        return employeeStartDate;
    }

    public void setEmployeeStartDate(String employeeStartDate) {
        this.employeeStartDate = employeeStartDate;
    }

    public String getEmployeeImage() {
        return employeeImage;
    }

    public void setEmployeeImage(String employeeImage) {
        this.employeeImage = employeeImage;
    }

    public EmployeePosition getEmployeePosition() {
        return employeePosition;
    }

    public void setEmployeePosition(EmployeePosition employeePosition) {
        this.employeePosition = employeePosition;
    }
}
