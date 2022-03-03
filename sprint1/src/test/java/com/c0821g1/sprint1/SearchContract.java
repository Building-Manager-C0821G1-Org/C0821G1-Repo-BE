package com.c0821g1.sprint1;

import com.c0821g1.sprint1.controller.ContractController;
import com.c0821g1.sprint1.entity.contract.Contract;
import com.c0821g1.sprint1.entity.customer.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class SearchContract {
    @Autowired
    ContractController contractController;
    Customer customer;

    // search trường name
    @Test
    public void searchContractName(){
        ResponseEntity<Page<Contract>> responseEntity
                = contractController.searchContractNameAndCode
                (PageRequest.of(0,2),"nguyen van dong","","","");
        Assertions.assertEquals(200,responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("nguyen van dong",responseEntity.getBody().getContent().get(0).getCustomer().getCustomerName());
    }
    // search trường ngày bắt đầu
    @Test
    public void searchContractDateStar(){
        ResponseEntity<Page<Contract>> responseEntity
                = contractController.searchContractNameAndCode
                (PageRequest.of(0,2),"","","2020-05-05","");
        Assertions.assertEquals(200,responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("2020-05-05",responseEntity.getBody().getContent().get(0).getContractDateStart());
    }
    // search trường ngày kết thúc
    @Test
    public void searchContractDateEnd(){
        ResponseEntity<Page<Contract>> responseEntity
                = contractController.searchContractNameAndCode
                (PageRequest.of(0,2),"","","","2020-10-10");
        Assertions.assertEquals(200,responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("2020-10-10",responseEntity.getBody().getContent().get(0).getContractDateEnd());
    }

    // search trường code
    @Test
    public void searchContractCode(){
        ResponseEntity<Page<Contract>> responseEntity
                = contractController.searchContractNameAndCode
                (PageRequest.of(0,2),"","mt001","","");
        Assertions.assertEquals(200,responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("mt001",responseEntity.getBody().getContent().get(0).getSpaces().getSpaceCode());
    }
}
