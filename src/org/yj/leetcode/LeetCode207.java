package org.yj.leetcode;

import java.sql.Struct;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode207 {
    List<Integer>[] adj;
    boolean[] visited;
    //LinkedList<Integer> path;
    boolean[] path;
    boolean isCycled = false;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        visited = new boolean[n];
        //path = new LinkedList<>();
        path = new boolean[n];

        adj = new List[n];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            adj[b].add(a);

        }
        //check graph isCycled?
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }
        System.out.println("isCycled=" + isCycled);
        return isCycled == true ? false : true;
    }

    private void dfs(int v) {
        visited[v] = true;
        path[v] = true;
        for (Integer w : adj[v]) {
            if (path[w] == true) {
                isCycled = true;
                return;
            }
            if (!visited[w]) {
                dfs(w);
            }
        }

        path[v] = false;
    }

    public static void main(String[] args) {
        LeetCode207 instance = new LeetCode207();
        int[][] prerequisites = {{0, 1}};
        //int[][] prerequisites = {{1, 0}, {2, 1}, {0, 2}};
        System.out.println(instance.canFinish(2, prerequisites));

    }
}
