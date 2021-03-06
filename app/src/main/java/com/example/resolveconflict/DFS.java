package com.example.resolveconflict;

public class DFS {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 1, 1, 1, 1, 1, 0},
                {1, 0, 1, 0, 0, 1, 1, 0},
                {1, 0, 1, 1, 1, 1, 1, 0},
                {1, 0, 1, 0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0},
        };
        int column = 8;
        int rows = 5;
        int ret = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == 0) {
                    if (dfs(i, j, grid)) {
                        ret++;
                    }
                }
            }
        }
        System.out.println("封闭岛屿:" + ret);
    }

    public static boolean dfs(int x, int y, int[][] grid) {
        int column = 8;
        int rows = 5;
        if (x < 0 || x >= rows || y < 0 || y >= column) {
            return false;
        }
        if (grid[x][y] == 1) {
            return true;
        }
        grid[x][y] = 1;
        boolean top = dfs(x, y - 1, grid);
        boolean bottom = dfs(x, y + 1, grid);
        boolean left = dfs(x - 1, y, grid);
        boolean right = dfs(x + 1, y, grid);
        return top && bottom && left && right;
    }
}
