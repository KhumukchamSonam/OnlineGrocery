package com.crio.orderManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crio.orderManagement.Entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
    
}
