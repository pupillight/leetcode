package org.yj.application.data.structure.graph.weighted;

import org.yj.application.data.structure.graph.Edge;

import java.util.ArrayList;
import java.util.List;

public class WeightedGraph {

    private int count;
    private int edgeCount;
    private List<Edge>[] adj;

    public WeightedGraph(int count) {
        this.count = count;
        this.edgeCount = 0;
        adj = new List[count];
        for (int i = 0; i < count; i++) {
            adj[i] = new ArrayList<Edge>();
        }
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Edge> adj(int vertex) {
        return adj[vertex];
    }

    public void add(Edge edge) {
        int p = edge.vertex();
        int q = edge.otherVertex(p);
        adj[p].add(edge);
        adj[q].add(edge);
        edgeCount++;
    }
/*    public void add(int p, int q, int weigh) {
        Edge edge = new Edge(p, q, weigh);
        adj[p].add(edge);
        adj[q].add(edge);
        edgeCount++;
    }*/

    public List<Edge> edges() {
        List<Edge> res = new ArrayList<>();
        for (int i = 0; i < this.count; i++) {
            for (Edge edge : adj[i]) {
                int j = edge.otherVertex(i);
                if (j < i) {
                    res.add(edge);
                }
            }
        }
        return res;
    }
}
