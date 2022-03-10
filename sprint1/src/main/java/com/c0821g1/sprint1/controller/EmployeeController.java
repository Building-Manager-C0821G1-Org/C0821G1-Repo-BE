package com.c0821g1.sprint1.controller;

<<<<<<< HEAD
import com.c0821g1.sprint1.entity.employee.Employee;
import com.c0821g1.sprint1.service.EmployeePositionService;
import com.c0821g1.sprint1.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;

import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/employee")
@CrossOrigin("http://localhost:4200")
=======

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
>>>>>>> employee-create-BaoNHG
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
<<<<<<< HEAD
    EmployeePositionService employeePositionService;

    //Hiển thị danh sách
    @GetMapping(value = "/list")
    public ResponseEntity<Page<Employee>> showListEmployee(@PageableDefault(value = 5) Pageable pageable) {
        Page<Employee> employeeList = employeeService.findAllEmployeePage(pageable);
        if (employeeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    // Tìm kiếm nhân viên
    @GetMapping(value = "/search")
    public ResponseEntity<Page<Employee>> searchEmployeeByNameOrDateOfBirthOrEmailOrAddress(@PageableDefault(value = 5) Pageable pageable,
                                                                                            @RequestParam(defaultValue = "") String employee_name,
                                                                                            @RequestParam(defaultValue = "") String employee_date_of_birth,
                                                                                            @RequestParam(defaultValue = "") String employee_email,
                                                                                            @RequestParam(defaultValue = "") String employee_address
    ) {
        Page<Employee> employeeListSearch = employeeService.findAllEmployeeSearch(pageable, employee_name,
                employee_date_of_birth, employee_email, employee_address);
        if (employeeListSearch.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employeeListSearch, HttpStatus.OK);
    }

    // xóa nhân viên.
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Employee> deleteEmployees(@PathVariable("id") Integer id) {
        Optional<Employee> employeeOptional = this.employeeService.findByIdOp(id);
        if (!employeeOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        employeeService.deleteById(id);
        return new ResponseEntity<>(employeeOptional.get(), HttpStatus.OK);
    }
    // lấy id nhân viên
    @GetMapping(value = "/detail/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Integer id){
        Optional<Employee> employee = employeeService.findByIdOp(id);
        if(!employee.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employee.get(),HttpStatus.OK);
    }
}


    AppUserService appUserService;




    //Bảo chỉnh sửa thông tin nhân viên
    @PatchMapping(value = "/update/{id}")
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
            role.setRoleId(1);
        } else {
            role.setRoleId(2);
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



}

>>>>>>> employee-create-BaoNHG
