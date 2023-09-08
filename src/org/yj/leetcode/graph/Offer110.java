package org.yj.leetcode.graph;

import java.util.ArrayList;
import java.util.List;

public class Offer110 {

    List<List<Integer>> ans;
    List<Integer> paths;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        ans = new ArrayList<>();
        paths = new ArrayList<>();
        int len = graph.length;
        paths.add(0);
        dfs(0, len - 1,graph);
        return ans;
    }

    private void dfs(int v, int target,int[][] graph) {
        if (v == target) {
            ans.add(new ArrayList<>(paths));
            return;
        }
        for (int i = 0; i < graph[v].length; i++) {
            int w =graph[v][i];
            paths.add(w);
            dfs(w, target,graph);
            paths.remove(paths.size() - 1);
        }
    }

    public static void main(String[] args) {
        Offer110 instance = new Offer110();
        int[][] graph = {{1, 2}, {3}, {3}, {}};
        System.out.println(instance.allPathsSourceTarget(graph));
    }
}
