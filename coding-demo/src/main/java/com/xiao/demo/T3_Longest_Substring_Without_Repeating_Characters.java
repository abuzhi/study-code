package com.xiao.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoliang on 2017/3/23.
 * <p>
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Examples:
 * <p>
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * <p>
 * Given "bbbbb", the answer is "b", with the length of 1.
 * <p>
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
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
