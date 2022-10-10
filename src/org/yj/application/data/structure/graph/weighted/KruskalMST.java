package org.yj.application.data.structure.graph.weighted;

import org.yj.application.data.structure.graph.Edge;

import java.util.List;
import java.util.PriorityQueue;

public class KruskalMST {

    //the edges of min spanning tree
    private List<Edge> mst;
    private UnionFind uf;
    private PriorityQueue<Edge> priorityQueue;

    public KruskalMST(WeightedGraph graph) {
        uf = new UnionFind(graph.getCount());
        priorityQueue = new PriorityQueue<>((t1, t2) -> t1.compareTo(t2));
        List<Edge> list = graph.edges();
        list.stream().forEach((edge -> priorityQueue.add(edge)));

        while (!priorityQueue.isEmpty() && mst.size() < graph.getCount()) {
            Edge edge = priorityQueue.poll();
            if (edge != null) {
                int p = edge.vertex();
                int q = edge.otherVertex(p);
                if (!uf.isConnected(p, q)) {
                    uf.union(p, q);
                }
                mst.add(edge);
            }
        }
    }

    public List<Edge> edges() {
        return mst;
    }
}

class UnionFind {
    int[] parents;
    int capacity;

    public UnionFind(int capacity) {
        this.capacity = capacity;
        parents = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            parents[i] = i;
        }
    }

    private int find(int p) {
        while (p != parents[p]) {
            p = parents[p];
        }
        return p;
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (qRoot == qRoot) {
            return;
        }
        parents[pRoot] = qRoot;
    }
}
