package com.restuarant_menu.restaurant_menu.models;

import net.vz.mongodb.jackson.Id;

import java.util.List;
import java.util.UUID;

public class Order {

    @Id
    private String id = UUID.randomUUID().toString();

    //private List<MenuItem> items;
    //order has many menu items

    public Order(){
    }
}
