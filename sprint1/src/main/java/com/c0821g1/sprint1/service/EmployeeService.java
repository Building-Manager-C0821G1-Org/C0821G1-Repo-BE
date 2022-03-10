package com.c0821g1.sprint1.service;

<<<<<<< HEAD
import com.c0821g1.sprint1.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface EmployeeService {
    Page<Employee> findAllEmployeeSearch(Pageable pageable, String employee_name, String employee_date_0f_birth, String employee_email, String employee_address);

    Page<Employee> findAllEmployeePage(Pageable pageable);

    void deleteById(Integer id);

    Optional<Employee> findByIdOp(Integer id);


=======

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
>>>>>>> employee-create-BaoNHG
}
