package com.crio.orderManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crio.orderManagement.Service.OrderService;
import com.crio.orderManagement.Entity.Order;
import com.crio.orderManagement.Exceptions.OrderRequest;


@RestController
@RequestMapping("/api/orders")
public class OrderServiceController {
    @Autowired
    OrderService orderService;

    @PostMapping("/add")
    public ResponseEntity<Order> createOrder(@RequestBody OrderRequest orderRequest){
        Order myOrder=orderService.addOrder(orderRequest.getCustomerId(), orderRequest.getItemList());
        return new ResponseEntity<>(myOrder, HttpStatus.CREATED);
    }

    /*
If it would havve been Query param

     * @PostMapping()
public ResponseEntity<Order> createOrder(@RequestParam Integer customerId, @RequestParam List<Integer> items){
    Order myOrder = orderService.addOrder(customerId, items);
    return new ResponseEntity<>(myOrder, HttpStatus.CREATED);
}


OST /orders?customerId=1&items=101,102,103
     */



    @PostMapping("/update")
    public ResponseEntity<Order> updateOrder(@RequestBody Order order){
        Order myOrder=orderService.updateOrder(order);
        return new ResponseEntity<>(myOrder, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Order> deleteOrder(@PathVariable("id")Integer orderId){
        Order myOrder=orderService.deleteOrder(orderId);
        return new ResponseEntity<>(myOrder, HttpStatus.OK);
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<Order> viewOrder(@PathVariable("id")Integer id){
        Order myOrder=orderService.viewOrder(id);
        return new ResponseEntity<>(myOrder, HttpStatus.OK);
    }

}
