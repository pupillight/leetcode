package org.yj.application.data.structure.graph.direction;

public class CycledDiGraph {

    boolean[] visited;
    boolean[] onStack;
    boolean isCycled;

    public CycledDiGraph(DiGraph graph) {
        int count = graph.getCount();
        visited = new boolean[count];
        onStack = new boolean[count];
        for (int i = 0; i < count; i++) {
            if (!visited[i]) {
                dfs(graph, i);
            }
        }
    }

    private void dfs(DiGraph graph, int v) {
        visited[v] = true;
        onStack[v] = true;
        for (Integer w : graph.adj[v]) {
            if (!visited[w]) {
                dfs(graph, w);
            }
            if (onStack[w]) {
                this.isCycled = true;
                return;
            }
        }
        //？？？
        onStack[v]=false;
    }


    public boolean isCycled() {
        return this.isCycled;
    }

    public static void main(String[] args) {
        DiGraph graph = new DiGraph(3);

        graph.addEdge(0,1);
        graph.addEdge(1,2);
        //graph.addEdge(2,0);

        CycledDiGraph cycledDiGraph = new CycledDiGraph(graph);
        System.out.println(cycledDiGraph.isCycled);
    }
}
