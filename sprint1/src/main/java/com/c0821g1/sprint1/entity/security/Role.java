package com.c0821g1.sprint1.entity.security;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
//    @ManyToMany(mappedBy = "roles")
//    private Set<AppUser> appUsers;

    public Role() {
    }

    public Role(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Role(String name) {
        this.name = name;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    public Set<AppUser> getAppUsers() {
//        return appUsers;
//    }
//
//    public void setAppUsers(Set<AppUser> appUsers) {
//        this.appUsers = appUsers;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}