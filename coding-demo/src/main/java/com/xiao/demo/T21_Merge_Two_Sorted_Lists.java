package com.xiao.demo;

import com.xiao.demo.pojo.ListNode;

/**
 * 合并两个有序链表
 *
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class T21_Merge_Two_Sorted_Lists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        if(l1 == null && l2==null){
            return head;
        }else if(l1 ==null ){
            return l2;
        }else if(l2==null){
            return l1;
        }

        if(l1.val < l2.val){
            head = l1;
        }else {
            head = l2;
        }
        ListNode pre = null;
        ListNode cur = null;
        pre = null;
        cur = head;

        while (l1 !=null || l2 !=null){
            if(l1.val < l2.val){
                cur = l1;
                pre.next = cur;
                cur = cur.next;
            }else {
                pre.next = l2;
                pre = l2;
                l2 = l2.next;
            }
        }

        while (l1!=null){
            pre.next = l1;
            pre = l1;
            l1 = l1.next;
        }

        while (l2!=null){
            pre.next = l2;
            pre = l2;
            l2 = l2.next;
        }

        return head;
    }

    public static void main(String[] args) {

        T21_Merge_Two_Sorted_Lists test = new T21_Merge_Two_Sorted_Lists();
        int[] a1 = {1,2,4};
        int[] a2 = {1,3,4};
        ListNode node = test.mergeTwoLists(ListNode.createList(a1,0),ListNode.createList(a2,0));
        System.out.println(node);
        // TODO: 2019/8/4 no 
    }
}
