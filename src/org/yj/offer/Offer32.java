package org.yj.offer;

import org.yj.application.data.structure.tree.TreeNode;

import java.util.*;

public class Offer32 {


    public TreeNode creatTree(Integer[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        return creatTree(array, 0);
    }

    private TreeNode creatTree(Integer[] array, int index) {

        if (index >= array.length) {
            return null;
        }
        if(array[index]==null)
        {
            return null;
        }


        TreeNode root = new TreeNode(array[index]);
        root.left = creatTree(array, 2 * index + 1);
        root.right = creatTree(array, 2 * index + 2);

        return root;
    }


    public boolean isSymmetricByLoop(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> quque = new LinkedList<>();
        quque.offer(root.left);
        quque.offer(root.right);

        while (!quque.isEmpty()) {
            TreeNode nodeA = quque.poll();
            TreeNode nodeB = quque.poll();

            if (nodeA == null && nodeB == null) {
                //return true;
                continue;
            } else if (nodeA == null || nodeB == null) {
                return false;
            } else {
                if (nodeA.value != nodeB.value) {
                    return false;
                }
                quque.offer(nodeA.left);
                quque.offer(nodeB.right);
                quque.offer(nodeA.right);
                quque.offer(nodeB.left);
            }
        }
        return true;
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode node1, TreeNode node2) {

        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 == null || node2 == null) {
            return false;
        } else {
            if (node1.value != node2.value) {
                return false;
            }
            return isSymmetric(node1.left, node2.right) && isSymmetric(node1.right, node2.left);
        }
    }


    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.println(node.value);

            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
    }

    public void dfs1(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.println(node.value);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    public List<List<Integer>> printByRow(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<List<Integer>> results = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);

        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> list = new ArrayList<>();
            TreeNode node = deque.pollFirst();
            list.add(node.value);
            if (node.left != null) {
                deque.offer(node.left);
            }
            if (node.right != null) {
                deque.offer(node.right);
            }

            results.add(list);
        }
        return results;
    }

    public List<List<Integer>> printByRow1(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<List<Integer>> results = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        int count = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pollFirst();
                list.add(node.value);
                if (count % 2 != 0) {
                    if (node.left != null) {
                        deque.offer(node.left);
                    }
                    if (node.right != null) {
                        deque.offer(node.right);
                    }
                } else {
                    if (node.right != null) {
                        deque.offer(node.right);
                    }
                    if (node.left != null) {
                        deque.offer(node.left);
                    }

                }

            }
            count++;
            results.add(list);
        }

        return results;
    }

    public List<List<Integer>> printTreeByLIne(TreeNode root) {
        if (root == null) {
            return null;
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        List<List<Integer>> res = new ArrayList<>();
        while (!list.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int size = list.size();
            int m = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = list.poll();
                tmp.add(node.value);
                System.out.print(node.value);
                if (node.left != null) {
                    list.add(node.left);
                }
                if (node.right != null) {
                    list.add(node.right);
                }
                m++;
                if (m == size) {
                    System.out.println();
                } else {
                    System.out.print(",");
                }
            }
            res.add(tmp);
        }

        return res;
    }


    public static void main(String[] args) {
        Offer32 offer = new Offer32();


/*        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        //root.left.left = new TreeNode(19);
        //root.left.right = new TreeNode(11);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> list = offer.printByRow(root);
        System.out.println(Arrays.toString(list.toArray()));*/
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(19);
        //root.left.right = new TreeNode(15);
        root.right = new TreeNode(9);
        //root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(19);

        //System.out.println(offer.isSymmetricByLoop(root));
        //System.out.println(offer.isSymmetric(root));


        //List<List<Integer>> list = offer.printByRow(root);
        //System.out.println(Arrays.toString(list.toArray()));

        //Integer[] array = {3, 8, 9, 10, 11};
        Integer[] array = {3, 8, 9,null,10,null,null};
        TreeNode node = offer.creatTree(array);
        System.out.println(node);

    }


    List<List<Integer>> res = new LinkedList<>();

    List<List<Integer>> permute(int[] nums) {
        // 记录「路径」
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    void backtrack(int[] nums, LinkedList<Integer> track) {

        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //filter
            if (track.contains(nums[i])) {
                continue;
            }
            //add choice
            track.add(nums[i]);
            //next path
            backtrack(nums, track);
            //leave current path and remove current path
            track.removeLast();
        }
    }
}
