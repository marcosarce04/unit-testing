package com.in28minutes.unittesting.unittesting.Controllers;

import com.in28minutes.unittesting.unittesting.Business.ItemBusinessService;
import com.in28minutes.unittesting.unittesting.Model.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemBusinessService businessService;

    public ItemControllerTest() {
    }

    @Test
    public void dummyItem_basic() throws Exception {

        RequestBuilder req = MockMvcRequestBuilders
                .get("/dummy-item")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(req)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"name\":\"Ball\",\"price\":10,\"quantity\":100,\"id\":1}"))
                .andReturn();
    }

    @Test
    public void itemFromBussinessService_basic() throws Exception {

        when(businessService.retrieveHardcodedItem()).thenReturn(new Item(1, "Ball", 10, 100));

        RequestBuilder req = MockMvcRequestBuilders
                .get("/item-from-business-service")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(req)
                .andExpect(status().isOk())
                .andExpect(content().json("{name:Ball,price:10,quantity:100,id:1}"))
                .andReturn();
    }

}