package com.xiao.demo;

import java.util.List;

/**
 * 分割回文串
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-partitioning
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T131_Palindrome_Partitioning {

    public List<List<String>> partition(String s) {


        return null;
    }

    public void back(String s,List<String> result){
        if(s.length()==0){
            return;
        }



    }

    /**
     * 判断是否是回文
     * @param s
     * @return
     */
    private boolean isValid(String s){
        int start =0;
        int end = s.length()-1;
        while (start<end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start ++;
            end  --;
        }

        return true;
    }


    public static void main(String[] args) {

    }
}
