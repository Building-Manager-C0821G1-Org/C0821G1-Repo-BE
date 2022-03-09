package com.c0821g1.sprint1.service;


import com.c0821g1.sprint1.entity.employee.Employee;
import com.c0821g1.sprint1.entity.security.AppUser;

import java.util.List;

public interface EmployeeService {


    void saveEmployee(Employee employee);
    Employee findEmployeeByID(int id);
    void editEmployee(Employee employee);
    void createEmployeeAccount(AppUser appUser);
    Boolean existsEmployeeByEmail(String employeeEmail);
    Boolean existsEmployeeByCode(String employeeCode);
    List<Employee> findALL();
}
