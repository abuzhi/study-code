package com.xiao.demo;

/**
 * Created by xiaoliang on 2017/3/26.
 * 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T5_Longest_Palindromic_Substring {

    public String longestPalindrome(String s) {

        // TODO: 2019/7/19  
        return null;
    }

    /**
     * 中心扩展法
     * 我们观察到回文中心的两侧互为镜像。因此，回文可以从它的中心展开，并且只有 2n - 12n−1 个这样的中心。
     *
     * 你可能会问，为什么会是 2n - 1 个，而不是 n 个中心？
     * 原因在于所含字母数为偶数的回文的中心可以处于两字母之间（例如 “abba” 的中心在两个‘b’ 之间）
     *
     * @param s
     * @return
     */
    public String middle(String s){

        if(s==null || s.length()<2){
            return s;
        }
        int start =0 ,end=0;

        for(int i=0;i<s.length();i++){
            //奇数情况
            int len1 = getMaxLen(s,i,i);
            int len2 = getMaxLen(s,i,i+1); //偶数情况
            int maxLen = len1 > len2 ? len1 : len2;
            if(maxLen > end - start){
                //重新分配最大值对应的index
                start = i - (maxLen -1)/2;
                end = i + maxLen / 2;
            }
        }

        return s.substring(start,end+1);
    }

    private int getMaxLen(String s,int left,int right){
        int L = left;
        int R = right;

        while (L >=0 && R<s.length() && s.charAt(L) == s.charAt(R)){
                L --;
                R ++;
        }

        return R - L - 1;
    }

    /**
     * 暴力法
     * 复杂度 n^3 ，超长字符会超时
     * @param s
     * @return
     */
    public String test1(String s){
        String result = "";
        if(s.length()<2){
            return s;
        }

        for(int start=0;start<s.length();start++){
            for(int end = start;end<=s.length();end++){
                String tmp = s.substring(start,end);
                if(isValid(tmp)){
                   result =  tmp.length() > result.length() ? tmp : result;
                }
            }
        }
        return result;
    }

    /**
     * 判断是否是回文
     * @param s
     * @return
     */
    public boolean isValid(String s){
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

        T5_Longest_Palindromic_Substring test = new T5_Longest_Palindromic_Substring();
        System.out.println(test.isValid("aba"));
        System.out.println(test.isValid("abba"));
        System.out.println(test.isValid("aaaaa"));

        String result = test.test1("babad");
        System.out.println(result);

        result = test.test1("cbbd");
        System.out.println(result);

        result = test.test1("bb");
        System.out.println(result);

        System.out.println("middle.....");
        result = test.middle("babad");
        System.out.println(result);

        result = test.middle("cbbd");
        System.out.println(result);

        result = test.middle("bb");
        System.out.println(result);
    }


}
