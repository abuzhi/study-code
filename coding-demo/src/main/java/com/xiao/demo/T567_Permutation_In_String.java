package com.xiao.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiao on 2018/12/24.
 * 字符串的排列
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 *
 * 示例1:
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *  
 *
 * 示例2:
 *
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *  
 *
 * 注意：
 *
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class T567_Permutation_In_String {

    public boolean checkInclusion(String s1, String s2) {
        int len1=s1.length();
        Map<Character,Integer> map1=new HashMap<>();
        for(int i=0;i<len1;i++){
            map1.put(s1.charAt(i),map1.getOrDefault(s1.charAt(i),0)+1);

        }

        int len2=s2.length();

        for(int i=0;i<=len2-len1;i++){

            Map<Character,Integer> map2 =new HashMap<>();
            int j = len1+i;
            for(int tmp=i;tmp<j;tmp++){
                map2.put(s2.charAt(tmp),map2.getOrDefault(s2.charAt(tmp),0)+1);
            }

            if(compare(map1,map2)){
                return true;
            }
        }

        return false;

    }


    private boolean compare(Map<Character,Integer> map1,Map<Character,Integer> map2){
        for(Character c :map1.keySet()){
            if(map2.get(c)==null){
                return false;
            }
            if(map1.get(c)-map2.get(c)!=0){
                return false;
            }
        }

        return true;
    }

}
