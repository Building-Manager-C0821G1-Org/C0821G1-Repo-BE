package com.c0821g1.sprint1.controller;

import com.c0821g1.sprint1.entity.employee.EmployeePosition;
import com.c0821g1.sprint1.service.EmployeePositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/employeePosition")
public class EmployeePossitionController {
    @Autowired
    EmployeePositionService employeePositionService;
    @GetMapping(value ="/list")
    public ResponseEntity<Object> getListEmployeePossition(){
        List<EmployeePosition> employeePositionList = employeePositionService.findAll();
        return new ResponseEntity<>(employeePositionList,HttpStatus.OK);
    }
}
