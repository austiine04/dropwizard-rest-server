package com.restuarant_menu.restaurant_menu.resources;

import com.codahale.metrics.annotation.Timed;
import com.restuarant_menu.restaurant_menu.models.MenuItem;
import net.vz.mongodb.jackson.DBCursor;
import net.vz.mongodb.jackson.JacksonDBCollection;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/menu_items")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MenuItemResource {

    private final JacksonDBCollection<MenuItem, String> collection;

    public MenuItemResource(JacksonDBCollection<MenuItem, String> collection) {
        this.collection = collection;
    }

    @GET
    @Timed
    public List<MenuItem> index(){
        List<MenuItem> menuItems = new ArrayList<>();
        DBCursor<MenuItem> dbCursor = collection.find();

        while(dbCursor.hasNext()){
            menuItems.add(dbCursor.next());
        }

        return menuItems;
    }

    @POST
    @Timed
    public Response create(MenuItem menuItem){
        collection.insert(menuItem);
        return Response.noContent().build();
    }

}
