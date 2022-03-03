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
    @Query(value = "select * from contract where contract_delete_flag = 0 ", nativeQuery = true)
    Page<Contract> findAllContract(Pageable pageable);


    @Transactional
    @Modifying
    @Query(value = "update contract as c set c.contract_delete_flag = 0 where c.contract_id = ?1", nativeQuery = true)
    void deleteContract(Integer id);

    @Query(value = " select contract.contract_id, spaces.space_code, customer.customer_name, contract.contract_date_start, contract.contract_date_end, contract.contract_content, contract.contract_expred, contract.customer_id, contract.space_id, contract.employee_id, contract.contract_total, contract.contract_delete_flag" +
            " from contract" +
            " left Join customer on contract.customer_id = customer.customer_id" +
            " left Join spaces on contract.space_id = spaces.space_id" +
            " where customer.customer_name like concat('%',:name,'%')  and  spaces.space_code like concat('%',:code,'%') and (contract.contract_date_start >= like concat('%',:start,'%')) and (contract.contract_date_end <= like concat('%',:end,'%')) and contract.contract_delete_flag = 0", nativeQuery = true)
    Page<Contract> searchContract(Pageable pageable, @Param("name") String name, @Param("code") String code, @Param("start") String start, @Param("end") String end);

}