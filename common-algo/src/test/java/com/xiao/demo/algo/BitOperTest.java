package com.xiao.demo.algo;

import org.junit.Test;

import static org.junit.Assert.*;


public class BitOperTest {


    @Test
    public void oper1() {
        // 0000 0001 left 2 bit = 0000 0100 =4
        int a = (1 << 2) + 1;
        assertEquals(5,a);

        a = 1 << 2 + 1;
        assertEquals(8,a);

        a = (4 << 1) + 1;
        assertEquals(9,a);

        // 0000 0011
        a = (3 << 2) ;
        System.out.println(BitOper.toBinary(a,8));

    }


    @Test
    public void and() {
        //判断某位是否是1
        //3 = 0000 0011，判断第2位
        int i = 3 & (1<<1);
        assertNotEquals(0,i);

        //3 = 0000 0011，判断第3位
        i = 3 & (1<<2);
        assertEquals(0,i);


    }

}