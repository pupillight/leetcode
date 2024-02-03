package org.yj.leetcode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode1976 {

    List<Node>[] adj;
    boolean[] visited;
    //List<Integer> costs;
    Map<Integer, Integer> map;

    public int countPaths(int n, int[][] roads) {
        adj = new List[n];
        visited = new boolean[n];
        //costs = new ArrayList<>();
        map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < roads.length; i++) {

            int[] road = roads[i];
            int start = road[0];
            int end = road[1];
            int weight = road[2];
            adj[start].add(new Node(start, end, weight));
            adj[end].add(new Node(end, start, weight));
        }

        visited[0] = true;
        dfs(0, n - 1, 0);
        //System.out.println(costs);
        System.out.println(map);

        int res = map.entrySet().stream().sorted((e1, e2) -> e1.getKey() - e2.getKey()).findFirst().get().getValue() % (109 + 7);
        return res;

    }

    private void dfs(int s, int n, int cost) {

        if (s == n) {
            //costs.add(cost);
            map.put(cost, map.getOrDefault(cost, 0) + 1);
            return;
        }
        for (Node node : adj[s]) {

            int v = node.end;
            if (!visited[v]) {
                visited[v] = true;
                dfs(v, n, cost + node.weight);
                visited[v] = false;
            }
        }

    }

    public static void main(String[] args) {
        LeetCode1976 instance = new LeetCode1976();
        /*int n = 2;
        int[][] roads = {{1, 0, 10}};*/
        int n = 7;
        int[][] roads = {{0, 6, 7}, {0, 1, 2}, {1, 2, 3}, {1, 3, 3}, {6, 3, 3}, {3, 5, 1}, {6, 5, 1}, {2, 5, 1}, {0, 4, 5}, {4, 6, 2}};


        System.out.println(instance.countPaths(n, roads));
    }
}

class Node {
    int start;
    int end;
    int weight;

    public Node(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}
