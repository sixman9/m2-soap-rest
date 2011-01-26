package com.soap.rest.service;

import java.util.List;

public interface PresidentExampleServiceIntf {
    
    public String getPresidentByNumber(int presidentInt) ;

    public List<String> getPresidentsByName(String nameSearch) ;

}
