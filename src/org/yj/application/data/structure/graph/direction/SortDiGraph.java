package org.yj.application.data.structure.graph.direction;

import java.util.LinkedList;

public class SortDiGraph {

    public boolean[] visited;
    public LinkedList<Integer> stack;

    public SortDiGraph(DiGraph graph) {
        visited = new boolean[graph.count];
        stack = new LinkedList<>();
        for (int i = 0; i < graph.count; i++) {
            if (!visited[i]) {
                dfs(graph, i);
            }
        }
    }

    private void dfs(DiGraph graph, int v) {
        visited[v] = true;
        for (Integer w : graph.adj[v]) {
            System.out.println("w=" + w);
            //if (!visited[w]) {
            dfs(graph, w);
            //}
        }
        //位置
        stack.push(v);
    }


    public static void main(String[] args) {
        DiGraph graph = new DiGraph(3);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 0);
        CycledDiGraph cycledDiGraph = new CycledDiGraph(graph);
        System.out.println(cycledDiGraph.isCycled);
        if (!cycledDiGraph.isCycled) {
            SortDiGraph sorter = new SortDiGraph(graph);
            System.out.println(sorter.stack);
        }
    }
}
