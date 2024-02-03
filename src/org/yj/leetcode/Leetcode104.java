package org.yj.leetcode;

import org.yj.application.data.collections.Map;

public class Leetcode104 {

    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        int res = Math.max(leftDepth, rightDepth) + 1;
        return res;
    }

    public boolean isBalanced(TreeNode root) {
        int h = treeHeight(root);
        if (h == -1) {
            return false;
        }
        return true;
    }

    private int treeHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int l = treeHeight(node.left);
        if (l == -1) {
            return -1;
        }
        int r = treeHeight(node.right);
        if (r == -1) {
            return -1;
        }
        if (Math.abs(l - r) > 1) {
            return -1;
        }
        int h = Math.max(l, r) + 1;
        return h;
    }


    public static void main(String[] args) {
        Leetcode104 instance = new Leetcode104();
    /*    TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(instance.maxDepth(root));*/

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        /*root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);*/
        System.out.println(instance.isBalanced(root));

    }
}
