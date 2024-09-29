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

import com.crio.orderManagement.Service.ItemService;
import com.crio.orderManagement.Entity.Item;

@RestController
@RequestMapping("/api/items")
public class ItemServiceController {
    @Autowired
    ItemService itemService;

    @PostMapping("/add")
    public ResponseEntity<Item> addItem(@RequestBody Item item){
        Item myItem=itemService.addItem(item);
        return new ResponseEntity<Item>(myItem, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Item> updateItem(@RequestBody Item item){
        Item myItem=itemService.updateItem(item);
        return new ResponseEntity<>(myItem, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{itemId}")
    public ResponseEntity<Item> deleteItem(@PathVariable("itemId")Integer itemId){
        Item myItem=itemService.removeItem(itemId);
        return new ResponseEntity<>(myItem, HttpStatus.OK);
    }

    @GetMapping("/view/{itemId}")
    public ResponseEntity<Item> viewItem(@PathVariable("itemId")Integer itemId){
        Item myItem=itemService.viewItem(itemId);
        return new ResponseEntity<>(myItem, HttpStatus.OK);
    }
}
