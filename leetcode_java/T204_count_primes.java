public class Solution {
    public int countPrimes(int n) {
        int res = 0;
        boolean[] used = new boolean[n];
        for (int i = 2; i <= Math.sqrt(n); i++) {
         if (!used[i]) {
            int temp = i * i;
            while (temp < n) {
                used[temp] = true;
                temp += i;
            }
        }
        }
        for (int i = 2; i < n; i++) {
        if (!used[i]) {
            res++;
        }
        }
        return res;
    }
}
