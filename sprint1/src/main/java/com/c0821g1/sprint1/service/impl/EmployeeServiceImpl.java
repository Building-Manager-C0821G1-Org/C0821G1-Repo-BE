package com.c0821g1.sprint1.service.impl;

import com.c0821g1.sprint1.dto.EmployeeDTO;
import com.c0821g1.sprint1.entity.employee.Employee;
import com.c0821g1.sprint1.entity.security.AppUser;
import com.c0821g1.sprint1.entity.security.Role;
import com.c0821g1.sprint1.repository.AppUserRepository;
import com.c0821g1.sprint1.repository.EmployeeRepository;
import com.c0821g1.sprint1.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    String password = "123456";
    @Autowired
    EmployeeRepository employeeRepository;
    AppUserRepository appUserRepository;

    @Override
    public void saveEmployee1(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee findEmployeeByID(int id) {
        return employeeRepository.getById(id);
    }

    @Override
    public void editEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO, employee);
        employeeRepository.editEmployee(
                employeeDTO.getEmployeeAddress(),
                employeeDTO.getEmployeeCode(),
                employeeDTO.getEmployeeDateOfBirth(),
                employeeDTO.getEmployeeDeleteFlag(),
                employeeDTO.getEmployeeEmail(),
                employeeDTO.getEmployeeGender(),
                employeeDTO.getEmployeeImage(),
                employeeDTO.getEmployeeName(),
                employeeDTO.getEmployeePhone(),
                employeeDTO.getEmployeeStartDate(),
                employee.getAppUser().getAppUserId(),
                employeeDTO.getEmployeePosition().getEmployeePositionId(),
                employeeDTO.getEmployeeId());
    }

    @Override
    public void createEmployeeAccount(AppUser appUser) {
//        List<Role> roleList = new ArrayList();
//        AppUser appUser = new AppUser();
//        Role role = new Role();
//        role.setRoleId(1);
//        roleList.add(role);
//        appUser.setAppUserName(employeeDTO.getEmployeeEmail());
//        appUser.setAppUserPassword(password);
//        appUser.setRoles(roleList);
//        employee.setAppUser(appUser);
////        appUserRepository.save(appUser);
        employeeRepository.createEmployeeAccount(appUser.getAppUserName(), appUser.getAppUserPassword());
//        employee.setAppUser(appUser);
    }

    @Override
    public void createAcount() {

    }

//    @Override
//    public void createAcount(Employee employee) {
//        employeeRepository.save(employee);
//    }


    @Override
    public void saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO, employee);
//        employeeRepository.save(employee);
        employeeRepository.saveEmployee(
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

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
}
