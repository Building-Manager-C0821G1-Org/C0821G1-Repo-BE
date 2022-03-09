package com.c0821g1.sprint1.entity.security;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appUserId;

    private String appUserName;
    private String appUserPassword;

//    @ManyToOne
//    @JoinColumn(name = "employee_id",nullable = false)
//    private Employee employee;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE, targetEntity = Roles.class)
    @JsonBackReference
    private List<Roles> roles;

    public AppUser() {
    }

    public AppUser(int appUserId, String appUserName, String appUserPassword, List<Roles> roles) {
        this.appUserId = appUserId;
        this.appUserName = appUserName;
        this.appUserPassword = appUserPassword;

        this.roles = roles;
    }

    public List<Roles> getRoles() {
        return roles;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }

    public int getAppUserId() {
        return appUserId;
    }

    public void setAppUserId(int appUserId) {
        this.appUserId = appUserId;
    }

    public String getAppUserName() {
        return appUserName;
    }

    public void setAppUserName(String appUserName) {
        this.appUserName = appUserName;
    }

    public String getAppUserPassword() {
        return appUserPassword;
    }

    public void setAppUserPassword(String appUserPassword) {
        this.appUserPassword = appUserPassword;
    }

}
