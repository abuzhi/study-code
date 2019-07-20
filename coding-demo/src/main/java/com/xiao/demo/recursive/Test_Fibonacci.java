package com.xiao.demo.recursive;

/**
 * 斐波那契数列
 * 1、1、2、3、5、8、13、21、34、……
 *
 */
public class Test_Fibonacci {

    /**
     * 递归
     * @param n
     * @return
     */
    public int fib(int n){

        if(n==1 || n==2){
            return 1;
        }else {
            return fib(n-1) + fib(n-2);
        }
    }

    /**
     * 迭代
     * @param n
     * @return
     */
    public int test(int n){
        int n1 = 1;
        int n2 = 1;
        if(n<3){
            return 1;
        }
        int tmp = 0;

        for(int i=3;i<=n;i++){
            tmp = n1 + n2;
            n1 = n2;
            n2 = tmp;
        }

        return tmp;
    }

    public static void main(String[] args) {
        int n = 16;
        Test_Fibonacci test = new Test_Fibonacci();

        for(int i=1;i<=n;i++){
            int r = test.fib(i);
            System.out.print(" " + r);
        }

        System.out.println();

        for(int i=1;i<=n;i++){
            int r = test.test(i);
            System.out.print(" " + r);
        }

    }
}
