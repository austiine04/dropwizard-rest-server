package com.restuarant_menu.restaurant_menu;

import com.mongodb.Mongo;
import io.dropwizard.lifecycle.Managed;

public class MongoManager implements Managed {

    private Mongo mongo;

    public MongoManager(Mongo mongo) {
        this.mongo = mongo;
    }

    @Override
    public void start() throws Exception {
    }

    @Override
    public void stop() throws Exception {
        mongo.close();
    }
}
