package com.c0821g1.sprint1.service.impl;

import com.c0821g1.sprint1.dto.ContractDTO;
import com.c0821g1.sprint1.entity.contract.Contract;
import com.c0821g1.sprint1.exception.UserNotFoundException;
import com.c0821g1.sprint1.repository.ContractRepository;
import com.c0821g1.sprint1.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractRepository contractRepository;

    @Override
    public List<Contract> findAllContract() {
        return contractRepository.findAllByContractDeleteFlagIsFalse();
    }

    @Override
    public ContractDTO findContractById(Integer id) {
        Contract contract = contractRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
        ContractDTO contractDTO = new ContractDTO();
        contractDTO.setContractCode(contract.getContractCode());
        contractDTO.setContractId(contract.getContractId());
        contractDTO.setContractExpired(contract.getContractExpired());
        contractDTO.setContractDateStart(contract.getContractDateStart());
        contractDTO.setContractDateEnd(contract.getContractDateEnd());
        contractDTO.setPrice(contract.getPrice());
        contractDTO.setContractTotal(contract.getContractTotal());
        contractDTO.setContractContent(contract.getContractContent());
        contractDTO.setEmployeeId(contract.getEmployee().getEmployeeId());
        contractDTO.setCustomerId(contract.getCustomer().getCustomerId());
        contractDTO.setContractDeposit(contract.getContractDeposit());
        contractDTO.setContractTaxCode(contract.getContractTaxCode());
        contractDTO.setSpaceId(contract.getSpaces().getSpaceId());
        contractDTO.setContractImageUrl(contract.getContractImageUrl());
        contractDTO.setContractDeleteFlag(contract.getContractDeleteFlag());
        return contractDTO;

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
