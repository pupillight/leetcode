package org.yj.leetcode;


public class LeetCode404 {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = sumOfLeftLeaves(root.left);
        int r = sumOfLeftLeaves(root.right);
        if (root.left != null && (root.left.left == null && root.left.right == null)) {
            return l + r + root.left.val;
        }
        return l + r;

    }

    public static void main(String[] args) {
        LeetCode404 instance = new LeetCode404();
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(instance.sumOfLeftLeaves(root));


    }

}
