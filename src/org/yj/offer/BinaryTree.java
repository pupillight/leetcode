package org.yj.offer;

import org.yj.application.data.structure.tree.TreeNode;
import org.yj.application.data.structure.tree.binary.BinarySearchTree;

import javax.swing.tree.TreeCellRenderer;
import java.util.*;

public class BinaryTree {

    /**
     * create a tree according to the bsf array
     *
     * @param array
     * @return
     */
    public TreeNode createTree(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        return createTree(array, 0);
    }

    private TreeNode createTree(int[] array, int i) {
        if (i >= array.length) {
            return null;
        }
        TreeNode root = new TreeNode(array[i]);
        root.left = createTree(array, 2 * i + 1);
        root.right = createTree(array, 2 * i + 2);
        return root;
    }

    /**
     * @param preOrder
     * @param inOrder
     * @return
     */
    public TreeNode createTree(int[] preOrder, int[] inOrder) {
        if (preOrder.length == 0 || inOrder.length == 0) {
            return null;
        }

        int rootValue = preOrder[0];
        TreeNode root = new TreeNode(rootValue);
        //find the index in orOder
        int index = findIndex(inOrder, rootValue);

        int[] leftPreOrder = Arrays.copyOfRange(preOrder, 1, index + 1);
        int[] leftInOrder = Arrays.copyOfRange(inOrder, 0, index);
        root.left = createTree(leftPreOrder, leftInOrder);

        int[] rightPreOrder = Arrays.copyOfRange(preOrder, index + 1, preOrder.length);
        int[] rightInOrder = Arrays.copyOfRange(inOrder, index + 1, inOrder.length);
        root.right = createTree(rightPreOrder, rightInOrder);

        return root;
    }

    public int findIndex(int[] inOrder, int value) {
        for (int i = 0; i < inOrder.length; i++) {
            if (value == inOrder[i]) {
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

    public void preOrderByLoop(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                System.out.println(node.value);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                //System.out.println(node.value);
                node = node.right;
            }
        }
    }


    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.value);
        inOrder(root.right);
    }

    public void inOrderByLoop(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                System.out.println(node.value);
                node = node.right;
            }
        }
    }

    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.value);
    }


    //???
    public void postOrderByLoop(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode pre = null;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                if (node.right == null || node.right == pre) {
                    System.out.println(node.value);
                    pre = node;
                    node = null;
                } else {
                    stack.push(node);
                    node = node.right;
                }
            }
        }
    }


    public TreeNode mirrorTree1(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        mirrorTree1(root.left);
        mirrorTree(root.right);
        return root;
    }

    public TreeNode mirrorTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = mirrorTree2(root.left);
        root.right = mirrorTree2(root.right);
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        return root;
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


    private int findRightNodeStartIndex(int[] array, int value) {
        int index = -1;
        int i = 0;
        while (array[i] < value) {
            i++;
        }
        return i;
    }


    public boolean isPostOrder1(int[] array) {
        if (array.length <= 1) {
            return true;
        }
        int rootValue = array[array.length - 1];
        int index = findRightNodeStartIndex(array, rootValue);
        // if (index == array.length - 1) {
        //     return false;
        //}
        int[] leftPostOrder = Arrays.copyOfRange(array, 0, index);
        int[] rightPostOrder = Arrays.copyOfRange(array, index, array.length - 1);

        for (int element : leftPostOrder) {
            if (element > rootValue) {
                return false;
            }
        }


        for (int element : rightPostOrder) {
            if (element < rootValue) {
                return false;
            }
        }
        return isPostOrder1(leftPostOrder) && isPostOrder1(rightPostOrder);


    }

    private boolean isPostOrder(List<Integer> list) {
        if (list.size() <= 1) {
            return true;
        }

        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();

        int postion = -1;
        int rootValue = list.get(list.size() - 1);

        for (int i = 0; i < list.size() - 1; i++) {
            int value = list.get(i);
            if (value == rootValue) {
                return false;
            } else if (value < rootValue) {
                if (postion == -1) {
                    leftList.add(value);
                } else {
                    return false;
                }
            } else {
                if (postion == -1) {
                    postion = i;
                }
                rightList.add(value);
            }
        }
        return isPostOrder(leftList) && isPostOrder(rightList);
    }

    public boolean isPostOrder(int[] array) {
     /*   if (array == null || array.length == 0) {
            return ;
        }*/

        List<Integer> list = new ArrayList<>();

        for (int num : array) {
            list.add(num);
        }
        return isPostOrder(list);


    }

    public TreeNode invertBst(TreeNode root) {
        if (root == null) {
            return null;
        }
        invertBst(root.left);
        invertBst(root.right);
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        return root;
    }

    public TreeNode invertBst2(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertBst(root.left);
        invertBst(root.right);

        return root;
    }

    public TreeNode invertBst1(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode node1 = invertBst(root.left);
        TreeNode node2 = invertBst(root.right);

        root.left = node2;
        root.right = node1;

        return root;
    }


    public int calculateTreeDeep(TreeNode root) {
        int max = 0;

        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                System.out.print(node.value);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            max++;
            System.out.println();
        }


        return max;
    }


    public int getTreeDeep(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.right == null && root.left == null) {
            return 1;
        }
        int leftDeep = getTreeDeep(root.left) + 1;
        int rightDeep = getTreeDeep(root.right) + 1;

        return Math.max(leftDeep, rightDeep);
    }

   /* private void getTreeDeep(TreeNode root, int i) {

        if (root == null) {
            //max = Math.max(i, max);
            return;
        }
        deep++;
        if (root.left == null && root.right == null) {
            if (deep > max) {
                max = deep;
            }
        }

        getTreeDeep(root.left, deep);
        getTreeDeep(root.right, deep);

    }*/

    /*private boolean isPostOrder(int[] array, int i, int j) {
        if(i>=j)
        {
            return true;
        }

        int rootValue = array[j];
        int p = i;
        while (array[p] < rootValue) {
            p++;
        }
        int m = p;
        while (array[p] > rootValue) {
            p++;
        }


        return p == j && isPostOrder(array, i, m - 1) && isPostOrder(array, m, j - 1);

    }*/

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }

        if (left.value != right.value) {
            return false;
        }

        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);

    }

    public TreeNode createBst(Integer[] array) {
        return createBst(array, 0);
    }

    public TreeNode createBst(Integer[] array, int index) {

        if (array == null || array.length == 0) {
            return null;
        }

        if (index > array.length - 1 || array[index] == null) {
            return null;
        }
        TreeNode root = new TreeNode(array[index]);
        root.left = createBst(array, 2 * index + 1);
        root.right = createBst(array, 2 * index + 2);
        return root;
    }


    LinkedList<Integer> paths = new LinkedList<>();
    List<List<Integer>> res = new ArrayList<>();

    public void pathSum(TreeNode node, int target) {
        dfs(node, target);
    }

    public void dfs(TreeNode node, int target) {
        if (node == null) {
            return;
        }
        paths.add(node.value);
        target = target - node.value;
        if (node.left == null && node.right == null) {
            if (target == 0) {
                //paths.add(node.value);
                res.add(new LinkedList<Integer>(paths));
            }
            //return;
        }
        pathSum(node.left, target);
        pathSum(node.right, target);
        paths.removeLast();
    }


    public int treeHeight(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int leftHeight = treeHeight(root.left) + 1;
        int rightHeight = treeHeight(root.right) + 1;
        return Math.max(leftHeight, rightHeight);
    }

    public int treeHeight2(TreeNode root) {

        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int leftHeight = treeHeight2(root.left) + 1;
        int rightHeight = treeHeight2(root.right) + 1;
        return Math.max(leftHeight, rightHeight);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(root, res, "");
        return res;
    }

    private void dfs(TreeNode node, List<String> list, String path) {
        if (node == null) {
            return;
        }
        path = path + node.value;
        if (node.left == null && node.right == null) {
            list.add(path);
        }

        dfs(node.left, list, path + "->");
        dfs(node.right, list, path + "->");

    }

    private void dfs1(TreeNode node, List<String> list, String path) {
        if (node == null) {
            return;
        }
        path = path + node.value;
        if (node.left == null && node.right == null) {
            list.add(path);
        }

        dfs(node.left, list, path + "->");
        dfs(node.right, list, path + "->");

    }

    public static void main(String[] args) {
        BinaryTree bTree = new BinaryTree();
        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(4);
//        root.left.left = new TreeNode(11);
//        root.left.left.left = new TreeNode(7);
//        root.left.left.right = new TreeNode(2);
        //root.left.right = new TreeNode(4);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
//        root.right.right = new TreeNode(4);
//        root.right.right.left = new TreeNode(5);
//        root.right.right.right = new TreeNode(1);
//        bTree.pathSum(root, 22);
//
//        System.out.println(bTree.res);

        System.out.println(bTree.binaryTreePaths(root));

        // System.out.println(bTree.treeHeight(root));
        //  System.out.println(bTree.treeHeight2(root));

        // bTree.invertBst(root);

        //bTree.preOrder(root);

        //System.out.println(bTree.getTreeDeep(root));
        // System.out.println(bTree.calculateTreeDeep(root));
        //System.out.println(bTree.isSymmetric(root));

        //System.out.println(root);


/*
        int[] array = {2};
        TreeNode root = bTree.createTree(array);
*/
//        int[] preOrder = {4, 2, 6};
        //       int[] inOrder = {2, 4, 6};
//        int[] preOrder = {4, 2, 1, 3, 6, 5, 7};
//        int[] inOrder = {1, 2, 3, 4, 5, 6, 7};
//        TreeNode root = bTree.createTree(preOrder, inOrder);
        //System.out.println();
        //bTree.preOrder(root);
        //System.out.println();
        //bTree.preOrderByLoop(root);
//        System.out.println();
//        bTree.inOrderByLoop(root);
//        System.out.println();
//        bTree.inOrder(root);

/*        System.out.println();
        bTree.postOrder(root);
        System.out.println();
        bTree.postOrderByLoop(root);*/
       /* TreeNode node1 = bTree.mirrorTree(root);
        bTree.preOrder(node1);
        System.out.println();

        TreeNode node2 = bTree.mirrorTree1(root);
        bTree.preOrder(node2);
        System.out.println();*/
//        TreeNode node1 = bTree.mirrorTree(root);
//        bTree.preOrder(node1);
//        System.out.println();

//        TreeNode node2 = bTree.mirrorTree1(root);
//        bTree.preOrder(node2);
//        System.out.println();

//        TreeNode node3 = bTree.mirrorTree2(root);
//        bTree.preOrder(node3);
//        System.out.println();

        //Integer[] array = {3, 5,7};
        //int[] array = {1, 6, 3, 2, 5};
        //int[] array = {3, 5};
        //int[] array = {1, 3, 2, 6, 5};
        //Integer[] array = {1, 3, 2, 6, 5};
        //int[] array = {2, 4, 3, 6, 8, 7, 5};
        //System.out.println(bTree.isPostOrder1(array));
        //System.out.println(bTree.isPostOrder(array));

        //Integer[] array = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1};
        //TreeNode root1 = bTree.createBst(array);
        //System.out.println(root1);


    }
}
