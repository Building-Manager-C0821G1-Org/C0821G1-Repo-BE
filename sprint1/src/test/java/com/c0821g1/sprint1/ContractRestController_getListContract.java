//package com.c0821g1.sprint1;
//
//import com.c0821g1.sprint1.controller.ContractController;
//import com.c0821g1.sprint1.entity.contract.Contract;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.http.ResponseEntity;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//@SpringBootTest
//
//public class ContractRestController_getListContract {
//    private SimpleDateFormat simpleDateFormat;
//    private Date date;
//
//    @Autowired
//    private ContractController contractController;
//
//    @Test
//    public void getListContract_5() {
//
//        ResponseEntity<Page<Contract>> responseEntity
//                = this.contractController.showListContract(PageRequest.of(0, 2));
//
//        Assertions.assertEquals(404, responseEntity.getStatusCodeValue());
//    }
//
//    @Test
//    public void getListContract_6() {
//        ResponseEntity<Page<Contract>> responseEntity
//                = this.contractController.showListContract(PageRequest.of(0, 2));
//
//        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
//        Assertions.assertEquals(2, responseEntity.getBody().getTotalPages());
//        Assertions.assertEquals(4, responseEntity.getBody().getTotalElements());
//        Assertions.assertEquals(1, responseEntity.getBody().getContent().get(0).getContractId());
//
////        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = null;
//        Date date1 = null;
//        try {
//            date = formatter.parse("2020-05-05");
//            date1 = formatter.parse("2020-10-09");
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        Assertions.assertEquals(date, responseEntity.getBody().getContent().get(0).getContractDateStart());
//        Assertions.assertEquals(date1, responseEntity.getBody().getContent().get(0).getContractDateEnd());
//        Assertions.assertEquals("hd1", responseEntity.getBody().getContent().get(0).getContractContent());
//        Assertions.assertEquals("123d", responseEntity.getBody().getContent().get(0).getContractTotal());
//    }
//
//
//}