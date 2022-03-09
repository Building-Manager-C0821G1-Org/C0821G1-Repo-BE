package com.c0821g1.sprint1.controller;


import com.c0821g1.sprint1.entity.contract.Contract;
import com.c0821g1.sprint1.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("api/contract")
public class ContractController {

    @Qualifier("contractServiceImpl")

    @Autowired
    private ContractService contractService;


//      tim kiem + phan trang
//      Đông nguyễn
    @GetMapping("/contract-list")
    public ResponseEntity<Page<Contract>> findContractByNameAndCodeAndDate(
            @RequestParam(defaultValue = "") String name,
            @RequestParam(defaultValue = "") String code,
            @RequestParam(defaultValue = "") String start,
            @RequestParam(defaultValue = "") String end,
            @RequestParam(defaultValue = "0") int page
    ) {
        Pageable pageable = PageRequest.of(page, 2);
        Page<Contract> contractNewPage = contractService.findAllContractByNameAndCodeAndDatePage(name,code,start,end,pageable);

        if (contractNewPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(contractNewPage, HttpStatus.OK);

    }

//      Xoá danh sách hợp đồng
//      Đông nguyễn
    @DeleteMapping("delete-contract/{id}")
    public ResponseEntity<Contract> deleteCustomer(@PathVariable Integer id) {
        Optional<Contract> contractOptional = contractService.findContractById(id);
        if (!contractOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        contractService.deleteContract(id);
        return new ResponseEntity<>(contractOptional.get(), HttpStatus.NO_CONTENT);
    }

//      Xoá danh sách hợp đồng
//      Đông nguyễn
    @GetMapping("/{id}")
    public ResponseEntity<Object> findContractById(@PathVariable Integer id){
        Optional<Contract> contractOptional = contractService.findContractById(id);
        if (!contractOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(contractOptional,HttpStatus.OK);
    }

}

