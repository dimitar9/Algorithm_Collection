/*
给了个迷宫用小球走，每次确定一个方向之后小球会一直走到碰到障碍物或者边界才会停下
如果停下的地方恰好是出口就算出去了.
0: empty, 1: wall
preprocess then dijkstra
*/

import java.util.*;

class Tests {
    public static void main(String... args) {
        int[][] grid = {
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
        };
        int si = 2, sj = 0, ei = 2, ej = 2;
        Solution sol = new Solution();
        System.out.println(sol.shortestDist(grid, si, sj, ei, ej));
    }
}

class Cell implements Comparable<Cell> {
    public int row, col, dist;

    public Cell(int row, int col, int dist) {
        this.row = row;
        this.col = col;
        this.dist = dist;
    }

    @Override
    public int compareTo(Cell that) {
        if (this.dist < that.dist) return -1;
        if (this.dist > that.dist) return +1;
        return 0;
    }
}

public class Solution {
    public int shortestDist(int[][] grid, int si, int sj, int ei, int ej) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            throw new IllegalArgumentException("Empty grid.");

        int m = grid.length, n = grid[0].length;
        int[][] left = new int[m][n], right = new int[m][n];
        int[][] up = new int[m][n], down = new int[m][n];
        findEdges(grid, left, right, up, down);


        boolean[][] visited = new boolean[m][n];
        PriorityQueue<Cell> pq = new PriorityQueue<>();
        pq.offer(new Cell(si, sj, 0));
        while (!pq.isEmpty()) {
            Cell cell = pq.poll();
            int i = cell.row, j = cell.col, dist = cell.dist;
            if (i == ei && j == ej) return cell.dist;
            if (visited[i][j]) continue;
            visited[i][j] = true;
            int l = left[i][j], r = right[i][j], u = up[i][j], d = down[i][j];
            if (l > 0 && !visited[i][j - l]) pq.offer(new Cell(i, j - l, l + dist));
            if (r > 0 && !visited[i][j + r]) pq.offer(new Cell(i, j + r, r + dist));
            if (u > 0 && !visited[i - u][j]) pq.offer(new Cell(i - u, j, u + dist));
            if (d > 0 && !visited[i + d][j]) pq.offer(new Cell(i + d, j, d + dist));
        }
        return -1;
    }

    private void findEdges(int[][] grid, int[][] left, int[][] right, int[][] up, int[][] down) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0, l = 0, r = 0; j < n; ++j) {
                if (grid[i][j] == 0) left[i][j] = l++;
                else l = 0;
                if (grid[i][n - 1 - j] == 0) right[i][n - 1 - j] = r++;
                else r = 0;
            }
        }
        for (int j = 0; j < n; ++j) {
            for (int i = 0, u = 0, d = 0; i < m; ++i) {
                if (grid[i][j] == 0) up[i][j] = u++;
                else u = 0;
                if (grid[n - 1 - i][j] == 0) down[n - 1 - i][j] = d++;
                else d = 0;
            }
        }
    }
}
