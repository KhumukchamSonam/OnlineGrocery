package com.crio.orderManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crio.orderManagement.Repository.CustomerRepository;
import com.crio.orderManagement.Repository.ItemRepository;
import com.crio.orderManagement.Repository.OrderRepository;
import com.crio.orderManagement.Entity.Order;
import com.crio.orderManagement.Entity.Customer;
import com.crio.orderManagement.Entity.Item;
import java.util.Optional;
import java.time.LocalDate;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ItemRepository itemRepository;

    public Order addOrder(Integer customerId, List<Integer> items){
        //check if customer exist
        Optional<Customer> optCustomer=customerRepository.findById(customerId);
        if(!optCustomer.isPresent()){
            throw new RuntimeException("No such customer exist, so order cannot be placed");
        }

        Double totalPrice=0.0;
        for(Integer i:items){
            Optional<Item> optItem=itemRepository.findById(i);
            if(!optItem.isPresent()){
                throw new RuntimeException("item with id="+i+" does not exist, so order cannot be placed");
            }
            totalPrice+=optItem.get().getPrice();
        }
        Order order=new Order(null, customerId, items, LocalDate.now(), totalPrice);
        orderRepository.save(order);
        return order;
    }

    public Order updateOrder(Order order){
        Optional<Order> opt=orderRepository.findById(order.getId());
        if(opt.isPresent()){
            return orderRepository.save(order);
        }else{
            throw new RuntimeException("No such order exist to be updated");
        }
    }

    public Order deleteOrder(Integer orderId){
        Optional<Order> opt=orderRepository.findById(orderId);
        if(opt.isPresent()){
            orderRepository.deleteById(orderId);
            return opt.get();
        }else{
            throw new RuntimeException("No such order exist to be deleted");
        }
    }

    public Order viewOrder(Integer orderId){
        Optional<Order> opt=orderRepository.findById(orderId);
        if(opt.isPresent()){
            return opt.get();
        }else{
            throw new RuntimeException("No such order exist to be viewed");
        }
    }

}
