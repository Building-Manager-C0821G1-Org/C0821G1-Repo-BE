package com.c0821g1.sprint1.entity.employee;

import java.util.List;

public class Jwt {
    private String jwtToken;
    private String username;
    private String name;
    private String pass;
    private String dayOfBirth;
    private String gender;
    private String address;
    private String phone;
    private String email;
    private String idCustomer;
    private String urlImg;
    private String roles;

    public Jwt() {
    }

    public Jwt(String jwtToken, String username, String name, String pass, String dayOfBirth, String gender, String address, String phone, String email, String idCustomer, String urlImg, String roles) {
        this.jwtToken = jwtToken;
        this.username = username;
        this.name = name;
        this.pass = pass;
        this.dayOfBirth = dayOfBirth;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.idCustomer = idCustomer;
        this.urlImg = urlImg;
        this.roles = roles;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
