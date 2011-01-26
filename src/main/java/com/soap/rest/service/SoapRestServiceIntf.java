package com.soap.rest.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.ws.ResponseWrapper;


//@GET, @Path & @Produces are Jax-rs (REST) annotations
//@WebMethod annotation is related to SOAP services
@Path("/restServicePath")
@WebService(name = "SoapRestWS")
public interface SoapRestServiceIntf {
    
    //@QueryParam is the REST parameter name, @WebParam is the SOAP/WSDL request name
    
    @GET
    @Path("/getPresidentByNumber")
    // Generate either XML OR JSON for JAX-RS [REST] services - Rendered by
    // JAXB!
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @WebMethod
    public String getPresidentByNumber(
            @DefaultValue(value="1") @QueryParam("presidentNumParam") @WebParam(name = "presidentNumParam")  int presidentInt
            ) ;
    
    /**
     * This method, and its return type, where deemed necessary as the singular usage of getPresidents()
     * method to produce both Rest and Soap based services was not easily achievable. This was due mainly to 
     * JAXB not generating XML wrapper code for the List<String> method return type;
     * 
     *  This method should now delegate the workload to the other version, then wrap the return in JAX-RS/Rest-friendly
     *  code (Response class).
     */
    @GET
    @Path("/getPresidentsByName")
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
        @WebMethod(exclude=true)    //Rest-ONLY - should not be available to JAX-WS web services
    public Response getPresidentsByNameRest(
            @QueryParam("presidentNameParam") String nameSearch) ;

    //SOAP/WSDL only method version of getPresidentsRest()
    @WebMethod
    @ResponseWrapper()  //Handles List return types better (?)
    public @XmlElement List<String> getPresidentsByName(
            @WebParam(name = "presidentNameParam") String nameSearch) ;

}
