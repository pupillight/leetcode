package org.yj.application.data.structure.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class DepthFirstPath {
    private boolean[] marked;
    private int[] fromPath;
    private int s;

    public DepthFirstPath(Graph graph, int s) {
        this.s = s;
        this.marked = new boolean[graph.getCount()];
        this.fromPath = new int[graph.getCount()];
        dfs(graph, s);
    }

    /*    public void dfs(Graph graph, int s) {
            marked[s] = true;
            List<Integer> list = graph.adj(s);
            for (int a : list) {
                if (!marked[a]) {
                    dfs(graph, a);
                    fromPath[a] = s;
                }
            }
        }*/
    private void dfs(Graph graph, int s) {
        marked[s] = true;
        List<Integer> list = graph.adj(s);
        for (int a : list) {
            if (!marked[a]) {
                //fromPath[a] = s;
                dfs(graph, a);
                fromPath[a] = s;
            }
        }
    }

    private boolean hasPathTo(int e) {
        return this.marked[e];
    }

    public String paths(int e) {

        if (!hasPathTo(e)) {
            return "no path to node:" + e;
        }
        LinkedList<Integer> stack = new LinkedList<>();
/*        stack.push(e);
        while (e != fromPath[e]) {
            e = fromPath[e];
            stack.push(e);
        }*/

        while (e != this.s) {
            stack.push(e);
            e = fromPath[e];
        }
        stack.push(s);
        String res = stack.stream().map(i -> String.valueOf(i)).collect(Collectors.joining("->"));
        return res.substring(0, res.length());
    }

    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        // g.addEdge(3, 5);
        //g.addEdge(3, 4);
        g.addEdge(0, 5);

        DepthFirstPath instance = new DepthFirstPath(g, 0);
        //instance.dfs(g, 0);
        System.out.println(instance.hasPathTo(4));
        System.out.println(instance.paths(4));

        //0->1->2->3

    }
}
