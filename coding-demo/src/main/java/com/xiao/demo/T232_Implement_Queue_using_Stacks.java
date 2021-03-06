package com.xiao.demo;

import java.util.Stack;

/**
 * 用栈实现队列
 * 使用栈实现队列的下列操作：
 *
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空。
 * 示例:
 *
 * MyQueue queue = new MyQueue();
 *
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // 返回 1
 * queue.pop();   // 返回 1
 * queue.empty(); // 返回 false
 * 说明:
 *
 * 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-queue-using-stacks
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T232_Implement_Queue_using_Stacks {

    private Stack<Integer> stackIn = null;
    private Stack<Integer> stackOut = null;

    /**
     * Initialize your data structure here.
     */
    public T232_Implement_Queue_using_Stacks() {

        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stackIn.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if(stackOut.isEmpty()){
            while (!stackIn.isEmpty()){
                stackOut.push(stackIn.pop());
            }
        }
        return stackOut.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        int top = this.pop();
        stackOut.push(top);
        return top  ;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stackOut.isEmpty() && stackIn.isEmpty();
    }


    /**
     * 代码的话不是很难
     * 主要思想在于 用两个stack 来模拟队列，一个用来入，一个用来出。并且出队列的时候，才进行数据的移动
     * @param args
     */
    public static void main(String[] args) {
        T232_Implement_Queue_using_Stacks test = new T232_Implement_Queue_using_Stacks();

        test.push(1);
        test.push(2);
        int param_2 = test.pop();
        int param_3 = test.peek();
        boolean param_4 = test.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */