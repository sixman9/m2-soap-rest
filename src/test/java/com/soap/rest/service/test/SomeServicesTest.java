package com.soap.rest.service.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:**/applicationContext-*.xml" })
public class SomeServicesTest {

    //Inject by Spring 3.x
    
    Logger log = LoggerFactory.getLogger(SomeServicesTest.class);
    
    @Test
    public void testSomeService() {
    }

    
}
