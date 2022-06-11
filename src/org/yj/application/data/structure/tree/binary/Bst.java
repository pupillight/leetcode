package org.yj.application.data.structure.tree.binary;

import org.yj.application.data.structure.stack.Node;

public class Bst<T extends Comparable<T>> {
    public int size;
    public TreeNode<T> root;

    public Bst() {
        size = 0;
        root = null;
    }

    public boolean isEmpty() {
        return size == 0 ? true : false;
    }

    public void add(T value) {
        root = add(root, value);
    }

    public TreeNode minNode() {
        return minNode(root);
    }

    private TreeNode minNode(TreeNode<T> node) {
        if (node == null) {
            return null;
        }
        if (node.left == null) {
            return node;
        }
        return minNode(node.left);
    }

    public TreeNode maxNode() {
        return maxNode(root);
    }

    private TreeNode maxNode(TreeNode<T> node) {
        if (node == null) {
            return null;
        }
        if (node.right == null) {
            return node;
        }
        return maxNode(node.right);
    }

    private TreeNode add(TreeNode<T> node, T value) {
        if (node == null) {
            node = new TreeNode(value);
            size++;
            return node;
        }
        if (value.compareTo(node.value) < 0) {
            node.left = add(node.left, value);
        } else if (value.compareTo(node.value) > 0) {
            node.right = add(node.right, value);
        }
        return node;
    }

    public TreeNode deleteMiniNode() {
        return deleteMiniNode(root);
    }

    private TreeNode deleteMiniNode(TreeNode<T> node) {
        if (node == null) {
            return null;
        }
        if (node.left == null) {
            TreeNode rNode = node.right;
            node.right = null;
            size--;
            return rNode;
        }
        node.left = deleteMiniNode(node.left);
        return node;
    }


    public TreeNode deleteMaxNode() {
        return deleteMaxNode(root);
    }

    private TreeNode deleteMaxNode(TreeNode<T> node) {
        if (node == null) {
            return null;
        }
        if (node.right == null) {
            TreeNode lNode = node.left;
            node.left = null;
            size--;
            return lNode;
        }
        node.right = deleteMaxNode(node.right);
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

    public TreeNode delete(T value) {
        root= delete(root, value);
        return root;
        //return delete(root, value);
    }

    private TreeNode delete(TreeNode<T> node, T value) {
        if (node == null) {
            return null;
        }
        if (node.value.compareTo(value) > 0) {
            node.left = delete(node.left, value);
            return node;
        } else if (node.value.compareTo(value) < 0) {
            node.right = delete(node.right, value);
            return node;
        } else {
            if (node.left == null) {
                TreeNode rNode = node.right;
                node.right = null;
                size--;
                return rNode;
            }
            if (node.right == null) {
                TreeNode lNode = node.left;
                node.left = null;
                size--;
                return lNode;
            }
            TreeNode successor = minNode(node.right);
            successor.right = deleteMiniNode(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
    }

    public static void main(String[] args) {
        Bst<Integer> bTree = new Bst();
        bTree.add(20);
        bTree.add(10);
        bTree.add(15);
        bTree.add(30);
        bTree.add(25);
        bTree.add(50);
        bTree.preOrder();
        System.out.println();
        //ystem.out.println(bTree.minNode().value);
        //System.out.println(bTree.maxNode().value);

        //bTree.deleteMiniNode();
        //bTree.deleteMaxNode();

        bTree.delete(20);
        //System.out.println(bTree.size);

        bTree.preOrder();
    }


}

class TreeNode<T> {

    public T value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
