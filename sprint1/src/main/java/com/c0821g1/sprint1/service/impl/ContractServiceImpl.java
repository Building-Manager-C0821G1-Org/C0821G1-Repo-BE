package com.c0821g1.sprint1.service.impl;

import com.c0821g1.sprint1.entity.contract.Contract;
import com.c0821g1.sprint1.repository.ContractRepository;
import com.c0821g1.sprint1.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import com.c0821g1.sprint1.dto.ContractDTO;
import com.c0821g1.sprint1.exception.UserNotFoundException;


import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractRepository contractRepository;

    @Override
    public void deleteContract(Integer id) {
        this.contractRepository.deleteContract(id);
    }

    @Override
    public Page<Contract> findAllContractByNameAndCodeAndDatePage(String name, String code, String start, String end, Pageable pageable) {
        return contractRepository.findAllContractByNameAndCodeAndDate(name, code, start, end,(org.springframework.data.domain.Pageable) pageable);
    }

    @Override
    public Optional<Contract> findContractById(Integer id) {
        return this.contractRepository.findContractById(id);
    }



    @Override
    public void editContract(ContractDTO contractDTO) {
        contractRepository.editContract(contractDTO.getContractExpired(),
                contractDTO.getContractDateStart()
                ,contractDTO.getContractDateEnd(),
                contractDTO.getContractTotal()
                ,contractDTO.getContractContent(),
                contractDTO.getContractDeleteFlag(),
                contractDTO.getEmployeeId(),
                contractDTO.getCustomerId(),
                contractDTO.getSpaceId(),
                contractDTO.getPrice(),
                contractDTO.getContractDeposit(),
                contractDTO.getContractTaxCode(),
                contractDTO.getContractImageUrl(),
                contractDTO.getContractCode(),
                contractDTO.getCheckFlag()
                ,contractDTO.getContractId());
    }

    @Override
    public void addContract(ContractDTO contractDTO) {
        this.contractRepository
                .saveContract(contractDTO.getContractExpired()
                        ,contractDTO.getContractDateStart()
                        ,contractDTO.getContractDateEnd()
                        ,contractDTO.getContractTotal()
                        ,contractDTO.getContractContent()
                        ,contractDTO.getContractId()
                        ,contractDTO.getContractDeleteFlag()
                        ,contractDTO.getCustomerId()
                        ,contractDTO.getEmployeeId()
                        ,contractDTO.getSpaceId(),
                         contractDTO.getPrice(),
                        contractDTO.getContractDeposit(),
                        contractDTO.getContractTaxCode(),
                        contractDTO.getContractImageUrl(),
                        contractDTO.getContractCode(),
                        contractDTO.getCheckFlag());
    }

    @Override
    public boolean existsContractByCode(String contractCode) {
          return contractRepository.existsContractByCode(contractCode)!=null;
    }

    @Override
    public boolean checkDate(String date, String date2) {
        if (date.equals("") | date2.equals("")){
            return false;
        }
        System.out.println(date);
        System.out.println(date2);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date1 = simpleDateFormat.parse(date);
            Date date3 = simpleDateFormat.parse(date2);
            if (date1.after(date3)){
                return true;
            } else return false;
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }
}
