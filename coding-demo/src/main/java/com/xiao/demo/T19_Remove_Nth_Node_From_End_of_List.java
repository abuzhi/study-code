package com.xiao.demo;

import com.xiao.demo.pojo.ListNode;

/**
 * 删除链表的倒数第N个节点
 *
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class T19_Remove_Nth_Node_From_End_of_List {

    /**
     * 用 current + N 表示最后的节点来做
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null ){
            return head;
        }

        ListNode pre = new ListNode(0);
        pre.next = head;

        ListNode current = pre;
        ListNode end = pre;
        while (n > 0){
            end = end.next;
            n --;
        }

        while (end.next!=null){
            current = current.next;
            end = end.next;
        }

        current.next = current.next.next;

        return pre.next;
    }

    public static void main(String[] args) {
        T19_Remove_Nth_Node_From_End_of_List test = new T19_Remove_Nth_Node_From_End_of_List();

        int[] data = {1,2,3,4,5};
        ListNode head = ListNode.createList(data,0);

        ListNode  root = test.removeNthFromEnd(head,2);
        System.out.println(root.val);
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
