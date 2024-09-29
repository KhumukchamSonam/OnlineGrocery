package com.crio.orderManagement.Service;

import com.crio.orderManagement.Repository.ItemRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.crio.orderManagement.Entity.Item;

public class ItemServiceImpl implements ItemService{
    @Autowired
    ItemRepository itemRepository;

    @Override
    public Item addItem(Item item){
        Optional<Item> opt=itemRepository.findById(item.getId());
        if(opt.isPresent()){
            throw new RuntimeException("Item already in the list");
        }else{
            return itemRepository.save(item);
        }
    }

    @Override
    public Item updateItem(Item item){
        Optional<Item> opt=itemRepository.findById(item.getId());
        if(opt.isPresent()){
            return itemRepository.save(item);
        }else{
            throw new RuntimeException("Item not present");
        }
    }

    @Override
    public Item removeItem(Integer itemId){
        Optional<Item> opt=itemRepository.findById(itemId);
        if(opt.isPresent()){
            itemRepository.deleteById(itemId);
            return opt.get();
        }else{
            throw new RuntimeException("Item not present");
        }
    }

    @Override
    public Item viewItem(Integer itemId){
        Optional<Item> opt=itemRepository.findById(itemId);
        if(opt.isPresent()){
            return opt.get();
        }else{
            throw new RuntimeException("Not such item exist");
        }

    }
}
