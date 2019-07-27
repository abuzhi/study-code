package com.xiao.demo.pojo;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
        val = x;
    }

//    @Override
//    public String toString() {
//        return "ListNode{" +
//                "val=" + val +
//                ", next=" + next +
//                '}';
//    }

    public static ListNode createList(int[] data, int index){
        if(index == data.length -1 ){
            return new ListNode(data[index]);
        }
        ListNode cur = new ListNode(data[index]);
        cur.next = createList(data,index + 1);

        return cur;
    }

    /**
     * 创建一个环形链表
     * @param data
     * @param index
     * @param pos
     * @param tmp
     * @return
     */
    public static ListNode createCycleList(int[] data, int index,int pos,ListNode tmp){
        if(index == data.length -1 ){
            ListNode tail = new ListNode(data[index]);
            tail.next = tmp;
            return tail;
        }
        ListNode cur = new ListNode(data[index]);
        if(index == pos){
            tmp = cur;
        }
        cur.next = createCycleList(data,index + 1,pos,tmp);

        return cur;
    }

}
