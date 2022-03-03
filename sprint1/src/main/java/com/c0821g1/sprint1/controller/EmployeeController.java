package com.c0821g1.sprint1.controller;

import com.c0821g1.sprint1.entity.employee.Employee;
import com.c0821g1.sprint1.entity.employee.EmployeePosition;
import com.c0821g1.sprint1.service.EmployeePositionService;
import com.c0821g1.sprint1.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/employee")
@CrossOrigin("http://localhost:4200")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    EmployeePositionService employeePositionService;

//    // Lấy danh sách Position
//    @GetMapping(value = "/position")
//    public ResponseEntity<List<EmployeePosition>> getPosition() {
//        List<EmployeePosition> positions = employeePositionService.findAll();
//        if (positions.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        {
//            return new ResponseEntity<>(positions, HttpStatus.OK);
//        }
//    }

    //Hiển thị danh sách
    @GetMapping(value = "/list")
    public ResponseEntity<Page<Employee>> showListEmployee(@PageableDefault(value = 2) Pageable pageable) {
        Page<Employee> employeeList = employeeService.findAllEmployeePage(pageable);
        if (employeeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    // Tìm kiếm nhân viên
    @GetMapping(value = "/search")
    public ResponseEntity<Page<Employee>> searchEmployeeByNameOrDateOfBirthOrEmailOrAddress(@PageableDefault(value = 2) Pageable pageable,
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
}
