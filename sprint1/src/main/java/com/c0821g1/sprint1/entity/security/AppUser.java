package com.c0821g1.sprint1.entity.security;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class AppUser  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer appUserId;

    private String appUserName;
    private String appUserPassword;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST, targetEntity = Role.class)
    private List<Role> roles;

    public AppUser() {
        //contructor
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Integer getAppUserId() {
        return appUserId;
    }

    public void setAppUserId(Integer appUserId) {
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
