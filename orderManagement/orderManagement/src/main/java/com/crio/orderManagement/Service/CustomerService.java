package com.crio.orderManagement.Service;

import com.crio.orderManagement.Entity.Customer;

public interface CustomerService {
    public Customer addCustomer(Customer customer);
    public Customer updateCustomer(Customer customer);
    public Customer removeCustomer(Integer id);
    public Customer viewCustomer(Integer id);
}
