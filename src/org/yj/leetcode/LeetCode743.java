package org.yj.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LeetCode743 {

    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n + 1];
        int[] path = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(path, -1);
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((e1, e2) -> e1[1] - e2[1]);
        dist[k] = 0;
        path[k] = k;
        queue.add(new int[]{k, dist[k]});

        while (!queue.isEmpty()) {
            int[] array = queue.poll();
            for (int i = 0; i < times.length; i++) {
                if (times[i][0] == array[0]) {
                    int w = times[i][1];
                    int newDist = array[1] + times[i][2];
                    if (newDist < dist[w]) {
                        path[w] = array[0];
                        dist[w] = newDist;
                        queue.add(new int[]{w, dist[w]});

                    }
                }
            }
        }
        int ans = -1;
        for (int i = 1; i < dist.length; i++) {
            if (i != k && path[i] == -1) {
                return -1;
            }
            if (dist[i] > ans) {
                ans = dist[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        //int[][] times = {{1, 2, 1}};
        int n = 4, k = 2;
        //int[][] times = {{1, 2, 1}, {2, 3, 2}, {1, 3, 4}};
        //int n = 3, k = 1;
        LeetCode743 leetcode = new LeetCode743();
        System.out.println(leetcode.networkDelayTime(times, n, k));

    }

}
