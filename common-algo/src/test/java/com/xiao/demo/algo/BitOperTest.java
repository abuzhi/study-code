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
    public void toLow() {
        int a = 5;
        System.out.println(BitOper.toBinary(a,4 * 8-1));
        System.out.println(Integer.toBinaryString(a));

        int b  = 1 << 31 ;
        System.out.println(Integer.toBinaryString(b));
        System.out.println(Integer.toString(b));

        long c = 1 << 63;
        System.out.println(Long.toBinaryString(c));

        int low = 65535;
        System.out.println(Integer.toBinaryString(low));

        int high = 66666;
        System.out.println(Integer.toBinaryString(high));

    }

    /**
     * 计算机中存储负数用的是补码，即原码取反码再+1
     * 例如： - 1 的取之过程为 ，先取1的原码，再取反，再 + 1
     *         原码：00000000 00000000 00000000 00000001
     *         反码：11111111 11111111 11111111 11111110
     *         补码：11111111 11111111 11111111 11111111
     *         所以，-1 在计算机中转化为 二进制为补码值
     */
    @Test
    public void intMaxmin() {
        int b  = 1 << 31 ;
        System.out.println(Integer.toString(b));
        System.out.println(Integer.toBinaryString(b));

        b = (1 << 31) + 1;
        System.out.println(Integer.toString(b));
        System.out.println(Integer.toBinaryString(b));

        b = (1 << 31)-1;
        System.out.println(Integer.toString(b));
        System.out.println(Integer.toBinaryString(b));

        b = (1 << 31) + ((1 << 31)-1);
        System.out.println(Integer.toString(b));
        System.out.println(Integer.toBinaryString(b));

        b = -2;
        System.out.println(Integer.toBinaryString(b));

        long max = Long.MAX_VALUE;
        long min = Long.MIN_VALUE;

        System.out.println(Long.toBinaryString(max));
        System.out.println(Long.toBinaryString(min));

        max = 1 << 31;
        System.out.println(Long.toString(max));
        System.out.println(Long.toBinaryString(max));

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

    @Test
    public void xor() {


    }
}