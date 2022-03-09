package com.c0821g1.sprint1.entity.security;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Role  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer roleId;
    private String roleName;

    @ManyToMany(mappedBy = "roles")
    private List<AppUser> appUsers;

    public Role() {
        //contructor
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<AppUser> getAppUsers() {
        return appUsers;
    }

    public void setAppUsers(List<AppUser> appUsers) {
        this.appUsers = appUsers;
    }
}
