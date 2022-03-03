package com.c0821g1.sprint1.service;

import com.c0821g1.sprint1.dto.CustomerDTO;
import com.c0821g1.sprint1.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
    List<Customer> getAll();

    Customer findById(Integer id);

    Page<Customer> findByName(Pageable pageable, String name);

    //    VyLTT - search by name, email, phone, identify number
    Page<Customer> findCustomerByNameAndEmailAndPhoneAndIdentify(Pageable pageable,
                                                                 String customerName,
                                                                 String customerEmail,
                                                                 String customerPhone,
                                                                 String customerIdentifyNumber);

    void save(Customer customer);

    void save(CustomerDTO customerDto);

    void remove(Integer id);

    Page<Customer> findAll(Pageable of);
}
