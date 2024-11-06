package org.yj.leetcode.graph;

import java.util.*;
import java.util.stream.Collectors;

public class LeetCode207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[] inDegree = new int[numCourses];
        List<Integer>[] adj = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] prerequisite : prerequisites) {
            int to = prerequisite[0];
            int from = prerequisite[1];
            inDegree[to]++;
            adj[from].add(to);
        }

        Queue<Integer> queue = new ArrayDeque<>();

        int count = 0;
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
                count++;
            }
        }

        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (Integer u : adj[v]) {
                inDegree[u]--;
                if (inDegree[u] == 0) {
                    queue.add(u);
                    count++;
                }
            }
        }
        if (count == numCourses) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        LeetCode207 instance = new LeetCode207();

    }
}
