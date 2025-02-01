package org.learn.AssertClass;

import org.junit.Assert;
import org.junit.Test;

public class AssertEqualsEx {

    @Test
    public void testExampleOne(){
        Assert.assertEquals("hello","hello");
//        Assert.assertEquals("Failing due to this","Hello","Bello");
    }
}
