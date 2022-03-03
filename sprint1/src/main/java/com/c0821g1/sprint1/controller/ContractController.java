package com.c0821g1.sprint1.controller;


import com.c0821g1.sprint1.dto.ContractDTO;
import com.c0821g1.sprint1.entity.contract.Contract;
import com.c0821g1.sprint1.service.ContractService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@CrossOrigin
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private ContractService contractService;

    @GetMapping("/list")
    private ResponseEntity<List<Contract>> getListContract() {
        return new ResponseEntity<>(contractService.findAllContract(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    private ResponseEntity<Contract> getContractById(@PathVariable("id") Integer id) {
        Contract contract = contractService.findContractById(id);
        return new ResponseEntity<>(contract, HttpStatus.OK);
    }

    //    Tây chức năng create hợp đồng
    @PostMapping("/add")
    private ResponseEntity<?> addContract(@Valid @RequestBody ContractDTO contractDTO, BindingResult bindingResult) {
        try {
            new ContractDTO().validate(contractDTO, bindingResult);
            if (bindingResult.hasErrors()) {
                return new ResponseEntity<>(bindingResult.getFieldError(), HttpStatus.NOT_MODIFIED);
            }
            Contract contract = new Contract();
            BeanUtils.copyProperties(contractDTO, contract);
            contractService.addContract(contractDTO);
            return new ResponseEntity<>(contractDTO,HttpStatus.CREATED);
        } catch (RuntimeException e){
            e.printStackTrace();
            System.out.println("Lỗi ở create contract ! dòng 51");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


//    Tây chức năng edit hợp đồng
    @PatchMapping("/update/{id}")
    private ResponseEntity<?> updateContract(@Valid @RequestBody ContractDTO contractDTO,BindingResult bindingResult,@PathVariable("id") Integer id) {
        try {
            new ContractDTO().validate(contractDTO,bindingResult);
            if (bindingResult.hasErrors()){
                return new ResponseEntity<>(bindingResult.getFieldError(), HttpStatus.NOT_MODIFIED);
            }

            contractDTO.setContractId(id);
//            Contract contract = new Contract();
//            BeanUtils.copyProperties(contractDTO, contract);
            contractService.editContract(contractDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (RuntimeException e){
            e.printStackTrace();
            System.out.println("Lỗi ở edit contract ! dòng 68");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

//    @DeleteMapping("/delete/{id}")
//    private ResponseEntity<Void> deleteContractById(@PathVariable("id") Integer id) {
//        contractService.deleteContract(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}
