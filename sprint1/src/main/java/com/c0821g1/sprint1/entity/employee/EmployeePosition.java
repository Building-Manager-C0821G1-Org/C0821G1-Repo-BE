package com.c0821g1.sprint1.entity.employee;
import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;
import java.util.List;

@Entity
public class EmployeePosition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeePositionId;

    private String employeePositionName;


    @OneToMany(mappedBy = "employeePosition")
    @JsonBackReference
    private List<Employee> employeeList;

    public EmployeePosition() {
    }

    public EmployeePosition(int employeePositionId, String employeePositionName, List<Employee> employeeList) {
        this.employeePositionId = employeePositionId;
        this.employeePositionName = employeePositionName;
    }

    public EmployeePosition(int employeePositionId, List<Employee> employeeList) {
        this.employeePositionId = employeePositionId;

        this.employeeList = employeeList;
    }
}
