package org.learn;

import org.junit.Test;

public class ExceptionTesting {

    @Test(expected = Exception.class)
    public void testExampleOne() throws Exception {
        System.out.println("----- runnig test example one method -----");
        throw new Exception("An exception has been caught");
    }
}
