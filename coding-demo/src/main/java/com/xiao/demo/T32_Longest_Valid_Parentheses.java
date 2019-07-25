package com.xiao.demo;

import java.util.Stack;

/**
 * 最长有效括号
 *
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 *
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 *
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T32_Longest_Valid_Parentheses {

    public int longestValidParentheses(String s) {
        int max = 0;


        return max;

    }

    /**
     * 用栈实现
     * 很巧妙
     * @param s
     * @return
     */
    public int test1(String s){
        int max = 0;

        if(s.length()<2){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        //初始化-1到栈，方便统计
        stack.push(-1);

        for(int i =0;i<s.length();i++){
            if('(' == s.charAt(i) ){
                stack.push(i);
            }else {
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else {
                    int top = stack.peek();
                    max = max > (i - top) ? max : (i-top);
                }
            }
        }

        return max;
    }

    /**
     * 动态规划
     * todo
     * @param s
     * @return
     */
    public int test2(String s){

        return 0;
    }

    public static void main(String[] args) {
        T32_Longest_Valid_Parentheses test = new T32_Longest_Valid_Parentheses();
        int result = test.test1(")()())");
        System.out.println(result);
    }
}
