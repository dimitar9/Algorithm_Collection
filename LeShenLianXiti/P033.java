/*

33. 穿墙问题 给一个m*n的board，board里面存0，1，和2，分别代表： 0 - 可申通无阻 1 - 有墙阻隔，人只能穿墙才能经过 2 - 有建筑，人无法经过
给定一个点的位置和他最多能穿的墙的数量，求到他另一个指定的点的最短路径的长度。如果路径不存在，返回-1

*/

import java.util.*;

public class Solution {
    public static void main(String... args){
        Solution sol = new Solution();
        // 0: pass, 1:wall, 2:building
        int[][] board = {
                {0, 0, 0, 1, 0},
                {1, 2, 2, 2, 0},
                {1, 1, 0, 0, 0},
                {1, 2, 0, 1, 2},
                {0, 0, 0, 0, 0}
        };
        int si = 0, sj = 0;//source
        int ti = 4, tj = 4;//target
        System.out.println(sol.shortestDistance(board, 0, si, sj, ti, tj)); // -1
        System.out.println(sol.shortestDistance(board, 1, si, sj, ti, tj)); // 12
        System.out.println(sol.shortestDistance(board, 2, si, sj, ti, tj)); // 10
        System.out.println(sol.shortestDistance(board, 3, si, sj, ti, tj)); // 8

    }
    public static final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int shortestDistance(int[][] board, int quota, int si, int sj, int ti, int tj) {
        if (board == null || board.length == 0 || board[0].length == 0)
            throw new IllegalArgumentException("Empty board.");
        if (board[si][sj] == 2 || board[ti][tj] == 2)
            return -1;

        int m = board.length, n = board[0].length;
        boolean[][][] visited = new boolean[m][n][quota + 1];
        int step = 0;
        List<Cell> level = new ArrayList<>();
        level.add(new Cell(si, sj, board[si][sj]));
        visited[si][sj][board[si][sj]] = true;
        while(!level.isEmpty()) {
            step++;
            List<Cell> newLevel = new ArrayList<>();
            for (Cell cell:level) {
                for (int[] d:directions) {
                    int i = cell.row + d[0], j = cell.col + d[1];
                    if (notValid(board, i, j)) continue;
                    int k = cell.wall + board[i][j];
                    if (k > quota || visited[i][j][k]) continue;
                    if (i == ti && j == tj) return step; // reached target
                    visited[i][j][k] = true;
                    newLevel.add(new Cell(i, j, k));
                }
            }
            level = newLevel;
        }
        return -1;
    }
    private boolean notValid(int[][] board, int i, int j) {
        return i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == 2;
    }

    class Cell {
        public int row, col, wall;
        public Cell(int row, int col, int wall){
            this.row = row;
            this.col = col;
            this.wall = wall;
        }
    }
}
