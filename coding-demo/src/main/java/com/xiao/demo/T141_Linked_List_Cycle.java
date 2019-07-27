package com.xiao.demo;

import com.xiao.demo.pojo.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 环形链表
 *
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 *
 * 示例 2：
 *
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 *示例 3：
 *
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 *
 * 进阶：
 *
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T141_Linked_List_Cycle {
    public boolean hasCycle(ListNode head) {

        return false;
    }

    /**
     * hashset 存放对象
     * @param head
     * @return
     */
    public boolean test1(ListNode head){

        Set<ListNode> set = new HashSet<>();

        while (head!=null){
            if(set.contains(head)){
                return true;
            }else {
                set.add(head);
            }

            head = head.next;
        }

        return false;
    }

    /**
     * 快慢指针来做
     * @param head
     * @return
     */
    public boolean test2(ListNode head){
        if(head==null || head.next==null){
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast!=slow){
            if(fast ==null || fast.next ==null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }

    public static void main(String[] args) {

        int[] data = {3,2,0,-4};
        int pos = 1;
        ListNode tmp = null;
        ListNode head = ListNode.createCycleList(data,0,pos,tmp);

        T141_Linked_List_Cycle test = new T141_Linked_List_Cycle();
        System.out.println(test.test1(head));
        System.out.println(test.test2(head));

        tmp = null;
        int[] data1 = {1,2};

        head = ListNode.createCycleList(data1,0,-1,tmp);

        System.out.println(test.test1(head));
        System.out.println(test.test2(head));

    }
}
