package com.in28minutes.unittesting.unittesting.Data;

import com.in28minutes.unittesting.unittesting.Model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRespository extends JpaRepository<Item, Integer> {
}
