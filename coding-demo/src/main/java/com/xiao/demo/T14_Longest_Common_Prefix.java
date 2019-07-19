package com.xiao.demo;

/**
 * Created by xiao on 2018/12/20.
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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

    public static void main(String[] args) {

    }

}
