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

import java.util.Optional;

@Repository
public interface ContractRepository  extends JpaRepository<Contract,Integer> {
    @Transactional
    @Modifying

//      xoá contract
//      Đông nguyễn
    @Query(value = "update contract set contract_delete_flag = 1 where contract_id = ?", nativeQuery = true)
    void deleteContract(Integer id);

//      list + page + search contract
//      Đông nguyễn
    @Query(value = " select * from contract \n" +
            " left Join customer on contract.customer_id = customer.customer_id \n" +
            " left Join spaces on contract.space_id = spaces.space_id \n" +
            " where contract.contract_delete_flag = 0 and customer.customer_name like concat('%',:name,'%') \n" +
            " and spaces.space_code like concat('%',:code,'%') \n" +
            " and contract.contract_date_start like concat('%',:start,'%') \n" +
            " and contract.contract_date_end like concat('%',:end,'%')", nativeQuery = true,
            countQuery = " select count(*) from contract \n " +
                    " left Join customer on contract.customer_id = customer.customer_id \n" +
                    " left Join spaces on contract.space_id = spaces.space_id \n" +
                    " where contract.contract_delete_flag = 0 and customer.customer_name like concat('%',:name,'%') \n" +
                    " and spaces.space_code like concat('%',:code,'%') \n" +
                    " and contract.contract_date_start like concat('%',:start,'%') \n" +
                    " and contract.contract_date_end like concat('%',:end,'%')")
    Page<Contract> findAllContractByNameAndCodeAndDate(@Param("name") String name,
                                                         @Param("code") String code,
                                                        @Param("start") String start,
                                                         @Param("end") String end,
                                                         @Param("page") Pageable pageable);
//      lấy id contract
//      Đông nguyễn
    @Query(value = "SELECT * FROM contract WHERE contract.contract_id = ?", nativeQuery = true)
    Optional<Contract> findContractById(Integer id);
}