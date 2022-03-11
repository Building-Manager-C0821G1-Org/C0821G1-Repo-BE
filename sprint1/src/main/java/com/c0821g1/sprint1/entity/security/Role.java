package com.c0821g1.sprint1.entity.security;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity(name = "roles")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    public Role() {
    }

    public Role(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //    @ManyToMany(mappedBy = "roles")
//    private Set<AppUser> appUsers;

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private int roleId;
//    private String roleName;
//
//    @ManyToMany(mappedBy = "roles")
//    @JsonBackReference
//    private List<AppUser> appUsers;
//
//
//    public Role() {
//    }
//
//    public Role(int roleId, String roleName, List<AppUser> appUsers) {
//        this.roleId = roleId;
//        this.roleName = roleName;
//        this.appUsers = appUsers;
//    }
//
//
//    public int getRoleId() {
//        return roleId;
//    }
//
//    public void setRoleId(int roleId) {
//        this.roleId = roleId;
//    }
//
//    public String getRoleName() {
//        return roleName;
//    }
//
//    public void setRoleName(String roleName) {
//        this.roleName = roleName;
//    }
//
//    public List<AppUser> getAppUsers() {
//        return appUsers;
//    }
//
//    public void setAppUsers(List<AppUser> appUsers) {
//        this.appUsers = appUsers;
//    }
}

