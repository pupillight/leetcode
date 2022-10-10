package org.yj.application.data.structure.graph.weighdirect;

import java.util.ArrayList;
import java.util.List;

public class DirectedWeightedGraph {

    public int count;
    public List<DirectedEdge>[] adj;

    public DirectedWeightedGraph(int count) {
        this.count = count;
        adj = new List[count];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public void addEdge(DirectedEdge edge) {
        adj[edge.from].add(edge);
    }

    public List<DirectedEdge> edges() {
        List<DirectedEdge> res = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            for (DirectedEdge edge : adj[i]) {
                res.add(edge);
            }
        }
        return res;
    }
}
