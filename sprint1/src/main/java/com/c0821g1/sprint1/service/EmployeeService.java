package com.c0821g1.sprint1.service;

import com.c0821g1.sprint1.dto.EmployeeDTO;
import com.c0821g1.sprint1.entity.employee.Employee;

public interface EmployeeService {

    void saveEmployee(EmployeeDTO employeeDTO);
    void saveEmployee(Employee employee);
    Employee findEmployeeByID(int id);
    void editEmployee(EmployeeDTO employeeDTO);
    void createEmployeeAccount(EmployeeDTO employeeDTO);
}
