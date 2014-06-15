package com.restuarant_menu.restaurant_menu;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.restuarant_menu.restaurant_menu.healthchecks.MongoDBHealthCheck;
import com.restuarant_menu.restaurant_menu.models.MenuItem;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import com.restuarant_menu.restaurant_menu.resources.MenuItemResource;
import net.vz.mongodb.jackson.JacksonDBCollection;

public class ServerApplication extends Application<ServerConfiguration> {

    public static void main(String[] args) throws Exception {
        new ServerApplication().run(new String[]{"server"});
    }

    @Override
    public void initialize(
            Bootstrap<ServerConfiguration> serverConfigurationBootstrap) {
        serverConfigurationBootstrap.addBundle(new AssetsBundle("/assets/", "/"));
    }

    @Override
    public void run(ServerConfiguration serverConfiguration,
                    Environment environment) throws Exception {

        Mongo mongo = new Mongo(ServerConfiguration.dbServerHost, ServerConfiguration.dbServerPort);
        MongoManager mongoManager = new MongoManager(mongo);

        environment.lifecycle().manage(mongoManager);
        environment.healthChecks().register("MongoDB Health Check", new MongoDBHealthCheck(mongo));

        DB db = mongo.getDB(ServerConfiguration.dbName);
        JacksonDBCollection<MenuItem, String> menuItems = JacksonDBCollection.wrap(
                db.getCollection("menu_items"), MenuItem.class, String.class);

        environment.jersey().register(new MenuItemResource(menuItems));
    }
}
