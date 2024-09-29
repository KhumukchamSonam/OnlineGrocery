package com.crio.orderManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crio.orderManagement.Entity.Customer;
import com.crio.orderManagement.Repository.CustomerRepository;
import java.util.Optional;
import java.lang.RuntimeException;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer addCustomer(Customer customer){
        Optional<Customer> optCustomer=customerRepository.findById(customer.getId());
        if(optCustomer.isPresent()){
            System.out.println("Customer already present");
            throw new RuntimeException("Customer already present");
        }else{
            return customerRepository.save(customer);
        }

    }

    @Override
    public Customer updateCustomer(Customer customer){
        Optional<Customer> opt=customerRepository.findById(customer.getId());
        if(opt.isPresent()){
            return customerRepository.save(customer);
        }else{
            throw new RuntimeException("Customer does not exist");
        }
    }

    @Override
    public Customer removeCustomer(Integer id){
        Optional<Customer> opt=customerRepository.findById(id);
        if(opt.isPresent()){
            customerRepository.deleteById(id);
            return opt.get();
        }else{
            throw new RuntimeException("No customer found");
        }
    }

    @Override
    public Customer viewCustomer(Integer id){
        Optional<Customer> opt=customerRepository.findById(id);
        if(opt.isPresent()){
            return opt.get();
        }else{
            throw new RuntimeException("No such customer exist");
        }
    }

}
