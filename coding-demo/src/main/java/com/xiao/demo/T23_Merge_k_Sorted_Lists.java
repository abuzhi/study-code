package com.xiao.demo;

import com.xiao.demo.pojo.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * 合并K个排序链表
 *
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class T23_Merge_k_Sorted_Lists {

    public ListNode mergeKLists(ListNode[] lists) {

        return null;
    }

    /**
     * 投机
     * 合并扫一遍，再快排
     * @param lists
     */
    public ListNode test1(ListNode[] lists){

        if(lists==null || lists.length ==0){
            return null;
        }
        if(lists.length == 1 ){
            return lists[0];
        }

        List<Integer> arr = new ArrayList<>();
        for(int i=0;i<lists.length;i++){
            ListNode tmp = lists[i];
            while (tmp!=null){
                arr.add(tmp.val);
                tmp = tmp.next;
            }
        }

        if(arr.size()==0){
            return null;
        }
        Integer[] result = arr.toArray(new Integer[arr.size()]);

        Arrays.sort(result);

        ListNode head = new ListNode(result[0]);
        ListNode pre = head;
        for(int k = 1;k<result.length;k++){
            ListNode current = new ListNode(result[k]);
            pre.next = current;
            pre = current;
        }

        return head;
    }

    public static void main(String[] args) {

        T23_Merge_k_Sorted_Lists test = new T23_Merge_k_Sorted_Lists();

        int[] d1 = {1,4,5};
        int[] d2 = {1,3,4};
        int[] d3 = {2,6};

        ListNode l1 = ListNode.createList(d1,0);
        ListNode l2 = ListNode.createList(d2,0);
        ListNode l3 = ListNode.createList(d3,0);

        ListNode[] data = {l1,l2,l3};

        ListNode result = test.test1(data);
        System.out.println(result);
    }

}
