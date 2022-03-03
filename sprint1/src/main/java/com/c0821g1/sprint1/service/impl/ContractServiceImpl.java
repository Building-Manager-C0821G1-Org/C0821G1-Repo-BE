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
    public Contract findContractById(Integer id) {
        return contractRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    @Override
    public void editContract(ContractDTO contractDTO) {
        contractRepository.editContract(contractDTO.getContractExpred(),
                contractDTO.getContractDateStart()
                ,contractDTO.getContractDateEnd(),
                contractDTO.getContractTotal()
                ,contractDTO.getContractContent(),
                contractDTO.getContractDeleteFlag(),
                contractDTO.getEmployeeId(),
                contractDTO.getCustomerId(),
                contractDTO.getSpaceId()
                ,contractDTO.getContractId());
    }

    @Override
    public void addContract(ContractDTO contractDTO) {
        this.contractRepository
                .saveContract(contractDTO.getContractExpred()
                        ,contractDTO.getContractDateStart()
                        ,contractDTO.getContractDateEnd()
                        ,contractDTO.getContractTotal()
                        ,contractDTO.getContractContent()
                        ,contractDTO.getContractId()
                        ,contractDTO.getContractDeleteFlag()
                        ,contractDTO.getCustomerId()
                        ,contractDTO.getEmployeeId()
                        ,contractDTO.getSpaceId());
    }

//    @Override
//    public void deleteContract(Integer id) {
//        contractRepository.deleteContract(id);
//    }
}
