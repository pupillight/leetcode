package org.yj.application.data.collections;

public class BstMap<K extends Comparable<K>, V> implements Map<K, V> {

    class Node {
        public K key;
        public V value;
        public Node left;
        public Node right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }

    }

    public Node root;
    public int size;

    public BstMap() {
        root = null;
        size = 0;
    }

    public BstMap(K key, V value) {
        root = new Node(key, value);
        size++;
    }

    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            node = new Node(key, value);
            return node;
        }
        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else {
            node.value = value;
        }

        return node;
    }

    @Override
    public V remove(K key) {
        V res = get(key);
        root = remove(root, key);
        return res;
    }

    private Node remove(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        } else {
            if (node.left == null) {
                Node rNode = node.right;
                node.right = null;
                size--;
                return rNode;
            }
            if (node.right == null) {
                Node lNode = node.left;
                node.left = null;
                size--;
                return lNode;
            }
            Node successor = miniNode(node.right);
            successor.left = node.left;
            successor.right = deleteMiniNode(node.right);
            node.left = node.right = null;
            return successor;
        }
    }

    private Node deleteMiniNode(Node node) {
        if (node == null) {
            return null;
        }
        if (node.left == null) {
            Node rNode = node.right;
            node.right = null;
            size--;
            return rNode;
        }
        node.left = deleteMiniNode(node.left);
        return node;
    }

    private Node miniNode(Node node) {
        if (node == null) {
            return null;
        }
        if (node.left == null) {
            return node;
        }
        return miniNode(node.left);
    }

    @Override
    public boolean contains(K key) {
        Node node = this.getNode(root, key);
        return node == null ? false : true;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        } else if (key.compareTo(node.key) > 0) {
            return getNode(node.right, key);
        }else{
            return node;
        }
    }

    @Override
    public void set(K key, V newValue) {
        add(key, newValue);
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0 ? true : false;
    }

    public static void main(String[] args) {
        BstMap<Integer, Integer> map = new BstMap<>();
        map.add(2, 2);
        map.add(1, 1);
        map.add(3, 3);
        map.add(4, 4);
        System.out.println(map.getSize());
        System.out.println(map.contains(3));
       // map.remove(3);
       // System.out.println(map.getSize());
    }
}


