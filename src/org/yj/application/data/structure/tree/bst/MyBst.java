package org.yj.application.data.structure.tree.bst;

import java.util.Random;

public class MyBst<T extends Comparable<T>> {
    private TreeNode<T> root;
    int size = 0;

    public MyBst() {
        root = null;
    }

    public boolean contains(T value) {
        return contains(root, value);
    }

    private boolean contains(TreeNode<T> node, T value) {
        if (node == null) {
            return false;
        }
        if (node.value.compareTo(value) == 0) {
            return true;
        } else if (node.value.compareTo(value) < 0) {
            return contains(node.left, value);
        } else {
            return contains(node.right, value);
        }
    }

    public void add(T value) {
        root = add(root, value);
    }

    private TreeNode add(TreeNode<T> node, T value) {

        if (node == null) {
            node = new TreeNode<>(value);
            return node;
        }
        if (value.compareTo(node.value) < 0) {
            node.left = add(node.left, value);
        } else if (value.compareTo(node.value) > 0) {
            node.right = add(node.right, value);
        }

        return node;

    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(TreeNode<T> node) {
        if (node == null) {
            return;
        }
        System.out.println(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder() {
        inOrder(root);

    }

    private void inOrder(TreeNode<T> node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.value);
        inOrder(node.right);
    }

    public static void main(String[] args) {
        MyBst<Integer> bst = new MyBst<>();
        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            int value = random.nextInt(10);
            System.out.println(value);
            bst.add(value);
        }
    /*    bst.add(10);
        bst.add(20);
        bst.add(5);
        bst.add(9);*/
        System.out.println("----------");
        bst.preOrder();
        System.out.println("----------");
        bst.inOrder();
    }
}

class TreeNode<T> {
    public TreeNode<T> left;
    public TreeNode<T> right;
    public T value;

    public TreeNode(T value) {
        this.value = value;
    }
}
