package com.xiao.demo;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU缓存机制
 *
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 *
 * 进阶:
 *
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 * 示例:
 *
 * LRUCache cache = new LRUCache( 2 缓存容量 );
        *
        *cache.put(1,1);
        *cache.put(2,2);
        *cache.get(1);       // 返回  1
        *cache.put(3,3);    // 该操作会使得密钥 2 作废
        *cache.get(2);       // 返回 -1 (未找到)
        *cache.put(4,4);    // 该操作会使得密钥 1 作废
        *cache.get(1);       // 返回 -1 (未找到)
        *cache.get(3);       // 返回  3
        *cache.get(4);       // 返回  4
        *
        *来源：力扣（LeetCode）
        *链接：https://leetcode-cn.com/problems/lru-cache
        *著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T146_LRU_Cache {

    private int capacity = 0;
    private Map<Integer,Node> map = null;
    private DoubleLinkedList cache = null;

    /**
     * 双向哈希链表实现
     *
     * 双链表用于实现cache缓存，hash表可以实现O(1)的查找
     * @param capacity
     */
    public T146_LRU_Cache(int capacity) {
        map = new HashMap<>(capacity);
        this.capacity = capacity;
        this.cache = new DoubleLinkedList();
    }

    public int get(int key) {
        Node node =  map.get(key);
        if(node == null){
            return -1;
        }
        cache.remove(node);
        cache.addFirst(node);
        map.put(key,node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = new Node(key,value);
        if(cache.size()==this.capacity){
            Node last =  cache.removeLast();
            map.remove(last.key);
        }
        map.put(key,node);
        cache.addFirst(node);
    }

    public static void main(String[] args) {
        T146_LRU_Cache cache = new T146_LRU_Cache(2);

        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1));       // 返回  1
        cache.put(3,3);    // 该操作会使得密钥 2 作废
        System.out.println(cache.get(2));       // 返回 -1 (未找到)
        cache.put(4,4);    // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1));       // 返回 -1 (未找到)
        System.out.println(cache.get(3));       // 返回  3
        System.out.println(cache.get(4));

        T146_LRU_Cache cache2 = new T146_LRU_Cache(1);
        cache2.put(2,1);
        System.out.println(cache2.get(2));       // 返回  1
    }

    /**
     * 节点信息
     */
    class Node {
        int key;
        int value;
        Node pre,next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * 双链表，用于作cache
     */
    class DoubleLinkedList{

        private int size;
        private Node head,tail;

        public DoubleLinkedList() {
            this.head = new Node(0,0);
            this.tail = new Node(0,0);
            this.size = 0;
            head.next = tail;
            tail.pre = head;
        }

        public void addFirst(Node node){
            node.next = head.next;
            node.pre = head;
            head.next.pre = node;
            head.next = node;
            size ++;
        }

        public Node removeLast(){

            if(tail.pre == head){
                return null;
            }
            Node last = tail.pre;
            remove(last);
            return last;
        }

        /**
         * 必须保证node存在
         * @param node
         * @return
         */
        public void remove(Node node){
            node.pre.next = node.next;
            node.next.pre = node.pre;
            size --;
        }

        public int size(){
            return size;
        }

    }
}


