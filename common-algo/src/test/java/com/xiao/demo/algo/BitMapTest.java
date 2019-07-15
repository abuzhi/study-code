package com.xiao.demo.algo;

import org.junit.Test;

import java.util.BitSet;

import static org.junit.Assert.*;

public class BitMapTest {

    @Test
    public void test() {
        BitSet bits1 = new BitSet(17);
        // set some bits
        for(int i=0; i<16; i++) {
            bits1.set(i);
        }
        System.out.println("Initial pattern in bits1: ");
        System.out.println(bits1);

        bits1.set(32);
        System.out.println(bits1);

    }
}