package com.c0821g1.sprint1.service.impl;

import com.c0821g1.sprint1.dto.CustomerDTO;
import com.c0821g1.sprint1.entity.customer.Customer;
import com.c0821g1.sprint1.repository.CustomerRepository;
import com.c0821g1.sprint1.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Page<Customer> getAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Customer findById(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Customer> findByName(Pageable pageable, String name) {
        Page<Customer> customerPage = customerRepository.getByName(pageable, "%" + name + "%");
        return customerPage;
    }

    //    VyLTT - search by name, email, phone, identify number
    @Override
    public Page<Customer> findCustomerByNameAndEmailAndPhoneAndIdentify(Pageable pageable,
                                                                        String customerName,
                                                                        String customerEmail,
                                                                        String customerPhone,
                                                                        String customerIdentifyNumber) {
        return customerRepository.getByCustomerNameAndCustomerEmailAndCustomerPhoneAndCustomerIdentifyNumber
                (pageable, customerName, customerEmail, customerPhone, customerIdentifyNumber);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void save(CustomerDTO customerDto) {
        Customer customer = new Customer(customerDto.getCustomerId(),
                customerDto.getCustomerCode(),
                customerDto.getCustomerName(),
                customerDto.getCustomerIdentifyNumber(),
                customerDto.getCustomerEmail(),
                customerDto.getCustomerPhone(),
                customerDto.getCustomerDateOfBirth(),
                customerDto.getCustomerAddress(),
                customerDto.getCustomerStatus(),
                customerDto.getCustomerDeleteFlag());
        customerRepository.save(customer);
    }

    @Override
    public void remove(Integer id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Page<Customer> findAll(Pageable of) {
        return customerRepository.findAll(of);
    }
}
