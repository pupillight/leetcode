package org.yj.leetcode.dfs;

public class QuestionsDfs {
    public static class Question200 {
        //200. Number of Islands
        public int numIslands(char[][] grid) {
            int count = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == '1') {
                        dfs(grid, i, j);
                        count++;
                    }
                }
            }
            return count;
        }

        private void dfs(char[][] grid, int r, int l) {
            if (r >= 0 && r < grid.length && l >= 0 && l < grid[0].length && grid[r][l] == '1') {
                grid[r][l] = '2';
                int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
                for (int i = 0; i < directions.length; i++) {
                    int x = r - directions[i][0];
                    int y = l - directions[i][1];
                    dfs(grid, x, y);
                }
            }
        }
    }

    public static class Question695 {
        int res = 0;

        public int maxAreaOfIsland(int[][] grid) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 1) {
                        int t = dfs(grid, i, j);
                        res = Math.max(res, t);
                    }
                }
            }
            return res;
        }

        private int dfs(int[][] grid, int i, int j) {
            int ans = 0;
            if (!check(grid, i, j)) {
                return 0;
            }
            ans = 1;
            grid[i][j] = 2;
            int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
            for (int k = 0; k < dir.length; k++) {
                int x = dir[k][0];
                int y = dir[k][1];
                ans += dfs(grid, i + x, j + y);
            }
            return ans;
        }

        private boolean check(int[][] grid, int i, int j) {
            if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1) {
                return true;
            }
            return false;
        }

/*
    int res = 0;
    int m=0;
    public int maxAreaOfIsland(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    m=0;
                    dfs1(grid, i, j);
                    System.out.println(res);
                }
            }
        }
        return res;
    }

    private void dfs1(int[][] grid, int i, int j) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1) {
            m = m + 1;
            res = Math.max(res, m);
            grid[i][j] = 2;
            int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
            for (int k = 0; k < dir.length; k++) {
                int x = dir[k][0];
                int y = dir[k][1];
                dfs1(grid, i + x, j + y);
            }
        }
    }*/
    }

    public static class Question463 {
        public int islandPerimeter(int[][] grid) {
            boolean[][] visited = new boolean[grid.length][grid[0].length];
            int res = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1 && visited[i][j] == false) {
                        res = dfs(grid, i, j, visited);
                    }
                }
            }
            return res;
        }

        private int dfs(int[][] grid, int i, int j, boolean[][] visited) {
            int ans = 0;
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
                return 1;
            }
            if (visited[i][j]) return 0;
            visited[i][j] = true;
            int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            for (int k = 0; k < dir.length; k++) {
                int x = dir[k][0] + i;
                int y = dir[k][1] + j;
                ans = ans + dfs(grid, x, y, visited);
            }
            return ans;
        }

       /* private boolean check(int[][] grid, int i, int j, boolean[][] visited) {
            if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1 && visited[i][j] == false) {
                return true;
            }
            return false;
        }*/
    }

    public static class Question79 {
        public boolean exist(char[][] board, String word) {
            boolean ans = false;

            boolean[][] visited = new boolean[board.length][board[0].length];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    ans = dfs(board, i, j, word, 0, visited);
                    if (ans) {
                        return true;
                    }
                }
            }
            return false;

        }

        private boolean dfs(char[][] board, int i, int j, String word, int k, boolean[][] visited) {
            if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(k) || visited[i][j] == true) {
                return false;
            }
            if (k == (word.length() - 1)) {
                return true;
            }
            boolean res = false;
            int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            for (int l = 0; l < dir.length; l++) {
                int x = dir[l][0];
                int y = dir[l][1];

                visited[i][j] = true;
                res = dfs(board, i + x, j + y, word, k + 1, visited);
                visited[i][j] = false;
            }
    /*       visited[i][j] = true;
     boolean res = dfs(board, i - 1, j, word, k + 1, visited)
                    || dfs(board, i + 1, j, word, k + 1, visited)
                    || dfs(board, i, j - 1, word, k + 1, visited)
                    || dfs(board, i, j + 1, word, k + 1, visited);
            visited[i][j] = false;*/
            return res;
        }
    }

    public static class Question2658 {
        public int findMaxFish(int[][] grid) {
            int res = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] > 0) {
                        int curr = dfs(grid, i, j);
                        res = Math.max(res, curr);
                    }
                }
            }
            return res;
        }

        private int dfs(int[][] grid, int i, int j) {
            int ans = 0;
            if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] > 0) {
                ans = grid[i][j];
                grid[i][j] = 0;


                int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

                for (int k = 0; k < dir.length; k++) {
                    int x = dir[k][0];
                    int y = dir[k][1];
                    ans += dfs(grid, i + x, j + y);
                }

            }
            return ans;
        }

    }

    public static class Questions1391 {
        public boolean hasValidPath(int[][] grid) {
            boolean[][] visited = new boolean[grid.length][grid[0].length];
            return dfs(grid, 0, 0, visited);
        }

        public boolean dfs(int[][] grid, int i, int j, boolean[][] visited) {
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j]) {
                return false;
            }
            if (i == grid.length - 1 && j == grid[0].length - 1) {
                return true;
            }
            visited[i][j] = true;
            int t = grid[i][j];
            boolean res = false;
            if (t == 1) {
                if (j - 1 >= 0 && (grid[i][j - 1] == 1 || grid[i][j - 1] == 4 || grid[i][j - 1] == 6)) {
                    res = res || dfs(grid, i, j - 1, visited);
                }
                if (j + 1 < grid[0].length && (grid[i][j + 1] == 1 || grid[i][j + 1] == 3 || grid[i][j + 1] == 5)) {
                    res = res || dfs(grid, i, j + 1, visited);
                }
            }
            if (t == 2) {
                if (i - 1 >= 0 && (grid[i - 1][j] == 2 || grid[i - 1][j] == 3 || grid[i - 1][j] == 4)) {
                    res = res || dfs(grid, i - 1, j, visited);
                }
                if (i + 1 < grid.length && (grid[i + 1][j] == 2 || grid[i + 1][j] == 5 || grid[i + 1][j] == 6)) {
                    res = res || dfs(grid, i + 1, j, visited);
                }
            }
            if (t == 3) {
                if (j - 1 >= 0 && (grid[i][j - 1] == 1 || grid[i][j - 1] == 4 || grid[i][j - 1] == 6)) {
                    res = res || dfs(grid, i, j - 1, visited);
                }
                if (i + 1 < grid.length && (grid[i + 1][j] == 2 || grid[i + 1][j] == 5 || grid[i + 1][j] == 6)) {
                    res = res || dfs(grid, i + 1, j, visited);
                }
            }
            if (t == 4) {
                if (j + 1 < grid[0].length && (grid[i][j + 1] == 1 || grid[i][j + 1] == 3 || grid[i][j + 1] == 5)) {
                    res = res || dfs(grid, i, j + 1, visited);
                }
                if (i + 1 < grid.length && (grid[i + 1][j] == 2 || grid[i + 1][j] == 5 || grid[i + 1][j] == 6)) {
                    res = res || dfs(grid, i + 1, j, visited);
                }
            }
            if (t == 5) {
                if (j - 1 >= 0 && (grid[i][j - 1] == 1 || grid[i][j - 1] == 4 || grid[i][j - 1] == 6)) {
                    res = res || dfs(grid, i, j - 1, visited);
                }
                if (i - 1 >= 0 && (grid[i - 1][j] == 2 || grid[i - 1][j] == 3 || grid[i - 1][j] == 4)) {
                    res = res || dfs(grid, i - 1, j, visited);
                }
            }
            if (t == 6) {
                if (j + 1 < grid[0].length && (grid[i][j + 1] == 1 || grid[i][j + 1] == 3 || grid[i][j + 1] == 5)) {
                    res = res || dfs(grid, i, j + 1, visited);
                }
                if (i + 1 < grid.length && (grid[i + 1][j] == 2 || grid[i + 1][j] == 3 || grid[i + 1][j] == 4)) {
                    res = res || dfs(grid, i + 1, j, visited);
                }
            }
            visited[i][j] = false;
            return res;
        }
    }


    public static class Question130 {
        public void solve(char[][] board) {

            int m = board.length;
            int n = board[0].length;
            boolean[][] visited = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                if (board[i][0] == 'O') {
                    dfs(board, i, 0, visited);
                }
                if (board[i][n - 1] == 'O') {
                    dfs(board, i, n - 1, visited);
                }
            }

            for (int i = 0; i < n; i++) {
                if (board[0][i] == 'O') {
                    dfs(board, 0, i, visited);
                }
                if (board[m - 1][i] == 'O') {
                    dfs(board, m - 1, i, visited);
                }
            }

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (board[i][j] == 'O' && visited[i][j] == false) {
                        board[i][j] = 'X';
                    }
                }
            }
        }


        private void dfs(char[][] board, int i, int j, boolean visited[][]) {

            visited[i][j] = true;
            int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            for (int[] dir : dirs) {
                int x = i + dir[0];
                int y = j + dir[1];
                if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] == 'O' && visited[x][y] == false) {
                    dfs(board, x, y, visited);
                }
            }
        }
    }

    public int combinationSum4(int[] nums, int target) {

        return trackback(nums,target);
    }


    private int trackback(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                res = res + trackback(nums, target - nums[i]);
            }
        }
        return res;
    }

    public int combinationSum41(int[] nums, int target) {

        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                int num = nums[j];
                if (num <= i) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }


    public int maxSubArray(int[] nums) {

        int[] dp = new int[nums.length];
        int res = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
            res = Math.max(res, dp[i]);
        }

        return res;
    }


    public static void main(String[] args) {
       /* char[][] grid = {{'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};*/
       /* char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};*/
    /*    int[][] grid = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};*/
/*
        int[][] grid = {
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}};


        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        String word = "ABCB";*/
/*        int[][] grid = {
                {0, 2, 1, 0},
                {4, 0, 0, 3},
                {1, 0, 0, 4},
                {0, 3, 2, 0}};*/


        int[][] grid = {{1, 1, 1, 1, 1, 1, 3}};
        //int[][] grid = {{2, 4, 3}, {6, 5, 2}};
        //Questions instance = new Questions();
        QuestionsDfs.Questions1391 instance = new Questions1391();
        //System.out.println(instance.numIslands(grid));
        //  System.out.println(instance.hasValidPath(grid));
        QuestionsDfs questionsDfs = new QuestionsDfs();
        // int[] nums = {5, 4, -1, 7, 8};

        //System.out.println(questionsDfs.maxSubArray(nums));


        int[] nums = {1, 2, 3};
        int target = 4;
        System.out.println(questionsDfs.combinationSum4(nums, target));
    }
}
