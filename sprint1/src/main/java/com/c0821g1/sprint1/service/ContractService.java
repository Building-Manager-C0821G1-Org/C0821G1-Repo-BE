package com.c0821g1.sprint1.service;

import com.c0821g1.sprint1.entity.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ContractService {
    List<Contract> findAllContract(int index);
    void delete(Integer id);
}
