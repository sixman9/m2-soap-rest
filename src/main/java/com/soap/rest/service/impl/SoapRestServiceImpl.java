package com.soap.rest.service.impl;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soap.rest.service.PresidentExampleServiceIntf;
import com.soap.rest.service.SoapRestServiceIntf;

@WebService
@Service("soapRestServiceBean")
// @Lazy(true)
// @DependsOn({"aSpringBean", "anotherBean", "etcBean"})
public class SoapRestServiceImpl implements SoapRestServiceIntf {

    @Autowired //Could use @Qualifier("beanName"), shouldn't be necessary if unique by type
    protected PresidentExampleServiceIntf presidentService;

    @Override
    public String getPresidentByNumber(int presidentInt) {
        //Simply call the (remote?) Spring service
        return presidentService.getPresidentByNumber(presidentInt);
    }

    @Override
    public List<String> getPresidentsByName(String nameSearch) {
        return presidentService.getPresidentsByName(nameSearch);
    }

    @Override
    @WebMethod(exclude = true)
    // Rest-Only, Excluded from SOAP-Based call
    public Response getPresidentsByNameRest(String nameSearch) {
        // Get product code string list - delegated method call
        List<String> presidentData = getPresidentsByName(nameSearch);

        // Use Generic Entity to 'mask/cleanse' the product code string
        // list's type from XML generation code GenericEntity<List<String>>
        /*
         * entity = new GenericEntity<List<String>>( presidentData) { };
         */

        // String-lists are not handled correctly - so we'll wrap it here
        XMLListWrapper entity = new XMLListWrapper();
        entity.add(presidentData);

        // Return a 'response' object containing the genericEntity 'cleansed'
        return Response.ok(entity).build();
    }

    // Another way to inject a [Spring] bean
    // @Autowired @Qualifier("aBeanName")
    /*
     * public void setBeanOrService(SomeService someService) { this.someService
     * = someService; }
     */

}
