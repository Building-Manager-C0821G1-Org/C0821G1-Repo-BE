package com.c0821g1.sprint1.controller;

import com.c0821g1.sprint1.entity.customer.Customer;
import com.c0821g1.sprint1.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    //      VyLTT - list of customer
    @GetMapping("/list")
    public ResponseEntity<List<Customer>> getAllCustomer() {
        List<Customer> customers = this.customerService.getAll();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
    //      VyLTT- delete customer
    @DeleteMapping("delete-customer/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable Integer id) {
        Optional<Customer> customerOptional = Optional.ofNullable(customerService.findById(id));
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customerService.remove(id);
        return new ResponseEntity<>(customerOptional.get(), HttpStatus.NO_CONTENT);
    }
}
