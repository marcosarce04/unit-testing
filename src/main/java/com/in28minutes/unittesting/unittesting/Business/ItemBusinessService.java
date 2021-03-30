package com.in28minutes.unittesting.unittesting.Business;

import com.in28minutes.unittesting.unittesting.Data.ItemRespository;
import com.in28minutes.unittesting.unittesting.Model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemBusinessService {

    @Autowired
    private ItemRespository repository;

    public Item retrieveHardcodedItem() {
        return new Item(1, "Ball", 10, 100);
    }

    public List<Item> retrieveAllItems() {
        return repository.findAll();
    }
}
