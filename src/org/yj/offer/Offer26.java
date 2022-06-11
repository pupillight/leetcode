package org.yj.offer;

import org.yj.application.data.structure.tree.TreeNode;

public class Offer26 {
/*

    public boolean isChildNode(TreeNode nodeA, TreeNode nodeB) {

        if (nodeA == null || nodeB == null) {
            return false;
        }

        return isChild(nodeA, nodeB);


    }


    public TreeNode preOrder(TreeNode nodeA, TreeNode nodeB) {
        if (nodeA.value == nodeB.value) {
            return nodeA;
        }
        return preOrder(nodeA, nodeB);
    }

    public boolean isEqual(TreeNode a, TreeNode b)
    {
        if(a.value == b.value){
           if(a.left!=null)
           {
               isEqual(a.left,b.left);
           }
            return true;
        }

        return false;
    }

    private boolean isChild(TreeNode nodeA, TreeNode nodeB) {
        if (nodeA == null && nodeB == null) {
            return true;
        }

        if (nodeA.value == nodeB.value) {


            return isChild(nodeA.left, nodeB.left) && isChild(nodeA.right, nodeB.right);
        } else {
            return isChild(nodeA.left, nodeB) && isChild(nodeA.right, nodeB);
        }
    }
*/


    public boolean isChild(int[] a, int[] b, int aIndex, int bIndex) {
        if (aIndex > a.length - 1 || bIndex > b.length - 1) {
            return false;
        }
        if (a[aIndex] == b[bIndex]) {
            return true;
        }
        boolean res = isChild(a, b, 2 * aIndex + 1, 2 * bIndex + 1) && isChild(a, b, 2 * aIndex + 2, 2 * bIndex + 2);
        return res;
    }

    public boolean isChild(int[] a, int[] b) {
        if (a == null || b == null) {
            return false;
        }
        int childIndex = 0;
        int childRoot = b[childIndex];
        int index = findIndex(a, childRoot);

        if (index < 0) {
            return false;
        }

       boolean res= isChild(a,b,2*index+1,2*childIndex+1) &&isChild(a,b,2*index+2,2*childIndex+2);

        return res;
    }

    private int findIndex(int[] array, int childRootVal) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == childRootVal) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Offer26 offer = new Offer26();

        int[] a = {3, 4, 5, 1, 2};
        int[] b = {4, 1};
        offer.isChild(a, b);
   /*     TreeNode a = new TreeNode(3);
        a.left = new TreeNode(4);
        a.left.left = new TreeNode(1);
        a.left.right = new TreeNode(2);
        a.right = new TreeNode(5);

        TreeNode b = new TreeNode(4);
        b.left = new TreeNode(1);
        b.right = new TreeNode(2);
        System.out.println(offer.isChildNode(a, b));*/

    }
}
