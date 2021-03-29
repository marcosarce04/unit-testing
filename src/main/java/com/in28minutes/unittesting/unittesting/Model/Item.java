package com.in28minutes.unittesting.unittesting.Model;

public class Item {

    private String name;
    private int price;
    private int quantity;
    private int id;

    public Item(int id, String name, int price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format("Item[%d, %s, %d, %d]", id, name, price, quantity);
    }
}
