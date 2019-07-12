package com.xiao.demo.algo;

/**
 * &   -  bitwise and
 * |   -  bitwise or
 * ^   -  bitwise xor
 * ~   -  bitwise not
 * <<  -  bitwise shift left
 * >>  -  bitwise shift right
 *
 * 一般位操作
 * 1         00000001    (same as 1<<0)
 * 1<<1      00000010
 * 1<<2      00000100
 * 1<<3      00001000
 * 1<<4      00010000
 * 1<<5      00100000
 * 1<<6      01000000
 * 1<<7      10000000
 *
 */
public class BitOper {

    /**
     * 将一个int数字转换为二进制的字符串形式。
     * @param num 需要转换的int类型数据
     * @param digits 要转换的二进制位数，位数不足则在前面补0
     * @return 二进制的字符串形式
     */
    public static String toBinary(int num, int digits) {
        int value = 1 << digits | num;
        String bs = Integer.toBinaryString(value); //0x20 | 这个是为了保证这个string长度是6位数
        return  bs.substring(1);
    }



}
