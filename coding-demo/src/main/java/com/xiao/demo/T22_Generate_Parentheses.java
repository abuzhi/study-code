package com.xiao.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 *
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T22_Generate_Parentheses {

    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();


        return null;
    }

    /**
     * 计数器当作栈使用
     * @param chars
     * @return
     */
    private boolean valid(char[] chars){
        int count = 0;
        for(char c : chars){
            if('('==c){
                count ++;
            }else {
                count --;
            }
            if(count<0) return false;
        }

        return count ==0;
    }

    public static void main(String[] args) {

    }
}
