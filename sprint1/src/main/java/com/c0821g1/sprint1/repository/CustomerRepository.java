package com.c0821g1.sprint1.repository;

import com.c0821g1.sprint1.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    //    VyLTT - search by name
    @Query(value = "select  * from customer where customer_name like :name", nativeQuery = true)
    Page<Customer> getByName(Pageable pageable, @Param("name") String name);

    //    VyLTT - search by name, email, phone, identify number
    @Query(value = "select *  from customer where  customer_name like concat('%',:name,'%') \n" +
            "and customer_email like concat('%',:email,'%') \n" +
            "and customer_phone like concat('%',:phone,'%') \n" +
            "and customer_identify_number like concat('%',:identify,'%') \n" +
            "and customer_delete_flag = false", nativeQuery = true)
    Page<Customer> getByCustomerNameAndCustomerEmailAndCustomerPhoneAndCustomerIdentifyNumber
    (Pageable pageable,
     @Param("name") String customerName,
     @Param("email") String customerEmail,
     @Param("phone") String customerPhone,
     @Param("identify") String customerIdentifyNumber);
}

