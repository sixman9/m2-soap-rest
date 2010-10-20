package com.fisher.example.spring;

/**
 * 
 * @author richard.joseph
 *
 *  This class is designed to offer an example of a service or DAO (data access object) type pattern.
 *  The class is being referenced/instantiated by Spring 3.x, and being injected (autowired) where required.
 *
 */
public class SomeSpringSourcedClass {

    private String greeting;
    
    //Constructor - no-args
    public SomeSpringSourcedClass() {
        this.greeting = "Hello there";
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
    
}
