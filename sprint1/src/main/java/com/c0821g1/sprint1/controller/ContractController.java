package com.c0821g1.sprint1.controller;


import com.c0821g1.sprint1.entity.contract.Contract;
import com.c0821g1.sprint1.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("api/contract")
public class ContractController {
    @Qualifier("contractServiceImpl")
    @Autowired
    private ContractService contractService;



    @GetMapping("/list")
    public ResponseEntity<List<Contract>> showListContract(@RequestParam Integer index) {
        List<Contract> contractPage = contractService.findAllContract(index);
        if (contractPage.isEmpty()) {
            return new ResponseEntity<List<Contract>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Contract>>(contractPage, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
//        Optional<Contract> contractOptional = this.contractService.findByIdOp(id);
//        if (!contractOptional.isPresent()){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
        this.contractService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

