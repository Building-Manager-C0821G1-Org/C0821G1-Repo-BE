package com.c0821g1.sprint1.service.impl;

import com.c0821g1.sprint1.entity.contract.Contract;
import com.c0821g1.sprint1.repository.ContractRepository;
import com.c0821g1.sprint1.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
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
        return contractRepository.findAllContractByNameAndCodeAndDate(name, code, start,end,(org.springframework.data.domain.Pageable) pageable);
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
                contractDTO.getContractCode()
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
                        contractDTO.getContractCode());
    }

    @Override
    public boolean existsContractByCode(String contractCode) {
          return contractRepository.existsContractByCode(contractCode)!=null;
    }
}
