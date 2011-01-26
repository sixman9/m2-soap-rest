package com.soap.rest.service.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.ws.WebFault;

import org.springframework.util.StringUtils;

@WebFault(name="ProductNotFoundFault")
@XmlAccessorType(XmlAccessType.FIELD)
public class WSProductPetitionUnsatisfiedException extends WebApplicationException {
    
    
    /**
     * 
     */
    private static final long serialVersionUID = 7080557855142868112L;
    
    public String errorMessage;

    //Constructor - no arg (JavaBean/WS required)
    public WSProductPetitionUnsatisfiedException() {        
    }

    public WSProductPetitionUnsatisfiedException(int code) {
        super(code);
    }
    
    public WSProductPetitionUnsatisfiedException(Response response) {
        super(response);
    }
    
    //Constructor - message argument (for ease)
    public WSProductPetitionUnsatisfiedException(String _productCode, String _user) {
        super(400);
        String userClause = StringUtils.hasText(_user)?", requested by user '" + _user + "',":"";   //Only if user not null
        errorMessage = "Product '" + _productCode + "'" + userClause + " was not found.";
    }
    
}
