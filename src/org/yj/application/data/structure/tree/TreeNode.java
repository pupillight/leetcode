package org.yj.application.data.structure.tree;

public class TreeNode {
    public String name;
    public int value;

    public TreeNode left;
    public TreeNode right;

    public TreeNode(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public TreeNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    public void frontIterate() {
        System.out.println(this.toString());

        if (this.left != null) {
            this.left.frontIterate();
        }
        if (this.right != null) {
            this.right.frontIterate();
        }
    }

    public void frontIterate(TreeNode root) {

        if (root != null) {
            System.out.println(root.toString());
            root.left.frontIterate();
            root.right.frontIterate();
        }
    }

    public TreeNode frontFind(int value, TreeNode root) {
        TreeNode node = null;
        if (root == null) {
            return null;
        }
        if (root.value == value) {
            node = root;

        }
        if (node != null) {
            return node;
        }
        node = frontFind(value, root.left);

        if (node != null) {
            return node;
        }
        node = frontFind(value, root.right);
        return node;

    }

    public void middleIterate(TreeNode root) {
        if (root != null) {
            middleIterate(root.left);
            System.out.println(root.toString());
            middleIterate(root.right);

        }
    }

    public void rearIterate(TreeNode root) {
        if (root != null) {
            rearIterate(root.left);
            rearIterate(root.right);
            System.out.println(root.toString());
        }
    }

    public TreeNode rearFind(int value, TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode node = null;
        node = rearFind(value, root.left);
        if (node != null) {
            return node;
        }

        node = rearFind(value, root.right);
        if (node != null) {
            return node;
        }
        if (root.value == value) {
            node = root;
        }

        return node;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, "宋江");
        TreeNode node1 = new TreeNode(2, "吴用");
        TreeNode node11 = new TreeNode(3, "公孙胜");
        TreeNode node2 = new  TreeNode(4, "卢俊义");
        TreeNode node3 = new  TreeNode(6, "林冲");
        TreeNode node4 = new  TreeNode(7, "武松");
        root.left = node1;
        node1.left = node11;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;

        //root.frontIterate();

//        root.frontIterate(root);
//        System.out.println("---------------");
//        root.middleIterate(root);
//        System.out.println("---------------");
//        root.rearIterate(root);

        System.out.println("---------------");
        TreeNode node = root.frontFind(4, root);
        System.out.println(node.toString());

//        TreeNode node = root.rearFind(2, root);
//        System.out.println(node.toString());
    }
}
