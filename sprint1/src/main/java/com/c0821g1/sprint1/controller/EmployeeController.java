package com.c0821g1.sprint1.controller;


import com.c0821g1.sprint1.dto.EmployeeDTO;
import com.c0821g1.sprint1.entity.employee.Employee;
import com.c0821g1.sprint1.entity.employee.Jwt;
import com.c0821g1.sprint1.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping(value = "/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping(value = "/create")
    public ResponseEntity<Object> createEmployee(@RequestBody @Valid EmployeeDTO employeeDTO, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getFieldError(), HttpStatus.BAD_REQUEST);
        }
        Employee employee=new Employee();
        BeanUtils.copyProperties(employeeDTO,employee);
        employeeService.saveEmployee(employeeDTO);
        employeeService.createEmployeeAccount(employeeDTO);
//        Jwt jwt = new Jwt();
//        jwt.setUsername(employeeDTO.getEmployeeEmail());
//        jwt.setPass("123456");
//        if(employeeDTO.getEmployeePosition().getEmployeePositionId()==1){
//            jwt.setRoles("EMPLOYEE");
//        }
//        else {
//            jwt.setRoles("ADMIN");
//        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
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

//    @GetMapping(value = "/list")
//    public ResponseEntity<Jwt> list(){
//        Jwt jwt1 = new Jwt();
//        return new ResponseEntity<>(jwt1, HttpStatus.OK);
//    }
}
