package org.yj.leetcode;

import java.util.*;

public class LeetCode1926 {

    int ans = Integer.MAX_VALUE;

    public int nearestExit(char[][] maze, int[] entrance) {
        int row = maze.length;
        int col = maze[0].length;
        boolean[][] visited = new boolean[row][col];
        int step = 0;
        visited[entrance[0]][entrance[1]] = true;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{entrance[0], entrance[1], step});

        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            int m = position[0];
            int n = position[1];
            step = position[2];

            if ((m == 0 || m == row - 1 || n == 0 || n == col - 1) && maze[m][n] == '.') {
                if (step > 0) {
                    if (ans > step) {
                        ans = step;
                    }
                }
            }
            int[] dx = {0, 1, 0, -1};
            int[] dy = {1, 0, -1, 0};
            for (int i = 0; i < dx.length; i++) {
                int nextX = m + dx[i];
                int nextY = n + dy[i];
                if (nextX >= 0 && nextX < row && nextY >= 0 && nextY < col && maze[nextX][nextY] == '.' && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY, step + 1});
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }


    /*public int nearestExit(char[][] maze, int[] entrance) {
        int row = maze.length;
        int col = maze[0].length;
        boolean[][] visited = new boolean[row][col];
        int x = entrance[0];
        int y = entrance[1];
        visited[x][y] = true;
        dfs(row, col, maze, x, y, visited, 0, x, y);
        //return ans == 0 ? -1 : ans;
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private void dfs(int row, int col, char[][] maze, int x, int y, boolean[][] visited, int step, int entryX, int entryY) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        if ((x != entryX || y != entryY) && (x == row - 1 || x == 0 || y == col - 1 || y == 0) && maze[x][y] == '.') {
            if (ans > step) {
                ans = step;
            }
        }
        for (int i = 0; i < dx.length; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX >= 0 && nextX < row && nextY >= 0 && nextY < col && maze[nextX][nextY] == '.' && !visited[nextX][nextY]) {
                visited[nextX][nextY] = true;
                dfs(row, col, maze, nextX, nextY, visited, step + 1, entryX, entryY);
                visited[nextX][nextY] = false;
            }
        }
    }
*/


    public int[] getNums(int n) {

        int num = 1;
        List<Integer> list = new ArrayList<>();
        list.add(num);
        n = n - num;
        while (n >= num) {
            num = num * 2;
            if (n >= num) {
                n = n - num;
                list.add(num);
            }
        }
        list.add(n);

        System.out.println(list);
        int[] res = list.stream().mapToInt(item -> item).toArray();

        return res;
    }

    public boolean isFascinating(int n) {

        int[] nums = new int[10];
        StringBuilder builder = new StringBuilder(n);
        builder.append(n);
        builder.append(2 * n);
        builder.append(3 * n);
        char[] chars = builder.toString().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            nums[c - '0']++;
        }

        if (nums[0]>=1) return false;
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] > 1) {
                return false;
            }

        }
        return true;
    }




    public static void main(String[] args) {
        LeetCode1926 instance = new LeetCode1926();

        //instance.getNums(2);
        instance.isFascinating(127);
     /*   char[][] maze = {{'.', '+'}};
        int[] entrance = {0, 0};*/

        char[][] maze = {{'+', '+', '+'},
                {'.', '.', '.'},
                {'+', '+', '+'}};
        int[] entrance = {1, 0};

/*        char[][] maze = {{'+', '+', '.', '+'}, {'.', '.', '.', '+'}, {'+', '+', '+', '.'}};
        int[] entrance = {1, 2};*/
        //System.out.println(instance.nearestExit(maze, entrance));
    }
}
