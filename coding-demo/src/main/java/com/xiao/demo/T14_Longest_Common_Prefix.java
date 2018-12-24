package com.xiao.demo;

/**
 * Created by xiao on 2018/12/20.
 * Write a function to find the longest common prefix string amongst an array of strings.

 If there is no common prefix, return an empty string "".

 Example 1:

 Input: ["flower","flow","flight"]
 Output: "fl"
 Example 2:

 Input: ["dog","racecar","car"]
 Output: ""
 Explanation: There is no common prefix among the input strings.
 Note:

 All given inputs are in lowercase letters a-z.


 */
public class T14_Longest_Common_Prefix {

    /**
     * 水平横向扫描
     * ["flower","flow","flight"]
     * @param strs
     * @return
     */
    public String horizontal(String[] strs) {
        String tmp = "";
        if(strs.length ==0 ){
            return tmp;
        }

        String pro = strs[0];
        for(int index = 1;index < strs.length ; index ++){
            tmp = strs[index];
            //关键点，用开头判断
            while(tmp.indexOf(pro)!=0){
                pro = pro.substring(0,pro.length()-1);
                if(pro.isEmpty()){
                    return "";
                }
            }
        }
        return pro;
    }

    /**
     * 垂直扫描
     * @param strs
     * @return
     */
    public String vertical(String[] strs) {
        String tmp = "";
        if(strs.length ==0 ){
            return tmp;
        }

        String pro = strs[0];
        int len = pro.length();
        int index = 0;
        //垂直查
        for( ; index < len ; index ++){
            char c = pro.charAt(index);
            for(int i = 1;i<strs.length;i++){
                if( index == strs[i].length() || c!=strs[i].charAt(index)){
                    return pro.substring(0,index);
                }
            }
        }
        return pro;
    }


}
