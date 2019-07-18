package com.xiao.demo.recursive;

/**
 * 斐波那契数列
 * 1、1、2、3、5、8、13、21、34、……
 *
 */
public class Test_Fibonacci {

    public int fib(int n){

        if(n==1 || n==2){
            return 1;
        }else {
            return fib(n-1) + fib(n-2);
        }
    }

    public static void main(String[] args) {
        int n = 16;
        Test_Fibonacci test = new Test_Fibonacci();

        for(int i=1;i<=n;i++){
            int r = test.fib(i);
            System.out.print(" " + r);
        }

    }
}
