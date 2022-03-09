package com.c0821g1.sprint1.service.impl.employee;

import com.c0821g1.sprint1.entity.employee.Employee;
import com.c0821g1.sprint1.repository.employee.EmployeeRepository;
import com.c0821g1.sprint1.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Page<Employee> findAllEmployeeSearch(Pageable pageable, String employeeName, String employeeDateOfBirth, String employeeEmail, String employeeAddress) {
        return employeeRepository.searchEmployeeByNameOrDateOfBirthOrEmailOrAddress(pageable, employeeName, employeeDateOfBirth, employeeEmail, employeeAddress);
    }

    @Override
    public Page<Employee> findAllEmployeePage(Pageable pageable) {
        return employeeRepository.findAllEmployee(pageable);
    }

    @Override
    public void deleteById(Integer id) {
        employeeRepository.deleteEmployee(id);
    }

    @Override
    public Optional<Employee> findByIdOp(Integer id) {
        return employeeRepository.findEployeeById(id);
    }




}
