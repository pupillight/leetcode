package org.yj.offer;
import org.yj.application.data.structure.tree.TreeNode;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Offer34 {


    //ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    //ArrayList<Integer> list = new ArrayList<>();
    List<List<Integer>> res = new LinkedList<>();
    Deque<Integer> list = new LinkedList<>();


    public List<List<Integer>> getNodes(Integer[] array, int target) {
        TreeNode root = createTree(array);
        System.out.println();
        calculate(root, target);
        return res;
    }

    private void calculate(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        int v = root.value;
        list.add(v);
        target = target - v;
        if (root.left == null && root.right == null && target == 0) {
            res.add(new LinkedList<Integer>(list));
        }
        calculate(root.left, target);
        calculate(root.right, target);
        list.pollLast();
    }

    private TreeNode createTree(Integer[] array) {
        return createTree(array, 0);
    }

    private TreeNode createTree(Integer[] array, int index) {
        if (index >= array.length || array[index] == null) {
            return null;
        }
        TreeNode root = new TreeNode(array[index]);
        root.left = createTree(array, 2 * index + 1);
        root.right = createTree(array, 2 * index + 2);
        return root;
    }

    public static void main(String[] args) {
        Offer34 offer = new Offer34();
        Integer[] array = {5, 4, 8};
        offer.getNodes(array, 9);
    }
}
