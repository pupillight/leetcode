package org.yj.leetcode.dp;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Leetcode2684 {

/*    public int maxMoves1(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Set<Integer> q = IntStream.range(0, m).boxed().collect(Collectors.toSet());
        for (int j = 0; j < n - 1; ++j) {
            Set<Integer> t = new HashSet<>();
            for (int i : q) {
                for (int k = i - 1; k <= i + 1; ++k) {
                    if (k >= 0 && k < m && grid[i][j] < grid[k][j + 1]) {
                        t.add(k);
                    }
                }
            }
            if (t.isEmpty()) {
                return j;
            }
            q = t;
        }
        return n - 1;

    }*/

  /*  public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dirs = {-1, 0, 1};
        Set<Integer> list = new HashSet<>();
        for (int i = 0; i < m; i++) {
                list.add(i);
        }
        for (int j = 0; j < n-1; j++) {
            Set<Integer> currList = new HashSet<>();
            for (Integer i : list) {
               for (int dir : dirs) {
                    int k = i + dir;
                    if (k >= 0 && k < m && grid[i][j] < grid[k][j + 1]) {
                            currList.add(k);
                    }
                }
            }

            if(currList.isEmpty()){
                return j;
            }
            list = currList;
        }
        return n-1;
    }*/
 /*   public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dirs = {-1, 0, 1};
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            if(!list.contains(i)){
                list.add(i);
            }
        }
        for (int j = 0; j < n-1; j++) {
            List<Integer> currList = new ArrayList<>();
            for (Integer i : list) {
                for (int dir : dirs) {
                    int k = i + dir;
                    if (k >= 0 && k < m && grid[i][j] < grid[k][j + 1]) {
                        if(!currList.contains(k)){
                            currList.add(k);
                        }
                    }
                }
            }
            if(currList.isEmpty()){
                return j;
            }
            list = currList;
        }
        return n-1;
    }*/

    /* public int maxMoves(int[][] grid) {
         int m = grid.length;
         int n = grid[0].length;
         int[] dirs = {-1, 0, 1};

         int[][] dist = new int[m][n];
         Queue<int[]> list = new LinkedList<>();
         for (int i = 0; i < m; i++) {
             list.add(new int[]{i, 0});
         }
         int ans =0;
         while (!list.isEmpty()) {
             int[] p = list.poll();
             int px = p[0];
             int py = p[1];
             for (int dir : dirs) {
                 int x = px + dir;
                 int y = py + 1;
                 if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] > grid[px][py] && dist[x][y]==0) {
                     dist[x][y] = dist[px][py]+1;
                     ans = Math.max(ans, dist[x][y]);
                     list.add(new int[]{x, y});
                 }
             }
         }
         return ans;
     }
 */
    int ans = 0;
    boolean[][] visited;

    public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(grid, i, 0);
            //ans = Math.max(ans, dfs(grid, i, 0));
        }
        return ans;
    }

    private void dfs(int[][] grid, int i, int j) {
        ans = Math.max(ans, j);

  /*      if (j == grid[0].length - 1) {
            return;
        }*/
        int ans = 0;
        int[][] dirs = {{-1, 1}, {0, 1}, {1, 1}};
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] > grid[i][j] && !visited[x][y]) {
                visited[i][j] = true;
                dfs(grid, x, y);
            }
        }
    }


/*
    public int maxProductPath(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] * grid[0][i];
        }

        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] * grid[i][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {

                if(grid[i][j]>0){
                    if(dp[i-1][j] >0  && dp[i][j-1]>0){
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) *grid[i][j];
                    }else if(){

                    }
                }
             dp[i][j]= dp[i-1][j] * grid[i][j]   dp[i][j-1]*grid[i][j]
            }
        }
    }
*/


    public static void main(String[] args) {

        Leetcode2684 instance = new Leetcode2684();
        int[][] grid = {{2, 4, 3, 5}, {5, 4, 9, 3}, {3, 4, 2, 11}, {10, 9, 13, 15}};
        //int[][] grid = {{3, 2, 4}, {2, 1, 9}, {1, 1, 7}};

        System.out.println(instance.maxMoves(grid));
    }
}
