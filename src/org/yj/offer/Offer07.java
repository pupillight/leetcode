package org.yj.offer;

import org.yj.application.data.structure.tree.TreeNode;

import java.util.Arrays;

public class Offer07 {

    public TreeNode recreateBTreeByPre(int[] preOrder, int[] inOrder) {
        if (preOrder.length == 0 || inOrder.length == 0) {
            return null;
        }
        int rootValue = preOrder[0];
        TreeNode root = new TreeNode(rootValue);
        int index = findIndex(inOrder, rootValue);
        if (index != -1) {
            //left child elements
            int[] leftPreOrder = Arrays.copyOfRange(preOrder, 1, index + 1);
            int[] leftInOrder = Arrays.copyOfRange(inOrder, 0, index);
            root.left = recreateBTreeByPre(leftPreOrder, leftInOrder);
            //right child elements
            int[] rightPreOrder = Arrays.copyOfRange(preOrder, index + 1, inOrder.length);
            int[] rightInOrder = Arrays.copyOfRange(inOrder, index + 1, inOrder.length);
            root.right = recreateBTreeByPre(rightPreOrder, rightInOrder);
        }

        return root;
    }
    public TreeNode recreateBTreeByRear(int[] inOrder, int[] rearOrder) {
        if (rearOrder.length == 0 || inOrder.length == 0) {
            return null;
        }
        int rootValue = rearOrder[rearOrder.length - 1];
        TreeNode root = new TreeNode(rootValue);
        int index = findIndex(inOrder, rootValue);
        if (index != -1) {
            //left child elements
            int[] leftInOrder = Arrays.copyOfRange(inOrder, 0, index);
            int[] leftRearOrder = Arrays.copyOfRange(rearOrder, 0, index);
            root.left = recreateBTreeByRear(leftInOrder, leftRearOrder);
            //right child elements
            int[] rightInOrder = Arrays.copyOfRange(inOrder, index + 1, inOrder.length);
            int[] rightRearOrder = Arrays.copyOfRange(rearOrder, index, rearOrder.length - 1);
            root.right = recreateBTreeByRear(rightInOrder, rightRearOrder);
        }
        return root;
    }





    public int findIndex(int[] inOrder, int value) {
        for (int i = 0; i < inOrder.length; i++) {
            if (inOrder[i] == value) {
                return i;
            }
        }

        return -1;
    }

    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.value);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        Offer07 offer = new Offer07();

        int[] preOrder = {3, 9, 20, 15, 7};
        int[] inOrder = {9, 3, 15, 20, 7};
        TreeNode root1 = offer.recreateBTreeByPre(preOrder, inOrder);

        offer.preOrder(root1);
        System.out.println(root1);

        int[] rearOrder = {9, 15, 7, 20, 3};
        TreeNode root2 = offer.recreateBTreeByRear(inOrder, rearOrder);
        System.out.println(root2);
        offer.preOrder(root2);


    }
}
