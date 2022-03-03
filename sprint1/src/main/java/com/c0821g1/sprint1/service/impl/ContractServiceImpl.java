package com.c0821g1.sprint1.service.impl;

import com.c0821g1.sprint1.entity.contract.Contract;
import com.c0821g1.sprint1.repository.ContractRepository;
import com.c0821g1.sprint1.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    private ContractRepository contractRepository;

    @Override
    public void delete(Integer contract_id) {
        this.contractRepository.deleteContract(contract_id);
    }

    @Override
    public Page<Contract> findAllContract(Pageable pageable) {
        return this.contractRepository.findAllContract(pageable);
    }

    @Override
    public Page<Contract> findAllContractSearch(Pageable pageable, String name, String code, String start, String end) {
        return this.contractRepository.searchContract(pageable,name,code,start,end);
    }

}
