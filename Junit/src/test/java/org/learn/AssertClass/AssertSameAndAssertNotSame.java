package org.learn.AssertClass;

import org.junit.Assert;
import org.junit.Test;

public class AssertSameAndAssertNotSame {

    @Test
    public void testExampleOne(){

        String a="Ramesh";
        String b="Ramesh";

        Assert.assertEquals(a,b);
//        Assert.assertNotNull("Hello");

        //Failing examples
//        Assert.assertNull("Failing due to this","Ramesh");
//        Assert.assertNotNull("Failing due to this",null);
    }
}
