package org.learn.AssertClass;

import org.junit.Assert;
import org.junit.Test;

public class AssertTrueAndAssertFalse {

    @Test
    public void testExampleOne(){
        Assert.assertTrue(true);
        Assert.assertFalse(false);
//        Assert.assertTrue("Faling due to this",false);

    }
}
