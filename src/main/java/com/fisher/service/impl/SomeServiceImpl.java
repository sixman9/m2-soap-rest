package com.fisher.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fisher.example.spring.SomeSpringSourcedClass;
import com.fisher.service.SomeService;

@Service("someServiceBean")
public class SomeServiceImpl implements SomeService {

    //Spring will inject this class, configured in XML, so it is available when you need it
    @Autowired
    SomeSpringSourcedClass someNamedSpringClass;
    
    @Override
    public String doHello(String name) {
        //Let's use the Spring-supplied class to fulfill the method request
        return someNamedSpringClass.getGreeting() + " " + name + "!";
    }

}
