package com.xiao.demo;

import java.util.Stack;

/**
 * 最小栈
 * <p>
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T155_Min_Stack {

    private Stack<Integer> stack;
    private Stack<Integer> mindata;

    public T155_Min_Stack() {

        stack = new Stack<>();
        mindata = new Stack<>();

    }

    public void push(int x) {
        stack.push(x);
        if (mindata.isEmpty() || mindata.peek() > x) {
            mindata.push(x);
        } else {
            mindata.push(mindata.peek());
        }
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        stack.pop();
        mindata.pop();
    }

    public int top() {
        if (!stack.isEmpty()) {
            return stack.peek();
        }
        throw new RuntimeException("栈中元素为空，此操作非法");
    }

    public int getMin() {
        if (!stack.isEmpty()) {
            return mindata.peek();
        }
        throw new RuntimeException("error");
    }

    /**
     * 此题的点在于维护一个同步的stack
     *
     * @param args
     */
    public static void main(String[] args) {
        T155_Min_Stack minStack = new T155_Min_Stack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println( minStack.top());
        System.out.println( minStack.getMin());
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
