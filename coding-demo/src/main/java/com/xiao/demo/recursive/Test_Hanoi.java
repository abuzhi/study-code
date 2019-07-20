package com.xiao.demo.recursive;

import java.util.Arrays;
import java.util.Stack;

/**
 *
 * 汉诺塔问题
 *
 * A,B,C三柱子
 * A上有64个从小到大的盘子，移动到C上，移动过程中只能按小盘在大盘之上的顺序放。
 */
public class Test_Hanoi {

    int count = 0;
    Stack<Integer> A = new Stack<>();
    Stack<Integer> B = new Stack<>();
    Stack<Integer> C = new Stack<>();
    {
        A.push(4);
        A.push(3);
        A.push(2);
        A.push(1);
    }

    /**
     * 汉诺塔问题是把n-1的盘子当作一个整体看
     * @param n
     * @param start
     * @param middle
     * @param end
     */
    public void hanoi(int n,Stack<Integer> start,Stack<Integer> middle,Stack<Integer> end){
        if(n==0){
            return;
        }else {
            //把A上的n-1个盘子通过C移动到B上面
            hanoi(n-1,start,end,middle);
            //倒数第二步是把A上第n个盘子移动到C上
            move(n,start,end);
            //把B上的所有盘子通过A移动到C上
            hanoi(n-1,middle,start,end);
        }

    }

    private void move(int n,Stack<Integer> start,Stack<Integer> end){
        count ++;
        int num = start.pop();
        end.push(num);
        System.out.print(Arrays.toString(A.toArray()) + Arrays.toString(B.toArray()) + Arrays.toString(C.toArray()));
        System.out.println();
    }


    public static void main(String[] args) {
        Test_Hanoi test = new Test_Hanoi();

        test.hanoi(test.A.size(),test.A,test.B,test.C);

    }


}
