package com.c0821g1.sprint1.service;

import com.c0821g1.sprint1.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface EmployeeService {
    Page<Employee> findAllEmployeeSearch(Pageable pageable, String employee_name, String employee_date_0f_birth, String employee_email, String employee_address);

    Page<Employee> findAllEmployeePage(Pageable pageable);

    void deleteById(Integer id);

    Optional<Employee> findByIdOp(Integer id);


}
