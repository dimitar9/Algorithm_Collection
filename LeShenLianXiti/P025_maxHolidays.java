/*

25. 给N个office，以及每个月office的假期，还有office 之间的adjacent matrix 问该如何变换office才能最大化假期
有几座城市，每个月在每个城市都有不同的假期，然后每个城市有飞往不同城市的航班，求最大能获取的假期和

follow
Path
*/

import java.util.*;

public class Solution {

    // monthes from 0 to 11, and we are at 0 city in month 0
    // n cities and 12 monthes
    public static final int m = 12;

    public int maxHolidays(int[][] flights, int[][] holidays, int n, int limit, int[] path) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; ++j)
                if (i == j) row.add(i); // you can always stay in the same city for another week
                else if (flights[i][j] <= limit) row.add(j); // from i to j
            adj.add(row);
        }

        int[] max = new int[n]; // max[t][i] is the max holidays we can get for stay in i city in week t;
        int[][] parent = new int[m][n]; // parent[t][i] is the from city of max[t][i]
        Arrays.fill(max, -1);
        max[0] = holidays[0][0];
        for (int t = 0; t < m - 1; ++t) {
            int[] next = new int[n];
            for (int i = 0; i < n; ++i) {
                if (max[i] < 0) continue;
                for (int j : adj.get(i)) {
                    if (next[j] < max[i] + holidays[t + 1][j]) {
                        next[j] = max[i] + holidays[t + 1][j];
                        parent[t + 1][j] = i;
                    }
                }
            }
            max = next;
        }
        int city = 0;
        for (int i = 1; i < n; ++i) if (max[i] > max[city]) city = i;

        path[m - 1] = city;
        for (int t = m - 1; t > 0; --t) path[t - 1] = parent[t][path[t]];
        return max[city];
    }

    public static void main(String... args) {
        int n = 3, limit = 2;
        int[][] flights = {
                {0, 2, 3},
                {1, 0, 3},
                {1, 2, 0}
        };
        int[][] holidays = {
                {1, 1, 1},
                {2, 1, 1},
                {3, 1, 1},
                {4, 1, 1},
                {5, 1, 1},
                {6, 100, 200},
                {7, 1, 1},
                {8, 1, 1},
                {9, 1, 1},
                {10, 1, 1},
                {11, 1, 1},
                {12, 1, 1}
        };
        int[] path = new int[m];
        Solution sol = new Solution();
        int ans = sol.maxHolidays(flights, holidays, n, limit, path);
        System.out.println(Arrays.toString(path));
        System.out.println(ans);
    }
}
