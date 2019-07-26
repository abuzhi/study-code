package com.xiao.demo.pojo;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

    public static ListNode createList(int[] data, int index){
        if(index == data.length -1 ){
            return new ListNode(data[index]);
        }
        ListNode cur = new ListNode(data[index]);
        cur.next = createList(data,index + 1);

        return cur;
    }

}
