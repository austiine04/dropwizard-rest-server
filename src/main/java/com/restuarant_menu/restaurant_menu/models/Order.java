package com.restuarant_menu.restaurant_menu.models;

import net.vz.mongodb.jackson.Id;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;
import java.util.UUID;

public class Order {

    @Id
    private String id = UUID.randomUUID().toString();

    @NotEmpty
    private List<MenuItem> items;

    public Order(List<MenuItem> items) {
        this.items = items;
    }

    public Order(){}

    public double total(){
        return 0.0;
    }
}
