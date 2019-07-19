package com.xiao.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoliang on 2017/3/23.
 * 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class T3_Longest_Substring_Without_Repeating_Characters {

    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        if (s.length() < 2) {
            return s.length();
        }

        char[] arrs = s.toCharArray();

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0,len = arrs.length; i < len; i++) {

            if (map.containsKey(arrs[i])) {
                int index = map.get(arrs[i]);
                //判断以前是否有出现过，取最大
                j = index >=j ? index+1 : j ;
            }
            map.put(arrs[i], i);
            maxLen = maxLen < (i + 1 - j) ? (i + 1 - j) : maxLen;
        }

        return maxLen;
    }

    public int lengthOfLongestSubstring2(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;

        if(len<2){
            return len;
        }

        Map<Character,Integer> map = new HashMap<>();
        int max=0;
       for(int start=0,end = 0;end < len ; end ++){
           char ch = arr[end];
           Integer tmp = map.get(ch);
           if(tmp !=null){
               //核心代码：判断是否出现过，取最大的
               start = tmp >= start ? tmp+1 : start;
           }
           map.put(ch,end);
           int tmpmax = end - start + 1;
           max = max > tmpmax ? max : tmpmax;
       }
        return max;
    }

    public static void main(String[] args) {
        String s = "pwwwb";

        T3_Longest_Substring_Without_Repeating_Characters t3 = new T3_Longest_Substring_Without_Repeating_Characters();
//        int max = t3.lengthOfLongestSubstring(s);
        int max2 = t3.lengthOfLongestSubstring2(s);
        System.out.println(max2);
    }
}
