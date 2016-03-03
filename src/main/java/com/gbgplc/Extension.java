package com.gbgplc;


import org.json.JSONObject;
import org.neo4j.graphdb.GraphDatabaseService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

/**
 * Created by laeg on 03/03/2016.
 */
@Path("/")
public class Extension {

    private final GraphDatabaseService graphDatabaseService;

    public Extension (@Context GraphDatabaseService graphDatabaseService) {
        this.graphDatabaseService = graphDatabaseService;
    }

    @GET
    @Produces("application/json")
    @javax.ws.rs.Path("/alive")
    public Response get() {
        JSONObject jObj = new JSONObject();
        jObj.put("online", 1);
        return Response.ok().entity(jObj.toString()).build();
    }

}
