package org.yj.leetcode.graph;

import org.yj.leetcode.graph.shortestpath.Edge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class MSTreePrim1 {


    public void calculateMST(int[][] array) {

        //set 0 as the start vertex
        List<Integer> list = new ArrayList<>();
        list.add(0);
        int len = array.length;
        boolean[] visited = new boolean[len];

        int start = 0;
        for (int m = 0; m < len; m++) {
            list.add(start);
            visited[m] = true;
            int val = Integer.MAX_VALUE;
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < len; j++) {
                    if (!visited[j] && array[list.get(i)][j] > 0 && array[list.get(i)][j] < val) {
                        start = j;
                        val = array[list.get(i)][j];
                    }
                }
            }
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }

    public void solution(int[][] graphs, int n, int u) {

        boolean[] flag = new boolean[n + 1];
        int[] lowcost = new int[n + 1];
        int[] closest = new int[n + 1];
        flag[u] = true;
        Arrays.fill(lowcost, Integer.MAX_VALUE);
        Arrays.fill(closest, u);
        List<Edge>[] adj = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        lowcost[u]=0;
        for (int i = 0; i < graphs.length; i++) {
            int[] graph = graphs[i];
            Edge edge = new Edge(graph[0], graph[1], graph[2]);
            adj[graph[0]].add(edge);
            if (graph[0] == u) {
                lowcost[graph[1]] = graph[2];
            }
        }

        for (int i = 0; i < n - 1; i++) {
            int min = Integer.MAX_VALUE;
            int index = u;
            for (int j = 1; j < n; j++) {
                if (!flag[j] && lowcost[j] < min) {
                    min = lowcost[j];
                    index = j;
                }
            }
            if (index == u) {
                break;
            }
            flag[index] = true;

            for (Edge edge : adj[index]) {
                int v = edge.end;
                if (!flag[v] && lowcost[v] > edge.w) {
                    closest[v] = index;
                    lowcost[v] = edge.w;
                }
            }


            /*for (int j = 0; j < n; j++) {
                if (!flag[j] && graph[index][j] < lowcost[j]) {
                    closest[j] = index;
                    lowcost[j] = graph[index][j];
                }
            }*/
        }

        IntStream.range(0,closest.length).filter(i->i>0).map(i->closest[i]).forEach(System.out::println);
        System.out.println("---------");
        IntStream.range(0,lowcost.length).filter(i->i>0).map(i->lowcost[i]).forEach(System.out::println);
        System.out.println("---------");
        System.out.println(IntStream.range(0, lowcost.length).filter(i -> i > 0).map(i -> lowcost[i]).sum());

    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                //0  1  2  3  4  5  6  7  8
                {0, 4, 0, 0, 0, 0, 0, 7, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {7, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };

        int[][] graphs = {
                {1, 2, 1},
                {1, 3, 10},
                {2, 3, 3}

        };
        MSTreePrim1 msTree = new MSTreePrim1();
        msTree.solution(graphs, 3, 1);
    }
}
