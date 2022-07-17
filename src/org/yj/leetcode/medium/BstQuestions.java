package org.yj.leetcode.medium;

import org.yj.application.data.structure.tree.TreeNode;

import java.util.*;

public class BstQuestions {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        Node node = root;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                node = queue.poll();
                Node next = queue.peek();
                if (i != size - 1) {
                    node.next = next;
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return root;
    }

    public List<List<Integer>> zigzagLevelOrder(Node root) {
        if (root == null) {
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
        int j = 1;
        Deque<Node> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                Node node = null;
                node = deque.poll();
                if (j % 2 != 0) {
                    list.add(node.val);
                } else {
                    list.addFirst(node.val);
                }
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
            j++;
            res.add(list);
        }
        return res;
    }


    private void addNode(TreeNode node, int value) {
        node.left = new TreeNode(value);

    }

  /*  public TreeNode createTree(String nodeStr) {
        if (nodeStr == null || nodeStr.length() == 0) {
            return null;
        }

       // TreeNode node = null;
        Deque<Character> deque = new LinkedList<>();
        for (char c : nodeStr.toCharArray()) {
        *//*    if (Character.isDigit(c)) {
                node =new TreeNode(Integer.parseInt(String.valueOf(c)));
            } else if (c == '(') {
                node = node.left;
            } else if (c == ')') {

            }*//*
            if (c != ')') {
                if (Character.isDigit(c)) {
//                    if (root == null) {
//                        root = new TreeNode(c);
//                    } else {
//                        root.left = new TreeNode(Integer.parseInt(String.valueOf(c)));
//                        root = root.left;
//                        addNode();
//                    }

                }
                deque.add(c);
            } else {
                char topCharacter = ' ';
                while (!deque.isEmpty() && deque.poll() != '(') {
                    topCharacter = deque.pop();
                }
                deque.pop();
                TreeNode node = new TreeNode(Integer.parseInt(String.valueOf(topCharacter)));


            }

        }
    }*/


    public int hammingDistance(int x, int y) {
        int ans = 0;
        int v = x ^ y;
        for (int i = 0; i < 32/**/; i++) {
            int bit = v >> i & 1;
            if (bit == 1) {
                ans++;
            }
        }
        return ans;
    }

    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder ans = new StringBuilder();
        int sign = 1;
        if (num < 0) {
            sign = -1;
            num = Math.abs(num);
        }
        while (num > 0) {
            ans.append(num % 7);
            num = num / 7;
        }
        if (sign == -1) {
            ans.append("-");
        }
        return ans.reverse().toString();
    }


    public static void main(String[] args) {
        BstQuestions questions = new BstQuestions();
   /*     Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        // questions.connect(root);

        questions.zigzagLevelOrder(root);*/

        //ystem.out.println(questions.hammingDistance(3, 1));
        System.out.println(questions.convertToBase7(-1));
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}