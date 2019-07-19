package com.xiao.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 有效的括号
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T20_Valid_Parentheses {

    /**
     * 用栈做
     * @param s
     * @return
     */
    public boolean isValid(String s){
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');

        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                char top = stack.isEmpty() ? 'a' : stack.pop();
                //匹配
                if(top != map.get(c)){
                    return false;
                }
            }else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }

    public boolean test1(String s){
        if(s==null || s.length()==0){
            return true;
        }


        return true;

    }

    public static void main(String[] args) {
        T20_Valid_Parentheses test = new T20_Valid_Parentheses();

        String s = "()[]{}";
        boolean isValid = test.isValid(s);
        System.out.println(isValid);

        s = "([)]";
        isValid = test.isValid(s);
        System.out.println(isValid);

        s = "";
        isValid = test.isValid(s);
        System.out.println(isValid);


    }
}
