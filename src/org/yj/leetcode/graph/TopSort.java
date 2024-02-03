package org.yj.leetcode.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class TopSort {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
            int[] inDegree = new int[numCourses];
            List<Integer>[] adj = new List[numCourses];
            for (int i = 0; i < numCourses; i++) {
                adj[i] = new ArrayList<>();
            }
            for (int[] prerequisite : prerequisites) {
                inDegree[prerequisite[0]]++;
                adj[prerequisite[1]].add(prerequisite[0]);
            }

            Queue<Integer> queue = new ArrayDeque<>();
            for (int i = 0; i < inDegree.length; i++) {
                if (inDegree[i] == 0) queue.add(i);
            }

            List<Integer> res = new ArrayList<>();
            while (!queue.isEmpty()) {
                int v = queue.poll();
                res.add(v);
                for (Integer u : adj[v]) {
                    if (--inDegree[u] == 0) {
                        queue.add(u);
                    }
                }
            }
            if (res.size() == numCourses) {
                return res.stream().mapToInt(e -> e.intValue()).toArray();
            }
            return new int[0];
    }


    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[] inDegree = new int[numCourses];
        List<Integer>[] adj = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] prerequisite : prerequisites) {
            inDegree[prerequisite[0]]++;
            adj[prerequisite[1]].add(prerequisite[0]);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }

        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int v = queue.poll();
            res.add(v);
            for (Integer u : adj[v]) {
                if (--inDegree[u] == 0) {
                    queue.add(u);
                }
            }
        }
        if (res.size() == numCourses) return true;
        return false;
    }


    public void solution(int[][] graphs, int n) {

        List<Integer> res = new ArrayList<>();

        List<Integer>[] adj = new List[n + 1];
        int[] inDegree = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < graphs.length; i++) {
            int[] graph = graphs[i];
            adj[graph[0]].add(graph[1]);
            inDegree[graph[1]]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int v = queue.poll();
            res.add(v);
            for (Integer u : adj[v]) {
                inDegree[u]--;
                if (inDegree[u] == 0) {
                    queue.add(u);
                }
            }
        }

        if (res.size() == n) {
            res.stream().forEach(System.out::println);
        }

    }

    public static void main(String[] args) {
        TopSort instance = new TopSort();
        //int[][] graphs = {{1, 2}, {1, 3}, {2, 3}};
        // int[][] graphs = {{2, 1}, {2, 7}, {3, 1}, {3, 5}, {1, 7}, {5, 6}, {7, 4}, {7, 6}};
        //instance.solution(graphs, 7);\

        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};
        System.out.println(instance.canFinish(numCourses, prerequisites));
    }
}
