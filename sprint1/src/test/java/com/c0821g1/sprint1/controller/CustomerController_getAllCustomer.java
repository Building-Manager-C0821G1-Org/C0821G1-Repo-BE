//package com.c0821g1.sprint1.controller;
//
//import com.c0821g1.sprint1.entity.customer.Customer;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.http.ResponseEntity;
//
//@SpringBootTest
//public class CustomerController_getAllCustomer {
//
//    @Autowired
//    private CustomerController customerController;
//
//    //      VyLTT- customer list - size = 0
//    @Test
//    public void getListCustomer_5() {
//        ResponseEntity<Page<Customer>> responseEntity
//                = this.customerController.showListCustomer(PageRequest.of(0, 4));  //giả pageable
//
//        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
//    }
//
//    //      VyLTT- customer list - size > 0
//    @Test
//    public void getListCustomer_6() {
//        ResponseEntity<Page<Customer>> responseEntity
//                = this.customerController.showListCustomer(PageRequest.of(0, 4));
//
//        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
//        Assertions.assertEquals(2, responseEntity.getBody().getTotalPages());
//        Assertions.assertEquals(7, responseEntity.getBody().getTotalElements());
//        Assertions.assertEquals("Nguyễn Văn Tiến",
//                responseEntity.getBody().getContent().get(3).getCustomerName());
//        Assertions.assertEquals("01-01-1988",
//                responseEntity.getBody().getContent().get(3).getCustomerDateOfBirth());
//    }
//}
