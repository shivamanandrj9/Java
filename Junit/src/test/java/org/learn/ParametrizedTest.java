package org.learn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class ParametrizedTest {
    
    private final Integer param1;
    private final Integer param2;

    public ParametrizedTest(List<Integer> ls){
        this.param1=ls.get(0);
        this.param2=ls.get(1);
    }

    @Parameterized.Parameters
    public static List<List<Integer>> counterIncrementer(){
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>(Arrays.asList(1, 2)));
        result.add(new ArrayList<>(Arrays.asList(2, 3)));
        return result;
    }

    @Test
    public void testCase1(){
        System.out.println(param1+" "+param2);
    }

}
