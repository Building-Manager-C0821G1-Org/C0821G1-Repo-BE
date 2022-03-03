package com.c0821g1.sprint1.controller;


import com.c0821g1.sprint1.dto.EmployeeDTO;
import com.c0821g1.sprint1.entity.employee.Employee;
import com.c0821g1.sprint1.entity.employee.Jwt;
import com.c0821g1.sprint1.entity.security.AppUser;
import com.c0821g1.sprint1.entity.security.Role;
import com.c0821g1.sprint1.repository.AppUserRepository;
import com.c0821g1.sprint1.service.AppUserService;
import com.c0821g1.sprint1.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    AppUserService appUserService;


    //Bảo thêm mới nhân viên và đăng ký tài khoản cho nhân viên
    @PostMapping(value = "/create")
    public ResponseEntity<Object> createEmployee(@RequestBody @Valid EmployeeDTO employeeDTO, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getFieldError(), HttpStatus.BAD_REQUEST);
        }
        Employee employee=new Employee();
        BeanUtils.copyProperties(employeeDTO,employee);
//        List<Role> roleList=new ArrayList();
//        Role role =new Role();
//        role.setRoleId(1);
//        roleList.add(role);
        AppUser appUser=new AppUser();
        appUser.setAppUserName(employeeDTO.getEmployeeEmail());
        appUser.setAppUserPassword("123456");
//        appUser.setRoles(roleList);
        employeeService.createEmployeeAccount(appUser);
        appUser=appUserService.findAppUserByEmail(appUser.getAppUserName());
       employee.setAppUser(appUser);
        employeeService.saveEmployee(employee);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    //Bảo chỉnh sửa thông tin nhân viên
    @PatchMapping(value = "/edit/{id}")
    public ResponseEntity<Object> updateEmployee(@RequestBody @Valid EmployeeDTO employeeDTO,
                                                 BindingResult bindingResult){
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO, employee);
//        Employee employee = employeeService.findEmployeeByID(idEdit);
//        BeanUtils.copyProperties(employeeDTO, employee);
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getFieldError(), HttpStatus.BAD_REQUEST);
        }
        employeeService.editEmployee(employeeDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
