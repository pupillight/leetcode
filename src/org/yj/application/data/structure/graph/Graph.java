package org.yj.application.data.structure.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Graph {

    //the count of node
    private int count;
    //the count of edge
    private int edgeCount;
    private List<Integer>[] adj;

    public Graph(int count) {
        this.count = count;
        this.edgeCount = 0;
        adj = new List[count];
        for (int i = 0; i < count; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public int getCount() {
        return count;
    }

    public int getEdgeCount() {
        return edgeCount;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        edgeCount++;
    }

    public List<Integer> adj(int v) {
        return adj[v];
    }



    public static void main(String[] args) {
        Graph g = new Graph(9);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 6);
        g.addEdge(0, 5);
        g.addEdge(5, 3);
        g.addEdge(5, 4);
        g.addEdge(3, 4);
        g.addEdge(4, 6);

        g.adj(0).stream().forEach(System.out::println);
    }
}
