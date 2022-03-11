package com.c0821g1.sprint1.entity.security;

import javax.persistence.*;

@Entity(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id", nullable = false)
    private Integer id;

    @JoinColumn(name = "name", nullable = false)
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