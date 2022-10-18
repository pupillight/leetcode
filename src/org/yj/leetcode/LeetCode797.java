package org.yj.leetcode;


import java.util.*;

public class LeetCode797 {
    List<List<Integer>> path = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int length = graph.length;
        boolean[] visisted = new boolean[length];
        int s = 0;
        LinkedList list = new LinkedList();
        dfs(graph, s, list);
        return this.path;

    }

    private void dfs(int[][] graph, int s, LinkedList list) {
        int[] adj = graph[s];
        list.add(s);
        if (s == graph.length - 1) {
            path.add(new ArrayList<>(list));
        }
        for (int v : adj) {
            dfs(graph, v, list);
        }
        list.removeLast();
    }

    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {3}, {3}, {}};

        LeetCode797 instance = new LeetCode797();
        System.out.println(instance.allPathsSourceTarget(graph));
    }
}

