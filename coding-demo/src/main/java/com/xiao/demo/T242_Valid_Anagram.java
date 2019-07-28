package com.xiao.demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 有效的字母异位词
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class T242_Valid_Anagram {
    public boolean isAnagram(String s, String t) {

        return false;
    }

    /**
     * 可以用快排，后比较两个s是否相同
     * @param s
     * @param t
     * @return
     */
    public boolean test1(String s, String t){
        if(s==null || t==null){
            return false;
        }
        if(s.length()!=t.length()){
            return false;
        }
        if(s.equals("") && t.equals("")){
            return true;
        }

        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);

        for(int i=0;i<ch1.length;i++){
            if(ch1[i]!=ch2[i]){
                return false;
            }
        }
        return true;
    }

    /**
     * 用map做
     * @param s
     * @param t
     * @return
     */
    public boolean test2(String s, String t){
        if(s==null || t==null){
            return false;
        }
        if(s.length()!=t.length()){
            return false;
        }
        if(s.equals("") && t.equals("")){
            return true;
        }
        Map<Character,Integer> map = new HashMap<>(s.length());
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                int value = map.get(s.charAt(i)) + 1;
                map.put(s.charAt(i),value);
            }else {
                map.put(s.charAt(i),1);
            }
        }

        for(int i=0;i<t.length();i++){
            if(map.containsKey(t.charAt(i))){
                int value = map.get(t.charAt(i)) -1;
                if(value==0){
                    map.remove(t.charAt(i));
                }else {
                    map.put(t.charAt(i),value);
                }
            }else {
                return false;
            }
        }

        return map.isEmpty();
    }

    /**
     * 题意比较特殊，可以直接用数组模拟hash表，26个字母，用26长的数据表示位置
     * @param s
     * @param t
     * @return
     */
    public boolean test3(String s, String t){

        return false;
    }

    public static void main(String[] args) {

        T242_Valid_Anagram test = new T242_Valid_Anagram();
        String s1 = "abca";
        String s2 = "bcaa";

        System.out.println(test.test1(s1,s2));
        System.out.println(test.test2(s1,s2));
    }
}
