package org.learn;

import org.junit.Test;

public class TimeOutAnnot {


    @Test(timeout = 2000)
    public void testExampleOne() throws InterruptedException {
        System.out.println("----- running test example one method -----");
        Thread.sleep(5000);
    }
}
