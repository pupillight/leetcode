package org.yj.leetcode;


import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;

public class LeetCode404 {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = sumOfLeftLeaves(root.left);
        int r = sumOfLeftLeaves(root.right);
        if (root.left != null && (root.left.left == null && root.left.right == null)) {
            return l + r + root.left.val;
        }
        return l + r;

    }

    private void test(List<Integer> list)
    {
       //list=null;
        list.add(10);
    }

    public static void main(String[] args) {
        LeetCode404 instance = new LeetCode404();
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

       // System.out.println(instance.sumOfLeftLeaves(root));


        IntUnaryOperator intUnaryOperator1=item->item*item;
        IntUnaryOperator intUnaryOperator2=item->item+1;

        int ans = intUnaryOperator2.compose(intUnaryOperator1).applyAsInt(5);
        //System.out.println(ans);

        ans = intUnaryOperator2.andThen(intUnaryOperator1).applyAsInt(5);
       // System.out.println(ans);

        String str="123";
        Function<Integer,String> function = str::substring;
        //BiFunction<String,Integer,String> function =String::substring;
        //System.out.println(function.apply(2));

        List<Integer> list = new ArrayList<>();
        list.add(1);
        instance.test(list);
        System.out.println(list);
    }

}
