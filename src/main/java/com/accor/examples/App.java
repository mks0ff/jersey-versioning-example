package com.accor.examples;

import java.io.IOException;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.accor.examples.resource.TrackResourceV1Impl;
import com.accor.examples.resource.TrackResourceV2Impl;
import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.net.httpserver.HttpServer;

public class App {

    private static final Logger logger = Logger.getLogger(App.class.getName());
    private static final URI BASE_URI = URI.create("http://localhost:9000/");
    private static final String ROOT_PATH = "track";

    public static void main(String[] args) {
        try {
            final ResourceConfig resourceConfig = new PackagesResourceConfig("com.accor.examples");
            resourceConfig.getProviderClasses().add(TrackResourceV1Impl.class);
            resourceConfig.getProviderClasses().add(TrackResourceV2Impl.class);
            resourceConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, true);

            final HttpServer server = HttpServerFactory.create(BASE_URI, resourceConfig);
            logger.log(Level.INFO, String.format("Application started.%nTry out %s%s%n ", BASE_URI, ROOT_PATH));
            server.start();

        } catch (IOException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }
}
