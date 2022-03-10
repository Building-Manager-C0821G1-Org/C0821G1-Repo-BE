package com.c0821g1.sprint1.service.impl.employee;

import com.c0821g1.sprint1.entity.employee.Employee;
import com.c0821g1.sprint1.entity.security.AppUser;
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

    //Bảo sửa thông tin nhân viên
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


    //Bảo tạo mới tài khoản nhân viên
    @Override
    public void createEmployeeAccount(AppUser appUser) {
        employeeRepository.createEmployeeAccount(appUser.getAppUserName(), appUser.getAppUserPassword());
    }

    //Bảo kiểm tra email có tồn tại trong DB
    @Override
    public Boolean existsEmployeeByEmail(String employeEmail) {
        return employeeRepository.existsEmployeeByEmail(employeEmail) != null;
    }

    //Bảo kiểm tra Code có tồn tại trong DB
    @Override
    public Boolean existsEmployeeByCode(String employeeCode) {
        return employeeRepository.existsEmployeeByCode(employeeCode) != null;
    }


    //Bảo thêm mới nhân viên
    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }




}
