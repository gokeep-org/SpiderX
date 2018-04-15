package com.spiderx.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Map;

@Path("/deploy")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class DeployRest {
    @POST
    @Path("/start")
    public Map<String, Object> start(Map<String, Object> deployBody){

        return null;
    }
}
