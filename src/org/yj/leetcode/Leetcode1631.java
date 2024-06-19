package org.yj.leetcode;

import java.util.*;

public class Leetcode1631 {


    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        List<int[]> list = new ArrayList<>();
        UF uf = new UF(m * n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int k = i * n + j;
                if (i > 0) {
                    list.add(new int[]{k - n, k, Math.abs(heights[i][j] - heights[i - 1][j])});
                }
                if (j > 0) {
                    list.add(new int[]{k - 1, k, Math.abs(heights[i][j] - heights[i][j - 1])});
                }
            }
        }
        Collections.sort(list, (e1, e2) -> e1[2] - e2[2]);

/*
        int res =0;
        for (int[] edge : list) {
            int p= edge[0];
            int q= edge[1];
            res=edge[2];
            uf.union(p, q);
            if (uf.isConnected(0, m * n - 1)) {
                break;
            }

        }
        return res;*/
        int res = 0;

/*        for (int j = 0; j < list.size(); j++) {
            int[] arr = list.get(j);
            int p = arr[0];
            int q = arr[1];
            res = arr[2];
            uf.union(p, q);
            if (uf.isConnected(0, m * n - 1)) {
                break;
            }
        }*/
        int i = 0;
        while (!list.isEmpty() && i <list.size()) {
            int[] arr = list.get(i);
            int p = arr[0];
            int q = arr[1];
            res = arr[2];
            uf.union(p, q);
            if (uf.isConnected(0, m * n - 1)) {
                break;
            }
            i++;
        }

        return res;

    }

    /*private void dfs(int[][] heights, int x, int y, boolean[][] visited, List<Integer> pathValues) {

        if (x == heights.length - 1 && y == heights[0].length - 1) {
            int currMaxDiff = 0;
            for (int i = 1; i < pathValues.size(); i++) {
                int diff = Math.abs(pathValues.get(i) - pathValues.get(i - 1));
                currMaxDiff = Math.max(currMaxDiff, diff);
            }

            minCost = currMaxDiff;
            diffs.add(currMaxDiff);
            return;
        }
        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int i = 0; i < direction.length; i++) {
            int nextX = x + direction[i][0];
            int nextY = y + direction[i][1];
            if (nextX >= 0 && nextX < heights.length && nextY >= 0 && nextY < heights[0].length && !visited[nextX][nextY]) {

                if (minCost != Integer.MAX_VALUE) {
                    int cost = Math.abs(heights[x][y] - heights[nextX][nextY]);
                    if (minCost < cost) {
                        return;
                    }
                }
                //diff = Math.max(diff, Math.abs(heights[x][y] - heights[nextX][nextY]));

                visited[nextX][nextY] = true;
                int v = heights[nextX][nextY];
                pathValues.add(v);
                dfs(heights, nextX, nextY, visited, pathValues);
                visited[nextX][nextY] = false;
                pathValues.remove(pathValues.size() - 1);
            }
        }


    }*/

    public int mySqrt1(int x) {

        if (x == 0) return 0;
        int l = 1;
        int r = x;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (mid == x / mid) {
                return mid;
            } else if (mid > x / mid) {
                r = mid - 1;
            } else {
                if ((mid + 1) > x / (mid + 1)) {
                    return mid;
                } else {
                    l = mid + 1;
                }
            }
        }
        return -1;
    }

    public int mySqrt2(int x) {

        if (x == 0) return 0;
        int l = 1;
        int r = x;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (mid <= x / mid) {
                if ((mid + 1) > x / (mid + 1)) {
                    return mid;
                } else {
                    l = mid + 1;
                }

            } else if (mid > x / mid) {
                r = mid - 1;
            }
        }
        return -1;
    }

    public int mySqrt(int x) {

        if (x == 0) return 0;
        int l = 1;
        int r = x;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (mid <= x / mid) {
                if ((mid + 1) > x / (mid + 1)) {
                    return mid;
                } else {
                    l = mid + 1;
                }

            } else if (mid > x / mid) {
                r = mid - 1;
            }
        }
        return -1;
    }

    public int firstSmallerVersion(int[] nums, int n) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] <= n) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return j;
    }

    public int firstBiggerVersion(int[] nums, int n) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] >= n) {
                if (nums[mid - 1] < n) {
                    return mid;
                }
                j = mid - 1;

            } else {
                i = mid + 1;
            }
        }
        return -1;
    }

    public int minEatingSpeed1(int[] piles, int h) {
        Arrays.sort(piles);
        int l = 1;
        int r = piles[piles.length - 1];
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (takeHours(piles, mid, h) <= h) {
                if (mid == 1 || takeHours(piles, mid - 1, h) > h) {
                    return mid;
                }
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }


    private int takeHours(int[] piles, int speed, int h) {
        if (speed == 0) {
            System.out.println(speed);
        }
        int hours = 0;
        for (int i = 0; i < piles.length; i++) {
            int pile = piles[i];
            int n = pile / speed;
            if (pile % speed != 0) {
                n = n + 1;
            }
            hours += n;
        }
        return hours;
    }

    public static void main(String[] args) {

        Leetcode1631 instance = new Leetcode1631();
        //int[][] heights = {{1, 2, 3}, {3, 8, 4}, {5, 3, 5}};
        //int[][] heights = {{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
        //System.out.println(instance.minimumEffortPath(heights));
        int[] nums = {1, 3, 4, 5, 5, 5, 7};
        //System.out.println(instance.firstSmallerVersion(nums, 4));
        System.out.println(instance.firstBiggerVersion(nums, 4));
        // System.out.println(instance.mySqrt(9));
        //int[] piles = {3,6,7,11};
        //int h = 8;
        // int[] piles = {312884470};
        // int h = 968709470;
        // System.out.println(instance.minEatingSpeed(piles, h));

    }


    public static class UF {
        int[] parent;

        public UF(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int p) {
            while (parent[p] != p) {
                p = parent[p];
            }
            return p;
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

            parent[pRoot] = qRoot;

        }
    }
}