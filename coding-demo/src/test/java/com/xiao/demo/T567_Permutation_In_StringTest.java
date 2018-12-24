package com.xiao.demo;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xiao on 2018/12/24.
 */
public class T567_Permutation_In_StringTest {

    private T567_Permutation_In_String test = new T567_Permutation_In_String();


    @Test
    public void checkInclusion() throws Exception {
        String s1 = "adc";
        String s2 = "dcda";

        boolean ok = test.checkInclusion(s1,s2);
        assertTrue(ok);
    }

}