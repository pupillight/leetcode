package org.yj.leetcode;

import javax.swing.table.TableRowSorter;
import java.util.LinkedList;

public class Leetcode1315 {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(7);
        root.right = new TreeNode(8);
        Leetcode1315.sumEvenGrandparent(root);
    }

    public static int sumEvenGrandparent(TreeNode root) {
        int res = 0;
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);


        int index = 0;
        while (!list.isEmpty()) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = list.poll();
                System.out.println(node.val);
                if (node.left != null) {
                    list.add(node.left);
                }
                if (node.right != null) {
                    list.add(node.right);
                }
                if (node.val % 2 == 0) {
                    index = index + 2;
                }
            }

        }


        return res;
    }


    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (root.left == null && root.right != null) {
            return right + 1;
        }
        if (root.left != null && root.right == null) {
            return left + 1;
        }
        return Integer.min(left, right) + 1;

    }
/*    public static int maxDepth1(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Integer.max(left, right) + 1;

    }
    int res = 0;
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxDepth(root, 0);
        return res;
    }

    private void maxDepth(TreeNode node, int index) {
        if (node == null) {
            return;
        }
        if (index > res) {
            res = index;
        }
        maxDepth(node.left, index + 1);
        maxDepth(node.right, index + 1);
    }*/
}
