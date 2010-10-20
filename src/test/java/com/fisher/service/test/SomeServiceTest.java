package com.fisher.service.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fisher.service.SomeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-*.xml" })
public class SomeServiceTest {

    //Inject by Spring 3.x
    @Autowired
    SomeService someService;
    
    Logger log = LoggerFactory.getLogger(SomeServiceTest.class);
    
    //JUnit 4 tests are now annotated methods, the word 'test' does NOT have to in the method name
    @Test
    public void someServiceTestMethod() {
        String finalGreeting = someService.doHello("Noddy");
        
        log.info("Greeting = " + finalGreeting);
        
        Assert.assertTrue(finalGreeting.toLowerCase().contains("hello"));
    }
}
