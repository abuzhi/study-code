package com.xiao.demo;

/**
 * 斐波那契数
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 *
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 给定 N，计算 F(N)。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1.
 * 示例 2：
 *
 * 输入：3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2.
 * 示例 3：
 *
 * 输入：4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3.
 *  
 *
 * 提示：
 *
 * 0 ≤ N ≤ 30
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fibonacci-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T509_Fibonacci_Number {

    /**
     * 递归实现
     * @param N
     * @return
     */
    public int fib(int N) {

        if(N==0){
            return 0;
        }else if(N==1){
            return 1;
        }else {
            return fib(N-1) + fib(N-2);
        }
    }

    /**
     * 迭代实现,速度比递归要快
     * @param N
     * @return
     */
    public int test(int N){
        int n1 = 0;
        int n2 = 1;
        int result = 0;
        if(N==0){
            return n1;
        }else if(N==1){
            return n2;
        }else {
            for(int i=2;i<=N ;i++){
                result = n1 + n2;
                n1 = n2;
                n2 = result;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        T509_Fibonacci_Number test = new T509_Fibonacci_Number();
        int res = test.fib(3);
        System.out.println(res);

        res = test.test(3);
        System.out.println(res);
    }
}
