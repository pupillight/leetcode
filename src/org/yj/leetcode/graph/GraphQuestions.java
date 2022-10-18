package org.yj.leetcode.graph;

import java.util.*;

public class GraphQuestions {

/*    class Edge {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }*/

    public void shortestPath1(int[][] g, int s, int d) {
        int count = g.length;
        List<Integer>[] adj = new List[count];
        int[] dist = new int[count];
        int[] path = new int[count];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(path, -1);

        for (int i = 0; i < count; i++) {
            for (int j = i + 1; j < count; j++) {
                if (g[i][j] != -1) {
                    adj[i].add(j);
                }
            }
        }
        dist[s] = 0;
        path[s] = s;
        PriorityQueue<int[]> queue = new PriorityQueue<>((e1, e2) -> (e1[1] - e2[1]));
        queue.add(new int[]{s, dist[s]});
        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int v = arr[0];
            for (Integer w : adj[v]) {
                int weight = g[v][w];
                int sum = dist[v] + weight;
                if (sum < dist[w]) {
                    dist[w] = sum;
                    path[w] = v;
                    queue.add(new int[]{w, dist[w]});
                }
            }
        }

        Stack<Integer> stack = route(path, d);
        System.out.println(dist[d]);
        System.out.println(stack);
    }

    public void shortestPath(int[][] g, int s, int d) {
        int count = g.length;
        List<Integer>[] adj = new List[count];
        int[] dist = new int[count];
        int[] path = new int[count];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(path, -1);

        /*for (int i = 0; i < count; i++) {
            for (int j = i + 1; j < count; j++) {
                if (g[i][j] != -1) {
                    adj[i].add(j);
                }
            }
        }*/
        dist[s] = 0;
        path[s] = s;
        PriorityQueue<int[]> queue = new PriorityQueue<>((e1, e2) -> (e1[1] - e2[1]));
        queue.add(new int[]{s, dist[s]});
        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int v = arr[0];
            for (int i = 0; i < g.length; i++) {
                if (g[v][i] > 0) {
                    adj[v].add(i);
                }
            }
            for (Integer w : adj[v]) {
                int weight = g[v][w];
                int sum = dist[v] + weight;
                if (sum < dist[w]) {
                    dist[w] = sum;
                    path[w] = v;
                    queue.add(new int[]{w, dist[w]});
                }
            }
        }

        Stack<Integer> stack = route(path, d);
        System.out.println(dist[d]);
        System.out.println(stack);
    }

    public Stack<Integer> route(int[] path, int p) {

        Stack<Integer> stack = new Stack<>();
        stack.push(p);
        while (p != path[p]) {
            p = path[p];
            stack.push(p);
        }
        return stack;

    }

    private void addEdge(int v, int w, List<Integer>[] adj) {
        adj[v].add(w);
    }

    public static void main(String[] args) {
        GraphQuestions questions = new GraphQuestions();
        //Edge edge = new Edge();

        int[][] g = {{0, 6, 3, -1, -1, -1},
                {6, 0, 2, 5, -1, -1},
                {3, 2, 0, 3, 4, -1},
                {-1, 5, 3, 0, 2, 3},
                {-1, -1, 4, 2, 0, 5},
                {-1, -1, -1, 3, 5, 0}};


        questions.shortestPath(g, 0, 4);

    }

}
