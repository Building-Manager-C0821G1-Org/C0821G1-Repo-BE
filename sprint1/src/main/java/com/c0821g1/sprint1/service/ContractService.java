package com.c0821g1.sprint1.service;

import com.c0821g1.sprint1.dto.ContractDTO;
import com.c0821g1.sprint1.entity.contract.Contract;

import java.util.List;

public interface ContractService {

    List<Contract> findAllContract();

    Contract findContractById(Integer id);

    void editContract(ContractDTO contractDTO);


    void addContract(ContractDTO contractDTO);

//    void deleteContract(Integer id);
}
