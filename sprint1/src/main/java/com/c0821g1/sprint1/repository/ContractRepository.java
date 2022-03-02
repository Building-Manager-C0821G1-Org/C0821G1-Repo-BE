package com.c0821g1.sprint1.repository;

import com.c0821g1.sprint1.entity.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ContractRepository  extends JpaRepository<Contract,Integer> {
    @Query(value = "select contract.contract_id as id, contract.contract_date_start as dateIn, contract.contract_date_end as dateOut," +
            " customer.customer_code as code, customer.customer_name as name, spaces.space_code as spaces" +
            " from contract " +
            " left join customer on contract.contract_id = customer.customer_id  " +
            " left join spaces on contract.space_id = spaces.space_id  " +
            " where contract.contract_delete_flag = false " +
            " group by contract.contract_id limit ?1,1;", nativeQuery = true)
    List<Contract> findAllContract(int index);





    @Transactional
    @Modifying
    @Query(value = "update contract as c set c.contract_delete_flag = 1 where c.contract_id = ?1", nativeQuery = true)
    void deleteContract(Integer id);
}
