package org.yj.leetcode;

import java.util.*;

public class LeetCode146 {

    public static void main(String[] args) {
        LeetCode146 leetCode = new LeetCode146();

        LRUCache lruCache = new LRUCache(2);

        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));

    }


}


class LRUCache {

    public static class Node {
        int key;
        int value;
        Node next;
        Node pre;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int capacity = 0;
    Map<Integer, Node> map;
    Node head;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap();
        head = new Node(0, 0);
        head.pre = head;
        head.next = head;
    }

    private void remove(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;

    }

    private void addNode(Node node) {
        node.pre = head;
        node.next = head.next;
        node.pre.next = node;
        node.next.pre = node;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            addNode(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            addNode(node);
            node.value=value;
            map.put(key, node);
            return;
        }

        if (map.size() == capacity) {
            Node lastNode = head.pre;
            remove(lastNode);
            map.remove(lastNode.key);
        }
        Node node = new Node(key, value);
        map.put(key, node);
        addNode(node);
    }
}