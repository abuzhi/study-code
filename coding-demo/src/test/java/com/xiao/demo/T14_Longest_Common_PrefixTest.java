package com.xiao.demo;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xiao on 2018/12/21.
 */
public class T14_Longest_Common_PrefixTest {


    private T14_Longest_Common_Prefix test = new T14_Longest_Common_Prefix();

    @Test
    public void horizontal() throws Exception {
        String[] arrs =  {"flower","flow","flight"};
        String pro =test.horizontal(arrs);
        System.out.println(pro);
    }

    @Test
    public void vertical() throws Exception {
        String[] arrs =  {"aa","a","aaa"};
        String pro =test.vertical(arrs);
        System.out.println(pro);
    }
}