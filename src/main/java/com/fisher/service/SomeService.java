package com.fisher.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

//@GET, @Path & @Produces are Jax-rs (REST) annotations
@Path("/SomeServiceRestPath")
@WebService
public interface SomeService {

    
    @GET
    @Path("/hello")
    @Produces("text/plain")
    @WebMethod
    public String doHello(@QueryParam("name") String name);
}
