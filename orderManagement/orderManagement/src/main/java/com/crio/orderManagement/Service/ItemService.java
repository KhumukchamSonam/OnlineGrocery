package com.crio.orderManagement.Service;

import com.crio.orderManagement.Entity.Item;

public interface ItemService {
    public Item addItem(Item item);
    public Item updateItem(Item item);
    public Item removeItem(Item item);
    public Item viewItem(Item item);
}
