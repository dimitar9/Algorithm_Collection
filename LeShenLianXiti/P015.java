/*
Continental Divide
具体题目如下：
   ~  ~  ~  ~  ~
~  1  2  2  3 (5) *
~  3  2  3 (4)(4) *
~  2  4 (5) 3  1  *
~ (6)(7) 1  4  5  *
~ (5) 1  1  2  4  *
   *  *  *  *  *
给定一个grid，判断是否有点即能到达~,也能到达*。

*/

import java.util.*;

public class BFSTests {
    public static void main(String... args) {
        BFSSolution sol = new BFSSolution();
        int[][] matrix = new int[][]{
                {1, 2, 3, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4},
        };
        int[][] ans = sol.solve(matrix);
        for (int[] row : ans)
            System.out.println(Arrays.toString(row));
    }
}

class BFSSolution {
    public static final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int[][] solve(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            throw new IllegalArgumentException();
        int m = matrix.length, n = matrix[0].length;
        int[][] pacific = flow(matrix, 0, 0, m, n);
        int[][] atlantic = flow(matrix, n - 1, m - 1, m, n);
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                atlantic[i][j] |= pacific[i][j] << 1;
        return atlantic;
    }

    private int[][] flow(int[][] matrix, int col, int row, int m, int n) {
        int[][] ans = new int[m][n];
        Deque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; ++i) {
            queue.offer(new int[]{i, col});
            ans[i][col] = 1;
        }
        for (int j = 0; j < n; ++j) {
            queue.offer(new int[]{row, j});
            ans[row][j] = 1;
        }
        bfs(ans, queue, matrix, m, n);
        return ans;
    }

    private void bfs(int[][] ans, Deque<int[]> queue, int[][] matrix, int m, int n) {
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int bar = matrix[point[0]][point[1]];
            for (int[] d : directions) {
                int x = point[0] + d[0], y = point[1] + d[1];
                if (x < 0 || y < 0 || x == m || y == n
                        || ans[x][y] > 0 || matrix[x][y] < bar) continue;
                ans[x][y] = 1;
                queue.offer(new int[]{x, y});
            }
        }
    }
}
