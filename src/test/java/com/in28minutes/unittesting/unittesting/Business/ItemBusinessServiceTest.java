package com.in28minutes.unittesting.unittesting.Business;

import com.in28minutes.unittesting.unittesting.Data.ItemRespository;
import com.in28minutes.unittesting.unittesting.Data.SomeDataService;
import com.in28minutes.unittesting.unittesting.Model.Item;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class ItemBusinessServiceTest {

    @InjectMocks
    private ItemBusinessService business = new ItemBusinessService();

    @Mock
    private ItemRespository repository;

    @Test
    public void retrieveAllItems_basic() {
        when(repository.findAll())
                .thenReturn(Arrays.asList(new Item(1, "Ball", 10, 100)));

        List<Item> items = business.retrieveAllItems();

        assertEquals(100, items.get(0).getValue());
    }
}