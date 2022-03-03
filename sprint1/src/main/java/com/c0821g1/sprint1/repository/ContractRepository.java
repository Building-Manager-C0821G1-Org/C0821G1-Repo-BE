package com.c0821g1.sprint1.repository;

import com.c0821g1.sprint1.entity.contract.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ContractRepository extends JpaRepository<Contract, Integer> {


    List<Contract> findAllByContractDeleteFlagIsFalse();

    @Query(value = "select * from contract where contract_id = ?", nativeQuery = true)
    Optional<Contract> findById(Integer id);

    //    Tây chỉnh sửa hợp đồng
    @Transactional
    @Modifying
    @Query(value = "update Contract as c " +
            "set c.contract_expired =?1,c.contract_date_start =?2,c.contract_date_end =?3" +
            ",c.contract_total =?4,c.contract_content =?5," +
            "c.contract_delete_flag =?6,c.employee_id =?7," +
            "c.customer_id =?8,c.space_id= ?9 where contract_id =?10", nativeQuery = true)
    void editContract(String contract_expired, String contract_date_start,
                      String contract_date_end, String contract_total, String contract_content, Boolean delete_flag
            , Integer employee_id, Integer customer_id, Integer space_id, Integer contract_id);

    //    Tây thêm mới hợp đồng
    @Modifying
    @Transactional
    @Query(value = "insert into Contract(contract_expired,contract_date_start," +
            "contract_date_end,contract_total," +
            "contract_content,contract_id,contract_delete_flag,customer_id,employee_id,space_id) " +
            "values (?1,?2,?3,?4,?5,?6,?7,?8,?9,?10)", nativeQuery = true)
    void saveContract(String contract_expired, String contract_date_start,
                      String contract_date_end, String contract_total, String contract_content,
                      Integer contract_id, Boolean delete_flag,Integer customer_id,Integer employee_id,Integer space_id);


//    @Transactional
//    @Modifying
//    @Query(value = "update Contract as c set c.contract_delete_flag = 1 where c.contract_id = ?1", nativeQuery = true)
//    void deleteContract(Integer contract_id);
}
