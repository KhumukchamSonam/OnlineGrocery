package com.crio.orderManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crio.orderManagement.Service.CustomerService;


import com.crio.orderManagement.Entity.Customer;

@RestController
@RequestMapping("/api/customer")
public class CustomerServiceController {
    @Autowired
    CustomerService customerService;

    @PostMapping("/add")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
        Customer myCustomer=customerService.addCustomer(customer);
        return new ResponseEntity<Customer>(myCustomer, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
        Customer myCustomer=customerService.updateCustomer(customer);
        return new ResponseEntity<>(myCustomer, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable("id")Integer id){
        Customer myCustomer=customerService.removeCustomer(id);
        return new ResponseEntity<Customer>(myCustomer, HttpStatus.OK);

    }

    @GetMapping("/view/{id}")
    public ResponseEntity<Customer> viewCustomer(@PathVariable("id") Integer id){
        Customer myCustomer=customerService.removeCustomer(id);
        return new ResponseEntity<Customer>(myCustomer, HttpStatus.OK);

    }
}
