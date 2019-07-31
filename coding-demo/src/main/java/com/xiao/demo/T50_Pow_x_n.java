package com.xiao.demo;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 *
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 说明:
 *
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/powx-n
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T50_Pow_x_n {


    /**
     * 暴力法
     * 会超时
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {

        long tmpN = n;
        if(tmpN < 0){
            x = 1/x;
            tmpN = -tmpN; //这里需要注意，java中int的min和max，min不能转为正的int，因为比max大1，会溢出
        }

        return test1(x,tmpN);
    }

    /**
     * 分治法
     * 递归
     * @param x
     * @param n
     * @return
     */
    public double test1(double x, long n) {

        if(n == 0){
            return 1.0;
        }

        if(n%2 == 0){
            return test1(x * x,n/2);
        }

        return test1(x ,n-1) * x;
    }

    /**
     * 分治法
     * 迭代
     * @param x
     * @param n
     * @return
     */
    public double test2(double x, int n) {

        return 0;
    }



    public static void main(String[] args) {

        T50_Pow_x_n test = new T50_Pow_x_n();
        System.out.println(test.myPow(2.1,3));
        System.out.println(test.myPow(2.000,10));
        System.out.println(test.myPow(2.000,-2));
        System.out.println(test.myPow(1.000,-2147483648));
    }
}
