package com.c0821g1.sprint1.controller;

import com.c0821g1.sprint1.entity.customer.Customer;
import com.c0821g1.sprint1.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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

    /**
     * created by VyLTT
     * method getAllCustomer
     *
     * @param pageable
     * @return
     */
    @GetMapping("/list")
    public ResponseEntity<Page<Customer>> getAllCustomer(@PageableDefault(size = 4) Pageable pageable) {
        Page<Customer> customers = this.customerService.getAll(pageable);
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

//    @GetMapping("/list")
//    public ResponseEntity<List<Customer>> getAllCustomer() {
//        List<Customer> customers = this.customerService.getAll();
//        return new ResponseEntity<>(customers, HttpStatus.OK);
//    }

    @GetMapping(value = "/detail/{id}")
    public ResponseEntity<Customer> getDetailCustomer(@PathVariable Integer id) {
        Customer customerObj = this.customerService.findById(id);
        if(customerObj==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(customerObj, HttpStatus.OK);
    }

    //      VyLTT- delete customer
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable Integer id) {
        Customer customerObj = customerService.findById(id);
        if (customerObj == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customerObj.setCustomerDeleteFlag(false);
        this.customerService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //    VyLTT - search by name, email, phone, identify number
    @GetMapping("/search")
    public ResponseEntity<Page<Customer>> searchCustomer(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "") String customerName,
            @RequestParam(defaultValue = "") String customerEmail,
            @RequestParam(defaultValue = "") String customerPhone,
            @RequestParam(defaultValue = "") String customerIdentifyNumber
    ) {
        Pageable pageable = PageRequest.of(page, 10, Sort.by("customer_id"));
        Page<Customer> customersNewPage = customerService.findCustomerByNameAndEmailAndPhoneAndIdentify
                (pageable, customerName, customerEmail, customerPhone, customerIdentifyNumber);

        if (customersNewPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customersNewPage, HttpStatus.OK);

    }
}
