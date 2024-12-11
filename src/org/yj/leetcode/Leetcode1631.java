package org.yj.leetcode;

import java.util.*;

public class Leetcode1631 {
    public int minimumEffortPath(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        boolean[][] visited = new boolean[row][col];
        int dists[][] = new int[row][col];
        for (int[] dist : dists) {
            Arrays.fill(dist, Integer.MAX_VALUE);
        }
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Comparator<int[]> comparator = (arr1, arr2) -> arr1[2] - arr2[2];
        PriorityQueue<int[]> queue = new PriorityQueue<>(comparator);
        queue.add(new int[]{0, 0, 0});
        dists[0][0] =0;
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int i = p[0];
            int j = p[1];
            int v = p[2];
            if( visited[i][j]){
                continue;
            }
            visited[i][j]=true;
            for (int[] dir : dirs) {
                int x = i + dir[0];
                int y = j + dir[1];
                if (x >= 0 && x < row && y >= 0 && y < col ) {
                    int diff = Math.abs(heights[i][j] - heights[x][y]);// 路径长度
                    int currDist =Math.max(v,diff);
                    if (currDist < dists[x][y]) {
                        dists[x][y] = currDist;
                        queue.add(new int[]{x, y, dists[x][y]});
                    }
                }
            }
        }

        return dists[row - 1][col - 1];
    }

    private boolean f(int[][] heights, int v, int i, int j) {
        int row = heights.length;
        int col = heights[0].length;
        boolean[][] visited = new boolean[row][col];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{i, j});
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            for (int[] dir : dirs) {
                int x = p[0] + dir[0];
                int y = p[1] + dir[1];
                if (x < 0 || x >= row || y < 0 || y >= col || visited[x][y]) {
                    continue;
                }
                int diff = Math.abs(heights[p[0]][p[1]] - heights[x][y]);
                if (diff > v) {
                    continue;
                }
                queue.add(new int[]{x, y});
                visited[x][y] = true;
            }
        }
        return visited[row - 1][col - 1] == true;
    }

    public int minimumEffortPath2(int[][] heights) {
        int l = 0;
        int r = 1000000;
        while (l <= r) {
            int mid = (l + r) / 2;

            if (!f(heights, mid, 0, 0)) {
                l = mid + 1;

            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    public int minimumEffortPath1(int[][] heights) {
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
        int res = 0;
        int i = 0;
        while (!list.isEmpty() && i < list.size()) {
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
        int[][] heights = {{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};

        System.out.println(instance.minimumEffortPath(heights));
        System.out.println(instance.minimumEffortPath1(heights));
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