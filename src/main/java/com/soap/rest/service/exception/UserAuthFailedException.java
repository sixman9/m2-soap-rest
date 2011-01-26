package com.soap.rest.service.exception;

import javax.ws.rs.WebApplicationException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.ws.WebFault;

@WebFault(name="UserCredentialsFault")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserAuthFailedException extends WebApplicationException {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1306157929489048973L;
    
    public String errorMessage;

    //Constructor - no arg (JavaBean/WS required)
    public UserAuthFailedException() {        
    }
    
    public UserAuthFailedException(int code) {
        super(code);
    }
    
    //Constructor - message argument (for ease)
    public UserAuthFailedException(String _message) {
        super(401);
        errorMessage = _message;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    
}
