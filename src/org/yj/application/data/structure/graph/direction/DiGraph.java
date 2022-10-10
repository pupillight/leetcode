package org.yj.application.data.structure.graph.direction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiGraph {

    public int count;
    public int edgeCount;
    public List<Integer>[] adj;
    /*private int[] marked;
    private int[] fromPath;*/

    public DiGraph(int count) {
        this.count = count;
        adj = new List[count];
        for (int i = 0; i < count; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public void addEdge(int a, int b) {
        adj[a].add(b);
        edgeCount++;
    }

    public int getCount() {
        return this.count;
    }

    public int getEdgeCount() {
        return this.edgeCount;
    }

    private List<Integer> adj(int v) {
        return this.adj[v];
    }


    private DiGraph reverse() {
        DiGraph res = new DiGraph(count);
        for (int i = 0; i < count; i++) {
            for (int j : adj[i]) {
                res.addEdge(j, i);
            }

        }
        return res;
    }
}
