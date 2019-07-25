package com.xiao.demo;

import com.xiao.demo.pojo.ListNode;

/**
 * Created by xiaoliang on 2017/3/22.
 * 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T2_Add_Two_Numbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int dist = 0;
        ListNode rusult = new ListNode(dist);
        ListNode head = rusult;

        while (l1 != null || l2 != null) {

            int val1 = l1 == null? 0: l1.val;
            int val2 = l2 == null? 0: l2.val;

            int tmp = (rusult.val + val1 + val2) % 10;
            dist = (rusult.val + val1 + val2) / 10;

            rusult.val = tmp;

            l1 = l1 == null? null: l1.next;
            l2 = l2 == null? null: l2.next;
            if((l1==null)&&(l2==null)){break;}
            rusult.next = new ListNode(dist);
            rusult = rusult.next;
        }
        if(dist>0){
            rusult.next = new ListNode(1);
        }

        return head;
    }


    public static void main(String[] args) {
        T2_Add_Two_Numbers t2 = new T2_Add_Two_Numbers();
        ListNode n1 = new ListNode(1);
//        n1.next = new ListNode(8);
//        n1.next.next = new ListNode(3);

        ListNode n2 = new ListNode(9);
        n2.next = new ListNode(9);
//        n2.next.next = new ListNode(2);

        ListNode result = t2.addTwoNumbers(n1, n2);
        System.out.print("ok");
    }
}

