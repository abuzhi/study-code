package com.xiao.demo;

/**
 * 反转链表
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T206_Reverse_Linked_List {
    /**
     * 代码编写能力
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next == null){
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;

        while (cur !=null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;

    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }


    public ListNode createList(int[] data,int index){
        if(index == data.length -1 ){
            return new ListNode(data[index]);
        }
        ListNode cur = new ListNode(data[index]);
        cur.next = createList(data,index + 1);

        return cur;
    }

    public static void main(String[] args) {

        T206_Reverse_Linked_List test = new T206_Reverse_Linked_List();
        int[] data = {1,2,3,4,5};
        ListNode head = test.createList(data,0);
        System.out.println(head.toString());

        ListNode rev = test.reverseList(head);
        System.out.println(rev.toString());
    }
}
