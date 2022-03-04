package com.c0821g1.sprint1.entity.user;

import com.c0821g1.sprint1.entity.customer.Customer;
import com.c0821g1.sprint1.entity.employee.Employee;
import com.c0821g1.sprint1.entity.space.Spaces;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int deleted;
    private int is_enabled;
    private String password;
    private String username;
    private String verification_code;

    public User() {
    }
    public User(int id, int deleted, int is_enabled, String password, String username, String verification_code) {
        this.id = id;
        this.deleted = deleted;
        this.is_enabled = is_enabled;
        this.password = password;
        this.username = username;
        this.verification_code = verification_code;

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    public int getIs_enabled() {
        return is_enabled;
    }

    public void setIs_enabled(int is_enabled) {
        this.is_enabled = is_enabled;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getVerification_code() {
        return verification_code;
    }

    public void setVerification_code(String verification_code) {
        this.verification_code = verification_code;
    }
}
