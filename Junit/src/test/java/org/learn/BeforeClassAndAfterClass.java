package org.learn;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.Test;

public class BeforeClassAndAfterClass {

    @BeforeClass
    public static void beforeClass(){
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

    @AfterClass
    public static void afterClass(){
        System.out.println("--- Tearing down something ---");
    }
}
