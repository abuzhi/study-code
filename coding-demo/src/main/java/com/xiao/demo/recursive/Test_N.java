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


    /**
     * 尾递归方法
     * https://www.cnblogs.com/tgycoder/p/6063722.html
     * @param n
     * @param result
     * @return
     */
    public int test(int n,int result){
        if(n==1){
            return  result;
        }else {
            return test(n-1, n*result);
        }
    }

    public static void main(String[] args) {

        int n = 5;
        Test_N test = new Test_N();

        int re = test.recu(n);
        System.out.println(re);

        re = test.test(n,1);
        System.out.println(re);
    }
}
