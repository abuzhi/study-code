package com.xiao.demo;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T125_ValidPalindrome {

    /**
     * 双指针法，头尾指针向中间移动
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        boolean is = false;
        if(s==null){
            return is;
        }
        if(s.equals("")){
            return true;
        }

        int start = 0,end = s.length()-1;
        while (start<end){
            while(start<end && !Character.isLetterOrDigit(s.charAt(start))) start ++;
            while(start<end && !Character.isLetterOrDigit(s.charAt(end))) end --;

            //忽略大小写
            if(Character.toLowerCase(s.charAt(start)) == Character.toLowerCase(s.charAt(end)) ){
                start ++;
                end --;
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        String s = "A man, a plan, a canal: Panama";

        T125_ValidPalindrome test = new T125_ValidPalindrome();
        boolean is = test.isPalindrome(s);
        System.out.println(is);
    }
}
