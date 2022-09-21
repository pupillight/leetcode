package org.yj.leetcode;

public class TreeQuestions {

    public int maxDepth1(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;

    }

    int maxDepth = -1;

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxDepth(root,1);
        return maxDepth;
    }

    private void maxDepth(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            if (depth > maxDepth) {
                maxDepth = depth;
            }
            return;
        }
        maxDepth(node.left,depth+1);
        maxDepth(node.right,depth+1);
    }

    public int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        if (root.left == null && root.right != null) {
            return right + 1;
        } else if (root.left != null && root.right == null) {
            return left + 1;
        }

        return Math.min(left, right) + 1;
    }
}
