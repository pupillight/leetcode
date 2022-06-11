package org.yj.application.data.structure.tree.binary;

import java.util.LinkedList;

public class Codec {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root ==null)
        {
            return null;
        }
        StringBuilder builder = new StringBuilder();
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = list.poll();
               // System.out.print(node.val);
                if(node ==null)
                {
                    builder.append("null");
                }else {
                    builder.append(node.val);
                }

                builder.append(",");
                if (node!=null && node.left != null) {
                    list.add(node.left);
                }else{
                    list.add(null);
                }
                if (node !=null && node.right != null) {
                    list.add(node.right);
                }else{
                    list.add(null);
                }

            }
            System.out.println();
        }

        System.out.println(builder.toString());
        return null;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        return null;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();

        TreeNode root= new TreeNode(1);

        root.left= new TreeNode(2);
        root.right= new TreeNode(3);
        root.right.left= new TreeNode(4);
        root.right.right= new TreeNode(5);
        codec.serialize(root);
    }

}
