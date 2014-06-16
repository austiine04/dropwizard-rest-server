package com.restuarant_menu.restaurant_menu.resources;

import com.codahale.metrics.annotation.Timed;
import com.restuarant_menu.restaurant_menu.models.Order;
import net.vz.mongodb.jackson.DBCursor;
import net.vz.mongodb.jackson.JacksonDBCollection;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/orders")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrdersResource {

    private final JacksonDBCollection<Order, String> ordersCollection;

    public OrdersResource(JacksonDBCollection<Order, String> ordersCollection) {
        this.ordersCollection = ordersCollection;
    }

    @GET
    @Timed
    public List<Order> index(){
        DBCursor<Order> dbCursor = ordersCollection.find();
        List<Order> orders = new ArrayList<>();

        while(dbCursor.hasNext()){
            orders.add(dbCursor.next());
        }

        return orders;
    }

    @POST
    @Timed
    public Response create(Order order){
        ordersCollection.insert(order);
        return Response.noContent().build();
    }
}
