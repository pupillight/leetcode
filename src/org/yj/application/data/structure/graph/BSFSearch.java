package org.yj.application.data.structure.graph;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class BSFSearch {

    private boolean[] marked;
    private int count;
    private Queue<Integer> queue;

    public BSFSearch(Graph graph, int source) {
        queue = new ArrayDeque<>();
        marked = new boolean[graph.getCount()];
        search(graph, source);
    }

    public void search(Graph g, int s) {
        marked[s] = true;
        queue.add(s);
        while (!queue.isEmpty()) {
            int w = queue.poll();
            List<Integer> list = g.adj(w);
            for (Integer t : list) {
                if (!marked[t]) {
                    search(g, t);
                }
            }
        }

        count++;
    }

    public boolean isConnected(int w) {
        return this.marked[w];
    }

    public int connectedNodesCount() {
        return this.count;
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
        g.addEdge(7, 8);

        BSFSearch search = new BSFSearch(g, 7);
        System.out.println(search.count);

        System.out.println(search.isConnected(5));
        //g.adj(0).stream().forEach(System.out::println);
    }
}
