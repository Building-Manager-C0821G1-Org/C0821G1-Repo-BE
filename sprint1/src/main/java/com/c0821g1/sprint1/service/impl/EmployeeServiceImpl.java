package com.c0821g1.sprint1.service.impl;

import com.c0821g1.sprint1.entity.employee.Employee;
import com.c0821g1.sprint1.repository.EmployeeRepository;
import com.c0821g1.sprint1.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public Employee findEmployeeByAppUser(String username) {
        return employeeRepository.findEmployeeByAppUser(username);
    }

    @Override
    public Page<Employee> findAllEmployeePage(Pageable pageable) {
        return null;
    }

    @Override
    public Employee findById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }
}
