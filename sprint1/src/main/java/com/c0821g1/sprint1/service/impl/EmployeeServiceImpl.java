package com.c0821g1.sprint1.service.impl;

import com.c0821g1.sprint1.entity.employee.Employee;
import com.c0821g1.sprint1.repository.EmployeeRepository;
import com.c0821g1.sprint1.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository iEmployeeRepository;

    @Override
    public Employee getEmployeeByUsername(String username) {
        return this.iEmployeeRepository.findEmployeeByAppUser(username);
    }
}
