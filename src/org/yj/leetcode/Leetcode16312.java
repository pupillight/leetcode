package org.yj.leetcode;

import java.util.*;

public class Leetcode16312 {

    public static class UF {
        int[] arr;

        public UF(int capacity) {
            arr = new int[capacity];

            for (int i = 0; i < capacity; i++) {
                arr[i] = i;
            }
        }

        public int find(int v) {
            while (v != arr[v]) {
                v = arr[v];
            }
            return v;
        }

        public boolean isConnected(int p, int q) {
            return find(p) == find(q);
        }

        public void union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot == qRoot) {
                return;
            }
            arr[pRoot] = qRoot;
        }
    }

    public int minimumEffortPath1(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        LinkedList<int[]> list = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int k = i * n + j;
                if (j >= 1) {
                    list.add(new int[]{k - 1, k, Math.abs(heights[i][j - 1] - heights[i][j])});
                }
                if (i >= 1) {
                    list.add(new int[]{k - n, k, Math.abs(heights[i - 1][j] - heights[i][j])});
                }
            }
        }
        Collections.sort(list, (x, y) -> x[2] - y[2]);
        UF uf = new UF(m * n);
        while (!list.isEmpty()) {
            int[] p = list.poll();
            uf.union(p[0], p[1]);
            if (uf.isConnected(0, m * n - 1)) {
                return p[2];
            }
        }
        return -1;
    }

    public int minimumEffortPath2(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        LinkedList<int[]> list = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int k = i * n + j;
                if (j + 1 < n) {
                    list.add(new int[]{k, k + 1, Math.abs(heights[i][j + 1] - heights[i][j])});
                }
                if (i + 1 < m) {
                    list.add(new int[]{k, k + n, Math.abs(heights[i + 1][j] - heights[i][j])});
                }
            }
        }
        Collections.sort(list, (x, y) -> x[2] - y[2]);
        UF uf = new UF(m * n);
        while (!list.isEmpty()) {
            int[] p = list.poll();
            uf.union(p[0], p[1]);
            if (uf.isConnected(0, m * n - 1)) {
                return p[2];
            }
        }
        return 0;
    }

    public int minimumEffortPath(int[][] heights) {
        int l=0;
        int r=1000000;
        while (l<=r){
            int mid = (l+r)/2;
            boolean isSuccess = bfs(heights,mid);
            if(isSuccess){
                r=mid-1;
            }else {
                l = mid + 1;
            }
        }

        return l;
    }

    private boolean bfs(int[][] heights, int s) {
        int[][] dirs = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        int m = heights.length;
        int n = heights[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});
        boolean[][] visited = new boolean[m][n];
        visited[0][0]=true;
        while (!queue.isEmpty()) {
            int[] v = queue.poll();
            int i = v[0];
            int j = v[1];
            for (int[] dir : dirs) {
                int x = dir[0] + i;
                int y = dir[1] + j;
                if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y]) {
                    continue;
                }
                int diff = Math.abs(heights[i][j] - heights[x][y]);
                if (s < diff) {
                    continue;
                }
                queue.add(new int[]{x, y});
                visited[x][y]=true;
            }
        }

        boolean res = visited[m - 1][n - 1];
        return res;
    }

    public static void main(String[] args) {

        Leetcode16312 instance = new Leetcode16312();
        //int[][] heights = {{1, 2, 3}, {3, 8, 4}, {5, 3, 5}};
        int[][] heights = {{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};

        System.out.println(instance.minimumEffortPath(heights));
        //System.out.println(instance.minimumEffortPath1(heights));
        //int[] nums = {1, 3, 4, 5, 5, 5, 7};
        //System.out.println(instance.firstSmallerVersion(nums, 4));
        // System.out.println(instance.firstBiggerVersion(nums, 4));
        // System.out.println(instance.mySqrt(9));
        //int[] piles = {3,6,7,11};
        //int h = 8;
        // int[] piles = {312884470};
        // int h = 968709470;
        // System.out.println(instance.minEatingSpeed(piles, h));

    }


}