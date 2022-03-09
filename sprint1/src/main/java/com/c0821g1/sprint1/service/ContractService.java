package com.c0821g1.sprint1.service;

import com.c0821g1.sprint1.entity.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ContractService {
    void deleteContract(Integer id);
    Page<Contract> findAllContractByNameAndCodeAndDatePage(String name, String code, String start , String end, Pageable pageable);
    Optional<Contract> findContractById(Integer id);
}
