package org.yj.application.data.structure.graph.weighdirect;

import java.util.*;

public class Dijkstra {

    int dist[];
    int[] path;
    PriorityQueue<DirectedEdge> queue;
    int s;

    public Dijkstra(DirectedWeightedGraph graph, int s) {
        this.s = s;
        this.dist = new int[graph.count];
        this.path = new int[graph.count];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(path, 0);
        queue = new PriorityQueue<DirectedEdge>((e1, e2) -> e1.weigh - e2.weigh);
        dist[s] = 0;
        DirectedEdge edge = new DirectedEdge(s, s, 0);
        queue.add(edge);
    }

    private void cal(DirectedWeightedGraph graph) {
        while (!queue.isEmpty()) {
            DirectedEdge currentEdge = queue.poll();
            int v = currentEdge.to;
            //int v = queue.poll();
            for (DirectedEdge edge : graph.adj[v]) {
                int w = edge.to;
                int sum = dist[v] + edge.weigh;
                if (sum < dist[w]) {
                    dist[w] = sum;
                    path[w] = v;
                    queue.add(new DirectedEdge(v, w, sum));
                }
            }
        }
    }

    public List<Integer> edges(int v) {
        List<Integer> res = new ArrayList<>();
        while (true) {
            res.add(v);
            if (s == v) {
                break;
            }
            v = path[v];
        }
        Collections.sort(res, (e1, e2) -> -(e1 - e2));
        return res;
    }

    public static void main(String[] args) {

        DirectedWeightedGraph graph = new DirectedWeightedGraph(4);
        DirectedEdge edge = new DirectedEdge(0,1,2);
        graph.addEdge(edge);
        edge = new DirectedEdge(0,2,1);
        graph.addEdge(edge);
        edge = new DirectedEdge(1,2,3);
        graph.addEdge(edge);
        edge = new DirectedEdge(1,3,10);
        graph.addEdge(edge);
        edge = new DirectedEdge(2,3,2);
        graph.addEdge(edge);

        Dijkstra dijkstra = new Dijkstra(graph,0);
        dijkstra.cal(graph);

        System.out.println(dijkstra.edges(3));

    }
}
