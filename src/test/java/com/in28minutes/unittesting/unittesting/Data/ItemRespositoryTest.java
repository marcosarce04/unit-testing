package com.in28minutes.unittesting.unittesting.Data;

import com.in28minutes.unittesting.unittesting.Model.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ItemRespositoryTest {

    @Autowired
    private ItemRespository repository;

    @Test
    public void testFindAll() {
        List<Item> items = repository.findAll();

        assertEquals(3, items.size());
    }
}