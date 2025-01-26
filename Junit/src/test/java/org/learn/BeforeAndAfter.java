package org.learn;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BeforeAndAfter {

    @Before
    public void setUp(){
        System.out.println("--- Setting up something ---");
    }

    @Test
    public void testCase1(){
        System.out.println("--- Running testcase 1 ---");
    }

    @Test
    public void testCase2(){
        System.out.println("--- Running testcase 2 ---");
    }

    @After
    public void tearDown(){
        System.out.println("--- Tearing down something ---");
    }
}
