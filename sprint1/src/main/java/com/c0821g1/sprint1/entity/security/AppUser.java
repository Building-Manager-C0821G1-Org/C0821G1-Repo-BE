package com.c0821g1.sprint1.entity.security;

<<<<<<< HEAD

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "app_users")
    @SQLDelete(sql = "UPDATE app_users SET deleted = true WHERE id=?")
    @Where(clause = "deleted=false")
    public class AppUser {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String username;
        private String password;
        private Boolean isEnabled;
        private String verificationCode;
        @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST, targetEntity = Role.class)
        private Set<Role> roles;
        private Boolean deleted = Boolean.FALSE;

        public AppUser() {
        }

        public AppUser(int id, String username, String password, Boolean isEnabled, String verificationCode, Set<Role> roles, Boolean deleted) {
            this.id = id;
            this.username = username;
            this.password = password;
            this.isEnabled = isEnabled;
            this.verificationCode = verificationCode;
            this.roles = roles;
            this.deleted = deleted;
        }

        public AppUser(int id, String username, String password, Boolean isEnabled, String verificationCode, Set<Role> roles) {
            this.id = id;
            this.username = username;
            this.password = password;
            this.isEnabled = isEnabled;
            this.verificationCode = verificationCode;
            this.roles = roles;
        }

        public long getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Boolean getDeleted() {
            return deleted;
        }

        public void setDeleted(Boolean deleted) {
            this.deleted = deleted;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Boolean getEnabled() {
            return isEnabled;
        }

        public void setEnabled(Boolean enabled) {
            isEnabled = enabled;
        }

        public String getVerificationCode() {
            return verificationCode;
        }

        public void setVerificationCode(String verificationCode) {
            this.verificationCode = verificationCode;
        }

        public Set<Role> getRoles() {
            return roles;
        }

        public void setRoles(Set<Role> roles) {
            this.roles = roles;
        }

        @Override
        public String toString() {
            return "AppUser{" +
                    "id='" + id + '\'' +
                    ", username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    ", isEnabled=" + isEnabled +
                    ", verificationCode='" + verificationCode + '\'' +
                    ", roles=" + roles +
                    '}';
        }
    }

=======
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

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE, targetEntity = Role.class)
    @JsonBackReference
    private List<Role> roles;

    public AppUser() {
    }

    public AppUser(int appUserId, String appUserName, String appUserPassword, List<Role> roles) {
        this.appUserId = appUserId;
        this.appUserName = appUserName;
        this.appUserPassword = appUserPassword;

        this.roles = roles;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
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
>>>>>>> employee-create-BaoNHG
