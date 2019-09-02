package com.xiao.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoliang on 2017/3/27.
 * Z 字形变换
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * 示例 1:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * <p>
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T6_ZigZag_Conversion {
    public String convert(String s, int numRows) {
        if(s==null || s.length() <2){
            return s;
        }
        Map<Integer, StringBuilder> map = new HashMap<>();
        for (int i = 0; i < numRows; i++) {
            map.put(i, new StringBuilder());
        }
        int index = 0;
        int row = 0;
        int col = 0;

        while (col < numRows) {
            while (row < numRows) {
                StringBuilder sb = map.get(row);
                sb.append(s.charAt(index));
                row++;
                index++;
                if (index == s.length()) {
                    break;
                }
            }
            col++;
            row--;
            row--;
            if (index == s.length()) {
                break;
            }

            while (row > 0) {
                StringBuilder sb = map.get(row);
                sb.append(s.charAt(index));
                col++;
                row--;
                index++;
                if (index == s.length()) {
                    break;
                }
            }
            col = 0;
            row = 0;
            if (index == s.length()) {
                break;
            }
        }

        String result = "";
        for(StringBuilder val : map.values()){
            result = result + val.toString();
        }
        return result;
    }

    public static void main(String[] args) {

        String s = "LEETCODEISHIRING";

        T6_ZigZag_Conversion test = new T6_ZigZag_Conversion();
        System.out.println(test.convert(s,3));
        System.out.println("LCIRETOESIIGEDHN");
    }
}
