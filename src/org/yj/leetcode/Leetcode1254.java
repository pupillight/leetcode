package org.yj.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcode1254 {
    int row;
    int col;

    public int closedIsland(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        for (int i = 0; i < row; i++) {
            if (grid[i][0] == 0) {
                dfs(grid, i, 0);
            }
            if (grid[i][col - 1] == 0) {
                dfs(grid, i, col - 1);
            }
        }
        for (int j = 1; j < col - 1; j++) {
            if (grid[0][j] == 0) {
                dfs(grid, 0, j);
            }
            if (grid[row - 1][j] == 0) {
                dfs(grid, row - 1, j);
            }
        }
        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0) {
                    dfs(grid, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }

    private void dfs(int[][] grid, int i, int j) {

        grid[i][j] = 2;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && x < row && y >= 0 && y < col && grid[x][y] == 0) {
                dfs(grid, x, y);
            }
        }
    }


    private int calculate(int[] player) {
        int k = 2;
        int sum = 0;
        LinkedList<Integer> list = new LinkedList<>();
        k = player.length > k ? k : player.length;
        for (int i = 0; i < k; i++) {
            if (!list.isEmpty() && list.getLast() >= i - k) {
                sum += player[i] * 2;
            } else {
                sum += player[i];
            }
            if (player[i] == 10) {
                if (!list.isEmpty()) {
                    list.removeLast();
                }
                list.add(i);
            }
        }
        for (int i = k; i < player.length; i++) {
            if (!list.isEmpty() && list.getLast() >= i - k) {
                sum += player[i] * 2;
            } else {
                sum += player[i];
            }
            if (player[i] == 10) {
                if (!list.isEmpty()) {
                    list.removeLast();
                }
                list.add(i);
            }
        }
        return sum;
    }

    public int isWinner(int[] player1, int[] player2) {
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        int sum1 = calculate(player1), sum2 = calculate(player2);
        if (sum1 > sum2) {
            return 1;
        } else if (sum1 == sum2) {
            return 0;
        } else {
            return 2;
        }
    }


    public static void main(String[] args) {
        int[][] grid = {{0, 0, 1, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 1, 1, 1, 0}
        };


        /*char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};*/
        Leetcode1254 instance = new Leetcode1254();
        //System.out.println(instance.closedIsland(grid));

        int[] player1 = {10, 10, 0};
        int[] player2 = {3, 10, 6};

        System.out.println(instance.isWinner(player1, player2));
    }


}
