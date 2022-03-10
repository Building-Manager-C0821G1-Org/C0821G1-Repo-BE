//package com.c0821g1.sprint1.controller;
//
//import com.c0821g1.sprint1.entity.employee.Employee;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.http.ResponseEntity;
//
//@SpringBootTest
//public class EmployeeController_getListEmployee {
//    @Autowired
//    EmployeeController employeeController;
//
//    //  Test trường đầu size bằng 0
//    @Test
//    public void getListEmployee_5() {
//        ResponseEntity<Page<Employee>> responseEntity =
//                employeeController.showListEmployee(PageRequest.of(0, 2));
//        Assertions.assertEquals(400, responseEntity.getStatusCodeValue());
//    }
//    //  Test list trả về mảng json chứa đầu đủ các record trong table, tổng số trang và phân trang.
//    @Test
//    public void getListEmployee_6() {
//        ResponseEntity<Page<Employee>> responseEntity =
//                employeeController.showListEmployee(PageRequest.of(0, 2));
//        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
//        Assertions.assertEquals(2, responseEntity.getBody().getTotalPages());
//        Assertions.assertEquals(4, responseEntity.getBody().getTotalElements());
//        Assertions.assertEquals(1, responseEntity.getBody().getContent().get(0).getEmployeeId());
//        Assertions.assertEquals("12455555", responseEntity.getBody().getContent().get(0).getEmployeeCode());
//        Assertions.assertEquals("be", responseEntity.getBody().getContent().get(0).getEmployeeName());
//        Assertions.assertEquals("1992-10-10", responseEntity.getBody().getContent().get(0).getEmployeeDateOfBirth());
//        Assertions.assertEquals("nam", responseEntity.getBody().getContent().get(0).getEmployeeGender());
//        Assertions.assertEquals("gia lai", responseEntity.getBody().getContent().get(0).getEmployeeAddress());
//        Assertions.assertEquals("hjj@gmail.com", responseEntity.getBody().getContent().get(0).getEmployeeEmail());
//
//    }
//}
