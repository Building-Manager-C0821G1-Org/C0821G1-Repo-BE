package com.c0821g1.sprint1.service.impl;

import com.c0821g1.sprint1.entity.employee.Employee;
import com.c0821g1.sprint1.entity.security.AppUser;
import com.c0821g1.sprint1.repository.EmployeeRepository;
import com.c0821g1.sprint1.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    String password = "123456";
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee findEmployeeByID(int id) {
        return employeeRepository.getById(id);
    }

    @Override
    public void editEmployee(Employee employee) {
        employeeRepository.editEmployee(
                employee.getEmployeeAddress(),
                employee.getEmployeeCode(),
                employee.getEmployeeDateOfBirth(),
                employee.getEmployeeDeleteFlag(),
                employee.getEmployeeEmail(),
                employee.getEmployeeGender(),
                employee.getEmployeeImage(),
                employee.getEmployeeName(),
                employee.getEmployeePhone(),
                employee.getEmployeeStartDate(),
                employee.getAppUser().getAppUserId(),
                employee.getEmployeePosition().getEmployeePositionId(),
                employee.getEmployeeId());
    }

    @Override
    public void createEmployeeAccount(AppUser appUser) {
        employeeRepository.createEmployeeAccount(appUser.getAppUserName(), appUser.getAppUserPassword());
    }

    @Override
    public Boolean existsEmployeeByEmail(String employeEmail) {
        return employeeRepository.existsEmployeeByEmail(employeEmail) != null;
    }

    @Override
    public Boolean existsEmployeeByCode(String employeeCode) {
        return employeeRepository.existsEmployeeByCode(employeeCode) != null;
    }

    @Override
    public List<Employee> findALL() {
        return employeeRepository.findAll();
    }


    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
    
   
}
