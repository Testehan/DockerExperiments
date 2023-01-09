package com.testehan.docker.rest;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.Properties;

@Path("properties")
public class PropertiesResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject getProperties() {

        JsonObjectBuilder builder = Json.createObjectBuilder();

        createDummyProperties()
                .entrySet()
                .stream()
                .forEach(entry -> builder.add((String) entry.getKey(),
                        (String) entry.getValue()));

        return builder.build();
    }

    private Properties createDummyProperties(){
        Properties properties = new Properties();
        properties.put("name","Dan Testehan");
        properties.put("email","secret@secret.com");
        properties.put("phone","911");
        return properties;
    }
}
