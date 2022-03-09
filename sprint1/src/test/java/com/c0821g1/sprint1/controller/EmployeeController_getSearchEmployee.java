//package com.c0821g1.sprint1.controller;
//
//import com.c0821g1.sprint1.entity.employee.Employee;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.http.ResponseEntity;
//
//@SpringBootTest
//public class EmployeeController_getSearchEmployee {
//    @Autowired
//    EmployeeController employeeController;
//
//    // search trường name
//    @Test
//    public void searchEmployeeName(){
//        ResponseEntity<Page<Employee>> responseEntity
//                = employeeController.searchEmployeeByNameOrDateOfBirthOrEmailOrAddress
//                (PageRequest.of(0,2),"be","","","");
//        Assertions.assertEquals(200,responseEntity.getStatusCodeValue());
//        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
//        Assertions.assertEquals(1, responseEntity.getBody().getTotalElements());
//        Assertions.assertEquals("be",responseEntity.getBody().getContent().get(0).getEmployeeName());
//    }
//
//    // search trường dateOfBirth
//    @Test
//    public void searchEmployeeDateOfBirth(){
//        ResponseEntity<Page<Employee>> responseEntity
//                = employeeController.searchEmployeeByNameOrDateOfBirthOrEmailOrAddress
//                (PageRequest.of(0,2),"","1992-10-10","","");
//        Assertions.assertEquals(200,responseEntity.getStatusCodeValue());
//        Assertions.assertEquals(2, responseEntity.getBody().getTotalPages());
//        Assertions.assertEquals(3, responseEntity.getBody().getTotalElements());
//        Assertions.assertEquals("1992-10-10",responseEntity.getBody().getContent().get(0).getEmployeeDateOfBirth());
//    }
//    // search trường email
//    @Test
//    public void searchEmployeeEmail(){
//        ResponseEntity<Page<Employee>> responseEntity
//                = employeeController.searchEmployeeByNameOrDateOfBirthOrEmailOrAddress
//                (PageRequest.of(0,2),"","","hjj@gmail.com","");
//        Assertions.assertEquals(200,responseEntity.getStatusCodeValue());
//        Assertions.assertEquals(2, responseEntity.getBody().getTotalPages());
//        Assertions.assertEquals(3, responseEntity.getBody().getTotalElements());
//        Assertions.assertEquals("hjj@gmail.com",responseEntity.getBody().getContent().get(0).getEmployeeEmail());
//    }
//    // search trường address
//    @Test
//    public void searchEmployeeAddress(){
//        ResponseEntity<Page<Employee>> responseEntity
//                = employeeController.searchEmployeeByNameOrDateOfBirthOrEmailOrAddress
//                (PageRequest.of(0,2),"","","","gia lai");
//        Assertions.assertEquals(200,responseEntity.getStatusCodeValue());
//        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
//        Assertions.assertEquals(1, responseEntity.getBody().getTotalElements());
//        Assertions.assertEquals("gia lai",responseEntity.getBody().getContent().get(0).getEmployeeAddress());
//    }
//    // search để rỗng sẽ ra hêt 4 đối tượng và nằm trong 2 trang
//    @Test
//    public void searchEmployeeEmpty(){
//        ResponseEntity<Page<Employee>> responseEntity
//                = employeeController.searchEmployeeByNameOrDateOfBirthOrEmailOrAddress
//                (PageRequest.of(0,2),"","","","");
//        Assertions.assertEquals(200,responseEntity.getStatusCodeValue());
//        Assertions.assertEquals(2, responseEntity.getBody().getTotalPages());
//        Assertions.assertEquals(4, responseEntity.getBody().getTotalElements());
//        Assertions.assertEquals("be",responseEntity.getBody().getContent().get(0).getEmployeeName());
//        Assertions.assertEquals("1992-10-10",responseEntity.getBody().getContent().get(0).getEmployeeDateOfBirth());
//        Assertions.assertEquals("hjj@gmail.com",responseEntity.getBody().getContent().get(0).getEmployeeEmail());
//        Assertions.assertEquals("gia lai",responseEntity.getBody().getContent().get(0).getEmployeeAddress());
//
//    }
//    // search 4 trường sẽ ra được 1 đối tượng và 1 trang
//    @Test
//    public void searchEmployee(){
//        ResponseEntity<Page<Employee>> responseEntity
//                = employeeController.searchEmployeeByNameOrDateOfBirthOrEmailOrAddress
//                (PageRequest.of(0,2),"be","1992-10-10","hjj@gmail.com","gia lai");
//        Assertions.assertEquals(200,responseEntity.getStatusCodeValue());
//        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
//        Assertions.assertEquals(1, responseEntity.getBody().getTotalElements());
//        Assertions.assertEquals("be",responseEntity.getBody().getContent().get(0).getEmployeeName());
//        Assertions.assertEquals("1992-10-10",responseEntity.getBody().getContent().get(0).getEmployeeDateOfBirth());
//        Assertions.assertEquals("hjj@gmail.com",responseEntity.getBody().getContent().get(0).getEmployeeEmail());
//        Assertions.assertEquals("gia lai",responseEntity.getBody().getContent().get(0).getEmployeeAddress());
//    }
//}
