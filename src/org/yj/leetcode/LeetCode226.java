package org.yj.leetcode;

import org.yj.application.data.structure.stack.Node;
import org.yj.application.data.structure.tree.TreeNode;

public class LeetCode226 {


    public TreeNode reverseBst(TreeNode root) {

        if (root == null) {
            return null;
        }
        TreeNode node1 = reverseBst(root.left);
        TreeNode node2 = reverseBst(root.right);
        root.right = node1;
        root.left = node2;
        return root;
    }


    public void preList(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.value);
        preList(node.left);
        preList(node.right);
    }

    public void midList(TreeNode node) {
        if (node == null) {
            return;
        }
        midList(node.left);
        System.out.println(node.value);
        midList(node.right);
    }

    public void rearList(TreeNode node) {
        if (node == null) {
            return;
        }
        rearList(node.left);
        rearList(node.right);
        System.out.println(node.value);
    }

    public static void main(String[] args) {
        LeetCode226 leetCode = new LeetCode226();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        //root.left.left = new TreeNode(21);
        //root.left.right = new TreeNode(22);

        root.right = new TreeNode(3);
        //root.right.left = new TreeNode(31);
        //root.right.right = new TreeNode(32);


        //leetCode.preList(root);
        //leetCode.midList(root);
        leetCode.reverseBst(root);
        System.out.println("--------------");
        leetCode.preList(root);
    }
}
