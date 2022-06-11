package org.yj.offer;

import org.yj.application.data.structure.tree.TreeNode;

import java.util.Arrays;

public class Offer33 {


    private void postOrder(TreeNode root, StringBuilder builder) {
        if (root == null) {
            return;
        }
        postOrder(root.left, builder);
        postOrder(root.right, builder);
        builder.append(root.value);

    }

    public boolean isPostOrder(int[] array) {
        TreeNode node = createBst(array);

        System.out.println(node);
        StringBuilder builder = new StringBuilder();
        postOrder(node, builder);
        String postOrder = builder.toString();

        String res = "";
        for (int i : array) {
            res = res+i;
        }

        if (postOrder.equals(res)) {
            return true;
        }


        return false;
    }

    public TreeNode createBst(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        int[] postOrder = Arrays.copyOf(array, array.length);
        int[] inOrder = Arrays.copyOf(array, array.length);
        Arrays.sort(inOrder);
        return createBst(inOrder, postOrder);
        //return recreateBTreeByRear(inOrder, postOrder);
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


    private TreeNode createBst(int[] inOrder, int[] postOrder) {
        if (inOrder.length == 0 || postOrder.length == 0) {
            return null;
        }
        int rootValue = postOrder[postOrder.length - 1];
        TreeNode root = new TreeNode(rootValue);
        int index = findIndex(inOrder, rootValue);
        if (index != -1) {
            int[] leftInOrder = Arrays.copyOfRange(inOrder, 0, index);
            int[] leftPostOrder = Arrays.copyOfRange(postOrder, 0, index);
            root.left = createBst(leftInOrder, leftPostOrder);
            int[] rightInOrder = Arrays.copyOfRange(inOrder, index + 1, inOrder.length);
            int[] rightPostOrder = Arrays.copyOfRange(postOrder, index, inOrder.length - 1);
            root.right = createBst(rightInOrder, rightPostOrder);

        }

        return root;
    }

    private int findIndex(int[] inOrder, int value) {
        for (int i = 0; i < inOrder.length; i++) {
            if (value == inOrder[i]) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Offer33 offer = new Offer33();

        //int[] array = {1, 6, 3, 2, 5};

        int[] array = {1, 3, 2, 6, 5};
        System.out.println(offer.isPostOrder(array));
    }
}
