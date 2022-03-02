package com.c0821g1.sprint1.service.impl;

import com.c0821g1.sprint1.dto.EmployeeDTO;
import com.c0821g1.sprint1.entity.employee.Employee;
import com.c0821g1.sprint1.repository.EmployeeRepository;
import com.c0821g1.sprint1.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    String password ="123456";
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee findEmployeeByID(int id) {
        return employeeRepository.getById(id);
    }

    @Override
    public void editEmployee(EmployeeDTO employeeDTO) {
        Employee employee=new Employee();
        BeanUtils.copyProperties(employeeDTO,employee);
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
                employeeDTO.getEmployeeId());
    }

    @Override
    public void createEmployeeAccount(EmployeeDTO employeeDTO) {
        Employee employee=new Employee();
        BeanUtils.copyProperties(employeeDTO,employee);
        employeeRepository.createEmployeeAccount(employeeDTO.getEmployeeEmail(),password);}


    @Override
    public void saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee=new Employee();
        BeanUtils.copyProperties(employeeDTO,employee);
//        employeeRepository.save(employee);
        employeeRepository.saveEmployee(employeeDTO.getEmployeeId(),
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
                employee.getEmployeePosition().getEmployeePositionId());
    }
}
