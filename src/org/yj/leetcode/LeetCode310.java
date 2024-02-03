package org.yj.leetcode;


import java.util.*;
import java.util.stream.Collectors;

public class LeetCode310 {
   /* List<Integer>[] adj = null;
    boolean[] visited;

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        visited = new boolean[n];
        adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            adj[edges[i][0]].add(edges[i][1]);
            adj[edges[i][1]].add(edges[i][0]);
        }

        int min = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int height = dfs(i);
            if (height < min) {
                min = height;
                list.clear();
                list.add(i);
            } else if (height == min) {
                list.add(i);
            }
        }

        return list;
    }


    private int dfs(int s) {
        int h = 0;
        int max = h;
        visited[s] = true;
        for (Integer v : adj[s]) {
            if (!visited[v]) {
                h = dfs(v)+1;
                if (h > max) {
                    max = h;
                }
            }
        }
        visited[s] = false;

        return max;
    }*/

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        if(n==1){
            return List.of(0);
        }
        int[] degree = new int[n];
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.add(i);
            }
        }
        List<Integer> res =new ArrayList<>();
        while (!queue.isEmpty()) {
            res.clear();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int v = queue.poll();
                res.add(v);
                for (Integer u : adj[v]) {
                    degree[u]--;
                    if (degree[u] == 1) {
                        queue.add(u);
                    }
                }
            }
        }

        //List<Integer> res =queue.stream().collect(Collectors.toList());
        return res;
    }

    public static void main(String[] args) {
        LeetCode310 instance = new LeetCode310();

        //int n = 4;
        //int[][] edges = {{1, 0}, {1, 2}, {1, 3}};
       int  n = 6;
       int[][] edges = {{3,0},{3,1},{3,2},{3,4},{5,4}};
        System.out.println(instance.findMinHeightTrees(n, edges));

    }

}
