package org.yj.application.data.structure.graph;

import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class DSFSearch {

    private boolean[] marked;
    private int count;
    private int ccount;
    private int[] id;


    public DSFSearch(Graph graph, int source) {
        marked = new boolean[graph.getCount()];
        id=new int[graph.getCount()];
        ccount=0;
        Arrays.fill(id,-1);
        //search(graph, source);
        cal(graph);
    }


    public void cal(Graph g)
    {
        int count =g.getCount();
        for(int i=0;i<count;i++){
            if(!marked[i]){
                search(g,i);
                ccount++;
            }
        }
    }

    public void search(Graph g, int s) {
        marked[s] = true;
        id[s]=ccount;
        List<Integer> list = g.adj(s);
        for(Integer w:list){
            if (!marked[w]) {
                search(g, w);
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

        DSFSearch search = new DSFSearch(g, 0);
        System.out.println(search.count);
        System.out.println(search.ccount);

        System.out.println(search.isConnected(1));
        //g.adj(0).stream().forEach(System.out::println);
    }
}
