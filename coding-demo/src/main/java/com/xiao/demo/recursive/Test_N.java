package com.xiao.demo.recursive;

/**
 * 计算n的阶乘
 */
public class Test_N {

    public int recu(int n){
        if(n==1){
            return 1;
        }
        return n * recu(n-1);
    }

    public static void main(String[] args) {

        int n = 5;
        Test_N test = new Test_N();

        int re = test.recu(n);
        System.out.println(re);
    }
}
