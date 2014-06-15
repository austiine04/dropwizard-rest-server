package com.restuarant_menu.restaurant_menu.healthchecks;

import com.codahale.metrics.health.HealthCheck;
import com.mongodb.Mongo;

public class MongoDBHealthCheck extends HealthCheck {

    private Mongo mongo;

    public MongoDBHealthCheck(Mongo mongo) {
        this.mongo = mongo;
    }

    @Override
    protected Result check() throws Exception {
        mongo.getDatabaseNames();
        return Result.healthy();
    }
}
