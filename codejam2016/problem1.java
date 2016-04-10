public class Solution {

    private static int numberBeforeSleep(int n) {
        if (n == 0) return 0;
        boolean[] seen = new boolean[10];
        int i = 0, k = 0;
        while (i < 10) {
            k += n;
            for (int x = k; x > 0; x /= 10) {
                int digit = x % 10;
                if (seen[digit]) continue;
                i++;
                seen[digit] = true;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 0; i < t; ++i) {
            int n = in.nextInt();
            int x = numberBeforeSleep(n);
            if (x == 0)
                System.out.printf("Case #%d: INSOMNIA\n", i + 1);
            else
                System.out.printf("Case #%d: %d\n", i + 1, x);
        }
    }
}
