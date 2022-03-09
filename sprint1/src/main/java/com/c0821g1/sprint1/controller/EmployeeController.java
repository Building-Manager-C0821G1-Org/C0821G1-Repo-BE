package com.c0821g1.sprint1.controller;


import com.c0821g1.sprint1.entity.employee.Employee;
import com.c0821g1.sprint1.entity.user.User;
import com.c0821g1.sprint1.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//
//@CrossOrigin("http://localhost:4200")

@RequestMapping("/api/employee")
public class EmployeeController<IEmployeeService> {

    @Autowired
    EmployeeService iEmployeeService;

    @GetMapping(value = "/list")
    public ResponseEntity<Employee> showEmployee(@RequestParam String username) {
        Employee employees = iEmployeeService.findEmployeeByAppUser(username);
        if (employees==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Employee> getById(@PathVariable Integer id) {
        Employee employee =iEmployeeService.findById(id);
        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>( employee ,HttpStatus.OK);
    }
//    @Autowired private EmployeeService EmployeeService;
//    @GetMapping(value = "/customer-list")
//    public ResponseEntity<Employee> detail() {
//        return new ResponseEntity<>(employeeListSearch, HttpStatus.OK);
//    }
}