package org.yj.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class LeetCode501 {

    TreeNode pre;
    int max = 0;
    int count = 0;
    Map<Integer, Integer> map = new HashMap<>();

    public int[] findMode(TreeNode root) {
        dfs(root);
        int[] ans = map.entrySet().stream().map(entry -> entry.getKey()).mapToInt(element -> element.intValue()).toArray();
        return ans;
    }

    private void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);
        if (pre == null) {
            count = 1;
            max = 1;
            map.put(node.val, count);
        } else if (pre.val != node.val) {
            count = 1;
            if (count == max) {
                map.put(node.val, count);
            }
        } else if (pre.val == node.val) {
            count++;
            if (count == max) {
                map.put(node.val, count);
            }
            if (count > max) {
                max = count;
                map.clear();
                map.put(node.val, count);
            }
        }
        pre = node;
        dfs(node.right);
    }

    public static void main(String[] args) {
        LeetCode501 instance = new LeetCode501();
       /* int[][] edges= {{0,1},{0,2},{3,5},{5,4},{4,3}};
        System.out.println(instance.validPath(6, edges, 0, 5));*/
        /*int[][] edges = {{0, 1}, {1, 2}, {2, 0}};
        System.out.println(instance.validPath(3, edges, 0, 2));*/

    }
}
