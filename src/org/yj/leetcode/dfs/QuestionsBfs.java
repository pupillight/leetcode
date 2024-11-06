package org.yj.leetcode.dfs;

import java.util.*;
import java.util.stream.IntStream;

public class QuestionsBfs {


    public int nearestExit(char[][] maze, int[] entrance) {


        int r = maze.length;
        int l = maze[0].length;
        boolean[][] visited = new boolean[r][l];
        Queue<int[]> queue = new ArrayDeque();

        queue.add(new int[]{entrance[0], entrance[1], 0});
        maze[entrance[0]][entrance[1]] = '+';

        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int[] v = queue.poll();
            int m = v[0];
            int n = v[1];
            int dist = v[2];

            if ((m == 0 || m == r - 1 || n == 0 || n == l - 1) && maze[m][n] == '.') {
                return dist;
            }

            for (int i = 0; i < dir.length; i++) {
                int x = m + dir[i][0];
                int y = n + dir[i][1];
                if (x >= 0 && x < r && y >= 0 && y < l && maze[x][y] == '.' && !visited[x][y]) {
                    visited[x][y] = true;
                    queue.add(new int[]{x, y, dist + 1});
                }
            }
        }
        return -1;

    }

    public int orangesRotting(int[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int dist = 0;
        while (count > 0 && !queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] p = queue.poll();
                for (int[] dir : dirs) {
                    int x = p[0] + dir[0];
                    int y = p[1] + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                        count--;
                        grid[x][y] = 2;
                        queue.add(new int[]{x, y});
                    }
                }
            }
            dist++;
        }
        if (count > 0) {
            return -1;
        }
        return dist;
    }

    /*    public int[][] updateMatrix(int[][] matrix) {
            // 首先将所有的 0 都入队，并且将 1 的位置设置成 -1，表示该位置是 未被访问过的 1
            Queue<int[]> queue = new LinkedList<>();
            int m = matrix.length, n = matrix[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 0) {
                        queue.offer(new int[] {i, j});
                    } else {
                        matrix[i][j] = -1;
                    }
                }
            }

            int[] dx = new int[] {-1, 1, 0, 0};
            int[] dy = new int[] {0, 0, -1, 1};
            while (!queue.isEmpty()) {
                int[] point = queue.poll();
                int x = point[0], y = point[1];
                for (int i = 0; i < 4; i++) {
                    int newX = x + dx[i];
                    int newY = y + dy[i];
                    // 如果四邻域的点是 -1，表示这个点是未被访问过的 1
                    // 所以这个点到 0 的距离就可以更新成 matrix[x][y] + 1。
                    if (newX >= 0 && newX < m && newY >= 0 && newY < n
                            && matrix[newX][newY] == -1) {
                        matrix[newX][newY] = matrix[x][y] + 1;
                        queue.offer(new int[] {newX, newY});
                    }
                }
            }

            return matrix;

        }*/
    public int[][] updateMatrix1(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {

            int[] p = queue.poll();
            int px = p[0];
            int py = p[1];
            for (int[] dir : dirs) {
                int x = px + dir[0];
                int y = py + dir[1];
                if (x >= 0 && x < m && y >= 0 && y < n && mat[x][y] == -1) {
                    mat[x][y] = mat[px][py] + 1;
                    queue.add(new int[]{x, y});
                }
            }
        }
        return mat;
    }

    public int[][] updateMatrix(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = Integer.MAX_VALUE;
                if (mat[i][j] == 0) {
                    res[i][j] = 0;
                    queue.add(new int[]{i, j});
                }
            }
        }
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {

            int[] p = queue.poll();
            int px = p[0];
            int py = p[1];
            for (int[] dir : dirs) {
                int x = px + dir[0];
                int y = py + dir[1];
                if (x >= 0 && x < m && y >= 0 && y < n && res[x][y] > res[px][py] + 1) {
                    res[x][y] = res[px][py] + 1;
                    queue.add(new int[]{x, y});
                }
            }
        }
        return res;
    }


    public int[][] wallAndGate(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int x = p[0];
            int y = p[1];

            for (int[] dir : dirs) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] == Integer.MAX_VALUE) {
                    grid[newX][newY] = grid[x][y] + 1;
                    queue.add(new int[]{newX, newY});
                }
            }
        }
        return grid;
    }

    public int maxDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    res[i][j] = 0;
                    queue.add(new int[]{i, j});
                } else {
                    res[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int ans = -1;
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int px = p[0];
            int py = p[1];
            for (int[] dir : dirs) {
                int x = px + dir[0];
                int y = py + dir[1];
                if (x >= 0 && x < m && y >= 0 && y < n && res[x][y] == Integer.MAX_VALUE) {
                    res[x][y] = res[px][py] + 1;
                    queue.add(new int[]{x, y});
                    ans = Math.max(ans, res[x][y]);
                }
            }
        }

        return ans;
    }

    public int shortestBridge(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> list = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i, j});
                    grid[i][j] = 2;
                    while (!queue.isEmpty()) {
                        int[] p = queue.poll();
                        list.add(p);
                        for (int[] dir : dirs) {
                            int x = p[0] + dir[0];
                            int y = p[1] + dir[1];
                            if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                                grid[x][y] = 2;
                                queue.add(new int[]{x, y});
                            }
                        }
                    }
                }

                int step = 0;
                while (!list.isEmpty()) {
                    int size = list.size();
                    for (int k = 0; k < size; k++) {
                        int[] p = list.poll();
                        for (int[] dir : dirs) {
                            int x = p[0] + dir[0];
                            int y = p[1] + dir[1];
                            if (x >= 0 && x < m && y >= 0 && y < n) {
                                if (grid[x][y] == 0) {
                                    grid[x][y] = 2;
                                    list.add(new int[]{x, y});
                                }
                                if (grid[x][y] == 1) {
                                    return step;
                                }
                            }
                        }
                    }
                    step++;
                }
            }
        }
        return -1;
    }


    public int closedIsland(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < n; i++) {
            if (grid[0][i] == 0) {
                dfs(grid, 0, i);
            }
            if (grid[m - 1][i] == 0) {
                dfs(grid, m - 1, i);
            }
        }
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0) {
                dfs(grid, i, 0);
            }
            if (grid[i][n - 1] == 0) {
                dfs(grid, i, n - 1);
            }
        }
        int ans =0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    dfs(grid, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }

    private void dfs(int[][] grid, int i, int j) {
        grid[i][j] = -1;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 0) {

                dfs(grid, x, y);
            }
        }


    }


    public static void main(String[] args) {
        //char[][] maze = {{'+', '+', '.', '+'}, {'.', '.', '.', '+'}, {'+', '+', '+', '.'}};
        char[][] maze = {{'+', '+', '+'}, {'.', '.', '.'}, {'+', '+', '+'}};
        int[] entrance = {1, 0};

        QuestionsBfs instance = new QuestionsBfs();
        // System.out.println(instance.nearestExit(maze, entrance));
      /*  int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(instance.orangesRotting(grid));*/
       // int[][] mat = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        //  instance.updateMatrix(mat);
      //  int[][] grid = {{0, 1}, {1, 0}};

     //   System.out.println(instance.shortestBridge(grid));


       int[][] grid = {{1,1,1,1,1,1,1,0},{1,0,0,0,0,1,1,0},{1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}};

        System.out.println(instance.closedIsland(grid));
    }


}
