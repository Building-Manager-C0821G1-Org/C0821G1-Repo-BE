package com.c0821g1.sprint1.repository;

import com.c0821g1.sprint1.entity.contract.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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
            "c.customer_id =?8,c.space_id= ?9,c.price= ?10,c.contract_deposit= ?11,c.contract_tax_code = ?12,c.contract_image_url = ?13,c.contract_code =?14 where contract_id =?15", nativeQuery = true)
    void editContract(Integer contractexpired, String contractdatestart,
                      String contractdateend, Integer contracttotal, String contractcontent, Boolean deleteflag
            , Integer employeeid, Integer customerid, Integer spaceid,Integer price
            ,Integer contractdeposit,String contracttaxcode,String contractimageurl,String code,Integer contractid);

    //    Tây thêm mới hợp đồng
    @Modifying
    @Transactional
    @Query(value = "insert into Contract(contract_expired,contract_date_start," +
            "contract_date_end,contract_total," +
            "contract_content,contract_id,contract_delete_flag,customer_id,employee_id,space_id,price,contract_deposit,contract_tax_code,contract_image_url,contract_code) " +
            "values (?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11,?12,?13,?14,?15)", nativeQuery = true)
    void saveContract(Integer contractExpired, String contractDatestart,
                      String contractdateend, Integer contracttotal, String contractcontent,
                      Integer contractid, Boolean deleteflag,Integer customerid,
                      Integer employeeid,Integer spaceid,Integer price,
                      Integer deposit,String taxcode,String image,String code);

    @Query(value = "SELECT * " +
            "from contract  " +
            "where contract_code =?1", nativeQuery = true)
    Contract existsContractByCode(String contractCode);
}
