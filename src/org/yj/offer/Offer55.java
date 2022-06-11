package org.yj.offer;

import org.yj.application.data.structure.tree.TreeNode;

import javax.swing.*;
import java.util.Stack;

public class Offer55 {

  /*  public int sum(int[] array) {
        return sum(array, array.length - 1);
    }

    private int sum(int[] array, int i) {
        if (i == 0) {
            return array[0];
        }
        int res = sum(array,i-1) + array[i];
        //System.out.println(res);
        return res;
    }

    private int sum(int[] array, int i, int j) {
        if (0 == j) {
            return array[0];
        }
        int res = sum(array, i, --j) + array[j];
        return res;
        //return array[i] + sum(array, ++i, j);
    }*/


    public int deep(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = deep(root.left);
        int right = deep(root.right);
        return Math.max(left, right) + 1;
    }


    public boolean isBst(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = deep(root.left);
        int right = deep(root.right);
        boolean isBalance = Math.abs(left - right) > 1 ? false : true;

        return isBalance;
    }

    /*public int calculateDeep(TreeNode root) {
        int count = 0;
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            int m = stack.size();
            count++;
            for (int i = 0; i < m; i++) {
                TreeNode node = stack.pop();
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
            }


        }
        System.out.println(count);

        return count;
    }*/

    public void frontPrint(TreeNode node) {
        if (node == null) return;

        System.out.println(node.value);
        frontPrint(node.left);
        frontPrint(node.right);
    }

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode node1 = mirrorTree(root.left);
        TreeNode node2 = mirrorTree(root.right);

        root.right = node1;
        root.left = node2;

        return root;
    }

    public boolean isSymmetry(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetry(root.left, root.right);
    }

    private boolean isSymmetry(TreeNode left, TreeNode right) {
        boolean res = false;
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        } else {
            res = (left.value == right.value) && isSymmetry(left.left, right.right) && isSymmetry(left.right, right.left);
        }

        return res;
    }

/*    public boolean isSymmetry(TreeNode root) {
        if (root == null) {
            return true;
        }

        TreeNode tmp=root;
        TreeNode root1 = mirrorTree(tmp);

        frontPrint(root);

        System.out.println("----------");
        frontPrint(root1);

        return isSymmetry(root, root1);
    }

    private boolean isSymmetry(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        return root1.value==root2.value && isSymmetry(root1.left, root2.left) && isSymmetry(root1.right, root2.right);
    }*/

    public static void main(String[] args) {
        Offer55 offer = new Offer55();
       /* TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(17);*/
        /* root.right.right.right.right = new TreeNode(10);*/
        // System.out.println(offer.isBst(root));

        /*TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        System.out.println(offer.deep(root));*/

        /*int[] array = {1, 2, 3};
        System.out.println(offer.sum(array));*/


        /*TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        //root.right.right.right = new TreeNode(17);

        offer.frontPrint(root);
        offer.mirrorTree(root);
        System.out.println("-----------------");
        offer.frontPrint(root);*/


        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        //root.left.left = new TreeNode(3);
        //root.left.right = new TreeNode(4);

        root.right = new TreeNode(3);
        //root.right.left = new TreeNode(4);
        //root.right.right = new TreeNode(3);
//      TreeNode tt = offer.mirrorTree(root);
//       offer.frontPrint(root);
//
//        System.out.println("-----------------");
//        //offer.frontPrint(root);
//        System.out.println(offer.isSymmetry(root));

        offer.mirrorTree(root);

        offer.frontPrint(root);
        System.out.println(offer.isSymmetry(root));
    }
}
