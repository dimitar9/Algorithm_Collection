import java.util.Arrays;

/*
8. 给定黑白棋的一个Scenario，问当前黑方可以在那些位置放棋子. 沿着上下左右两条对角线分别扫描一下。O(棋盘大小)
*/

class Tests {
    public static void main(String... args) {
        // 0: empty, 1: white, -1:black
        // -2:possible move for black, 2:possible move for white
        int[][] grid = {
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, -1, 1, 0, 0, 0},
                {0, 0, 0, 1,  1, 0, 0, 0},
                {0, 0, 0, 0,  1, -1, 0, 0},
                {0, 0, 0, 0,  1, 0, -1, 0},
                {0, 0, 0, 0,  1, 0, 0, -1}
        };
        Solution sol = new Solution();
        sol.solve(grid, -1);
        for (int[] row : grid)
            System.out.println(Arrays.toString(row));
    }
}

public class Solution {
    public void solve(int[][] grid, int color) {
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 0 && isValid(grid, i, j, color))
                    grid[i][j] = 2 * color;
            }
        }
    }

    private static final int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1}, {0, 1},
            {1, -1}, {1, 0}, {1, 1}
    };

    private boolean isValid(int[][] grid, int i, int j, int color) {
        for (int[] d : directions) {
            int x = i + d[0], y = j + d[1], rev = 0;
            while (!outside(grid, x, y)) {
                if (grid[x][y] == -color) {
                    x += d[0];
                    y += d[1];
                    rev++;
                } else break;
            }
            if (!outside(grid, x, y) && rev > 0 && grid[x][y] == color)
                return true;
        }
        return false;
    }

    private boolean outside(int[][] grid, int i, int j) {
        return i < 0 || j < 0 || i >= grid.length || j >= grid[0].length;
    }
}
