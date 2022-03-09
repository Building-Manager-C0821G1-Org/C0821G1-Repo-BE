package com.c0821g1.sprint1.controller;


import com.c0821g1.sprint1.dto.ContractDTO;
import com.c0821g1.sprint1.entity.contract.Contract;
import com.c0821g1.sprint1.service.ContractService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private ContractService contractService;


    @GetMapping("/list")
    public ResponseEntity<List<Contract>> getListContract() {
        List<Contract> contractList = contractService.findAllContract();
        return new ResponseEntity<>(contractList, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<ContractDTO> getContractById(@PathVariable("id") Integer id) {
        ContractDTO contractDTO = contractService.findContractById(id);
        return new ResponseEntity<>(contractDTO, HttpStatus.OK);
    }

    //    Tây chức năng create hợp đồng
    @PostMapping("/add")
    public ResponseEntity<Object> addContract(@Valid @RequestBody ContractDTO contractDTO, BindingResult bindingResult) {

            if(contractService.existsContractByCode(contractDTO.getContractCode())){
                bindingResult.rejectValue("contractCode", "Mã hợp đồng đã tồn tại.");
                return new ResponseEntity<>(bindingResult.getFieldError(), HttpStatus.BAD_REQUEST);
            }

            new ContractDTO().validate(contractDTO, bindingResult);
            if (bindingResult.hasErrors()) {
                return new ResponseEntity<>(bindingResult.getFieldError(), HttpStatus.NOT_MODIFIED);
            }
            Contract contract = new Contract();
            BeanUtils.copyProperties(contractDTO, contract);
            contractService.addContract(contractDTO);
            return new ResponseEntity<>(contractDTO,HttpStatus.CREATED);


    }


//    Tây chức năng edit hợp đồng
    @PatchMapping("/update/{id}")
    public ResponseEntity<Object> updateContract(@Valid @RequestBody ContractDTO contractDTO,BindingResult bindingResult,@PathVariable("id") Integer id) {
        try {
            new ContractDTO().validate(contractDTO,bindingResult);
            if (bindingResult.hasErrors()){
                return new ResponseEntity<>(bindingResult.getFieldError(), HttpStatus.NOT_MODIFIED);
            }

            contractDTO.setContractId(id);
            contractService.editContract(contractDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (RuntimeException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}
