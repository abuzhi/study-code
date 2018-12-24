package com.xiao.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiao on 2018/12/24.
 */
public class T567_Permutation_In_String {

    public boolean checkInclusion(String s1, String s2) {
        int len1=s1.length();
        Map<Character,Integer> map1=new HashMap<>();
        for(int i=0;i<len1;i++){
            map1.put(s1.charAt(i),map1.getOrDefault(s1.charAt(i),0)+1);

        }

        int len2=s2.length();

        for(int i=0;i<len2-len1;i++){

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
