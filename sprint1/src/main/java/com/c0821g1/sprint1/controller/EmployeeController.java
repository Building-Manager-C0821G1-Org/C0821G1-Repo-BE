package com.c0821g1.sprint1.controller;


import com.c0821g1.sprint1.dto.EmployeeDTO;
import com.c0821g1.sprint1.entity.employee.Employee;
import com.c0821g1.sprint1.entity.security.AppUser;
import com.c0821g1.sprint1.entity.security.Role;
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
    public ResponseEntity<Object> createEmployee(@RequestBody @Valid EmployeeDTO employeeDTO, BindingResult bindingResult) {


//        Kiểm tra email và mã nhân viên có tồn tại trong DB hay không
        if(employeeService.existsEmployeeByCode(employeeDTO.getEmployeeCode())){
            System.out.println("Test");
            bindingResult.rejectValue("employeeCode", "Mã nhân viên đã tồn tại!");
        }
        if(employeeService.existsEmployeeByEmail(employeeDTO.getEmployeeEmail())){
            System.out.println("Test");
            bindingResult.rejectValue("employeeEmail", "Email đã tồn tại!");
        }
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldError(), HttpStatus.BAD_REQUEST);
        }
        //tạo tài khoản cho nhân viên với username là email và mật khẩu mặc định là 123456
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO, employee);
        AppUser appUser = new AppUser();
        appUser.setAppUserName(employee.getEmployeeEmail());
        appUser.setAppUserPassword("123456");
        employeeService.createEmployeeAccount(appUser);
        appUser = appUserService.findAppUserByEmail(appUser.getAppUserName());
        employee.setAppUser(appUser);

        //set role
        List<Role> roleList = new ArrayList<>();
        Role role = new Role();
        if (employee.getEmployeePosition().getEmployeePositionId() == 1) {
            role.setRoleId(2);
        } else {
            role.setRoleId(1);
        }
        roleList.add(role);
        appUser.setRoles(roleList);

        //tạo mới nhân viên
        employee.setEmployeeDeleteFlag(false);
        employeeService.saveEmployee(employee);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    //Bảo chỉnh sửa thông tin nhân viên
    @PatchMapping(value = "/edit/{id}")
    public ResponseEntity<Object> updateEmployee(@RequestBody @Valid EmployeeDTO employeeDTO,
                                                 BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldError(), HttpStatus.BAD_REQUEST);
        }



        //set role
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO, employee);
        AppUser appUser = appUserService.findAppUserByEmail(employeeDTO.getAppUser().getAppUserName());
        List<Role> roleList =new ArrayList<>();
        Role role = new Role();
        if (employee.getEmployeePosition().getEmployeePositionId() == 1) {
            role.setRoleId(2);
        } else {
            role.setRoleId(1);
        }
        roleList.add(role);
        appUser.setRoles(roleList);

        // chỉnh sửa nhân viên
        employeeService.editEmployee(employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    //  Bảo tìm kiếm nhân viên theo id
    @GetMapping(value = "/{id}")
    public ResponseEntity<Employee> findByID(@PathVariable Integer id) {
        return new ResponseEntity<>(employeeService.findEmployeeByID(id), HttpStatus.OK);
    }

    @GetMapping(value = "/list")
    public ResponseEntity<Object> getListEmployee(){
        List<Employee> employeeList = employeeService.findALL();
        return new ResponseEntity<>(employeeList,HttpStatus.OK);
    }

}
