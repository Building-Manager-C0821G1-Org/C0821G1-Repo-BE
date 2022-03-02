package com.c0821g1.sprint1.service;

import com.c0821g1.sprint1.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {
    Employee findEmployeeByAppUser(String username);

    Page<Employee> findAllEmployeePage(Pageable pageable);
}
