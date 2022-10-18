package org.yj.application.data.structure.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShortestPath {

    int s;
    boolean[] visited;
    int[] path;
    int[] dist;
    ArrayDeque<Integer> queue;

    public ShortestPath(Graph graph, int s) {
        int count = graph.getCount();
        visited = new boolean[count];
        path = new int[count];
        dist = new int[count];
        Arrays.fill(dist,Integer.MAX_VALUE);
        queue = new ArrayDeque<>();
        this.s = s;
        dist[s]=0;
        bfs(graph, s);
    }

    private void bfs(Graph graph, int v) {
        visited[v] = true;
        queue.add(v);
        while (!queue.isEmpty()) {
            int a = queue.poll();
            for (Integer b : graph.adj(a)) {
                if (!visited[b]) {
                    queue.add(b);
                    path[b] = a;
                    dist[b] = dist[a] + 1;
                    visited[b] = true;
                }
            }
        }
    }

    public boolean isConnected(int v) {
        return visited[v];
    }

    public List<Integer> path(int v) {
        if (!isConnected(v)) {
            return null;
        }
        List<Integer> res = new ArrayList<>();
        while (v != s) {
            res.add(v);
            v = this.path[v];
        }
        res.add(s);
        return res;
    }

    public int length(int v) {
        return dist[v];
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(1, 3);
        g.addEdge(0, 2);
        g.addEdge(2, 3);
        g.addEdge(0, 3);

        ShortestPath instance = new ShortestPath(g, 0);
        System.out.println(instance.path(3));
        System.out.println(instance.length(3));

    }

}
