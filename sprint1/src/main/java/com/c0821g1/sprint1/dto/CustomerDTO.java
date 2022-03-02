package com.c0821g1.sprint1.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CustomerDTO implements Validator {

    private Integer customerId;
    @NotBlank(message = "Mã khách hàng không được bỏ trống.")
    @Pattern(regexp = "^[A-Z]+[-]+[0-9]{4}+$", message = "Mã khách hàng sai định dạng.")
    private String customerCode;
    @NotBlank(message = "Tên khách hàng không được để trống.")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Tên không được nhập số.")
    @Size(min = 6, max = 40, message = "Tên khách hàng phải từ 6 đến 40 ký tự.")
    private String customerName;
    @NotBlank(message = "CMND không được bỏ trống.")
    @Pattern(regexp = "^[0-9]{9}$", message = "CMND sai định dạng XXXXXXXXX")
    private String customerIdentifyNumber;
    @NotBlank(message = "Email không được bỏ trống.")
    @Pattern(regexp = "^[a-z0-9._!#&%{|}?`*/+-]+@[a-z0-9.-]+.[a-z]{2,4}$", message = "Email sai định dạng.")
    @Size(min = 6, max = 40, message = "Email phải từ 6 đến 40 ký tự.")
    private String customerEmail;
    @NotBlank(message = "Số điện thoại không được bỏ trống.")
    @Pattern(regexp = "^(090)\\{7}|(091)\\{7}$", message = "Số điện thoại sai định dạng.")
    private String customerPhone;
    @NotNull(message = "Ngày sinh không được để trống.")
    private String customerDateOfBirth;
    @NotBlank(message = "Địa chỉ không được bỏ trống.")
    @Size(min = 6, max = 200, message = "Địa chỉ phải từ 6 đến 200 ký tự.")
    private String customerAddress;
    private String customerStatus;
    private Boolean customerDeleteFlag;

    public CustomerDTO() {
    }

    public CustomerDTO(Integer customerId, String customerCode, String customerName, String customerIdentifyNumber, String customerEmail, String customerPhone, String customerDateOfBirth, String customerAddress, String customerStatus, Boolean customerDeleteFlag) {
        this.customerId = customerId;
        this.customerCode = customerCode;
        this.customerName = customerName;
        this.customerIdentifyNumber = customerIdentifyNumber;
        this.customerEmail = customerEmail;
        this.customerPhone = customerPhone;
        this.customerDateOfBirth = customerDateOfBirth;
        this.customerAddress = customerAddress;
        this.customerStatus = customerStatus;
        this.customerDeleteFlag = customerDeleteFlag;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
