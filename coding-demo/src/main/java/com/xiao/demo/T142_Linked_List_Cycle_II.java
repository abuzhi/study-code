package com.xiao.demo;

import com.xiao.demo.pojo.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 环形链表 II
 *
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 说明：不允许修改给定的链表。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 示例 2：
 *
 * 输入：head = [1,2], pos = 0
 * 输出：tail connects to node index 0
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 *
 * 示例 3：
 *
 * 输入：head = [1], pos = -1
 * 输出：no cycle
 * 解释：链表中没有环。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T142_Linked_List_Cycle_II {
    public ListNode detectCycle(ListNode head) {

        return test1(head);
    }

    /**
     * hashset 存放对象
     * @param head
     * @return
     */
    public ListNode test1(ListNode head){
        Set<ListNode> set = new HashSet<>();
        int index = 0;

        while (head!=null){
            if(set.contains(head)){
                System.out.println("tail connects to node index " + index);
                return head;
            }else {
                set.add(head);
            }
            head = head.next;
            index ++;
        }

        System.out.println("no cycle");
        return null;
    }


    /**
     * Floyd 算法,时间复杂度为O(n)
     *
     * Floyd 的算法被划分成两个不同的 阶段 。在第一阶段，找出列表中是否有环，如果没有环，可以直接返回 null 并退出。
     * 否则，用 相遇节点 来找到环的入口。
     * 给定阶段 1 找到的相遇点，阶段 2 将找到环的入口。首先我们初始化额外的两个指针： ptr1 ，指向链表的头， ptr2 指向相遇点。
     * 然后，我们每次将它们往前移动一步，直到它们相遇，它们相遇的点就是环的入口，返回这个节点。
     *
     * 这个办法很巧妙，是利用了规律或者定理
     * @param head
     * @return
     */
    public ListNode test2(ListNode head){

        if(head==null || head.next ==null){
            System.out.println("no cycle");
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode p1 = head; //用于标识头节点，在找到环后，第2 阶段用
        ListNode p2 = null; //用于标识第1阶段中的相遇节点

        while (fast !=null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                // 有环
                // 关键代码在这里了，每次p1，p2向前移动一步，直到相遇，即为入口点
                p2 = slow;
                int index = 0;
                while (p1!=p2){
                    p1 = p1.next;
                    p2 = p2.next;
                    index ++;
                }

                System.out.println("tail connects to node index " + index);
                return p2;
            }
        }

        //无环
        return p2;
    }


        public static void main(String[] args) {

        int[] data = {3,2,0,-4};
        int pos = 1;
        ListNode tmp = null;
        ListNode head = ListNode.createCycleList(data,0,pos,tmp);
        T142_Linked_List_Cycle_II test = new T142_Linked_List_Cycle_II();
        System.out.println(test.test1(head));
        System.out.println(test.test2(head));

        tmp = null;
        int[] data1 = {1,2};

        head = ListNode.createCycleList(data1,0,-1,tmp);
        System.out.println(test.test1(head));
        System.out.println(test.test2(head));
    }
}
