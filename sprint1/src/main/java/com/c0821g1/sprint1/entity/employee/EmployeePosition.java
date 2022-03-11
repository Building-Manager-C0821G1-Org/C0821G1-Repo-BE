package com.c0821g1.sprint1.entity.employee;
import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class EmployeePosition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeePositionId;
    private String employeePositionName;



    @JsonBackReference
    @OneToMany(mappedBy = "employeePosition")
    private List<Employee> employeeList;

    public EmployeePosition() {
    }

    public EmployeePosition(int employeePositionId, String employeePositionName, List<Employee> employeeList) {
        this.employeePositionId = employeePositionId;
        this.employeePositionName = employeePositionName;
        this.employeeList = employeeList;
    }

    public int getEmployeePositionId() {
        return employeePositionId;
    }

    public void setEmployeePositionId(int employeePositionId) {
        this.employeePositionId = employeePositionId;
    }

    public String getEmployeePositionName() {
        return employeePositionName;
    }

    public void setEmployeePositionName(String employeePositionName) {
        this.employeePositionName = employeePositionName;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
