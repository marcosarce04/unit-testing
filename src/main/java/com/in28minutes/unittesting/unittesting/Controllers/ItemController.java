package com.in28minutes.unittesting.unittesting.Controllers;

import com.google.gson.Gson;
import com.in28minutes.unittesting.unittesting.Business.ItemBusinessService;
import com.in28minutes.unittesting.unittesting.Model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    @Autowired
    private ItemBusinessService businessService;

    @GetMapping( "/dummy-item")
    public String dummyItem() {
        return new Gson().toJson(new Item(1, "Ball", 10, 100));
    }

    @GetMapping("/item-from-business-service")
    public String itemFromBussinessService() {
        return new Gson().toJson(businessService.retrieveHardcodedItem());
    }
}
