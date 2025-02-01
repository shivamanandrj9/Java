package org.learn.AssertClass;

import org.junit.Assert;
import org.junit.Test;

public class AssertNullAndAssertNotNull {

    @Test
    public void testExampleOne(){
        Assert.assertNull(null);
        Assert.assertNotNull("Hello");

        //Failing examples
        Assert.assertNull("Failing due to this","Ramesh");
        Assert.assertNotNull("Failing due to this",null);
    }
}
