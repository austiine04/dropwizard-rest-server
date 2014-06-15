package com.restuarant_menu.restaurant_menu.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import net.vz.mongodb.jackson.Id;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.UUID;

public class MenuItem {

    @Id
    private String id = UUID.randomUUID().toString();

    @NotEmpty
    private String name;

    @NotEmpty
    private String description;

    @NotEmpty
    private double price;

    public MenuItem(String name, String description, double price) {
        super();
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public MenuItem(){}

    public String getId(){
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public double getPrice() {
        return this.price;
    }
}
