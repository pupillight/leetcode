package org.yj.leetcode;

import javax.swing.table.TableRowSorter;
import java.util.LinkedList;

public class Leetcode1315 {


    public static void main(String[] args) {
        TreeNode root= new TreeNode(6);
        root.left= new TreeNode(7);
        root.right= new TreeNode(8);
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
            int size =list.size();
            for(int i=0;i<size;i++)
            {
                TreeNode node = list.poll();
                System.out.println(node.val);
                if (node.left != null) {
                    list.add(node.left);
                }
                if (node.right != null) {
                    list.add(node.right);
                }
                if (node.val % 2 == 0) {
                    index=index+2;
                }
            }

        }


        return res;
    }

}
