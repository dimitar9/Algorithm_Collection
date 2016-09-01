/*
37. Define “X-Straight” as X cards with consecutive numbers (X >= 3).
Determine if the deck can be fully divided into sets of “X-Straight”.
*/
// assuming number on the card is 1 to 13
public class Solution {
    public static final int m = 13;

    public static void main(String... args) {
        Solution sol = new Solution();
        int[] cards;

        // Positive tests
        cards = new int[]{1, 1, 2, 2, 3, 3};
        System.out.println(sol.isXStraights(cards)); // true
        cards = new int[]{1, 2, 2, 3, 3, 4, 4, 5, 5, 6};
        System.out.println(sol.isXStraights(cards)); // true
        cards = new int[]{1, 2, 2, 3, 3, 4, 4, 4, 5, 5, 6};
        System.out.println(sol.isXStraights(cards)); // true

        // Negative tests
        cards = new int[]{1, 1, 1, 1};
        System.out.println(sol.isXStraights(cards)); // false
        cards = new int[]{5, 5, 5, 4, 4, 3, 3};
        System.out.println(sol.isXStraights(cards)); // false
        cards = new int[]{1, 1, 1, 2};
        System.out.println(sol.isXStraights(cards)); // false
        cards = new int[]{1, 3, 3, 4, 4, 5, 5, 6, 6};
        System.out.println(sol.isXStraights(cards)); // false
        cards = new int[]{3, 3, 4, 4, 5, 5, 6, 6, 13};
        System.out.println(sol.isXStraights(cards)); // false
    }

    public boolean isXStraights(int[] cards) {
        int[] count = new int[m + 2];
        for (int card : cards) count[card]++;

        int[] head = new int[m + 2];
        head[1] = count[1];
        for (int i = 2; i < m + 2; ++i) {
            head[i] = Math.max(0, count[i] - count[i - 1]);
            if (count[i] < head[i - 1] + head[i - 2])
                return false;
        }
        return true;
    }
}
