/*
Find the point where maximum intervals overlap
Consider a big party where a log register for guest’s entry and exit times is maintained. 
Find the time at which there are maximum guests in the party. Note that entries in register are not in any order.

Example:

Input: arrl[] = {1, 2, 9, 5, 5}
       exit[] = {4, 5, 12, 9, 12}
First guest in array arrives at 1 and leaves at 4, 
second guest arrives at 2 and leaves at 5, and so on.

Output: 5
There are maximum 3 guests at time 5.  
*/
import java.util.*;

public class Solution {
    public static void main(String... args) {
        Solution sol = new Solution();
        int[] arrl = {1, 2, 9, 5, 5};
        int[] exit = {4, 5, 12, 9, 12};
        int[] ans = sol.maxGuests(arrl, exit);
        System.out.printf("There are maximum %d guests at time %d.\n", ans[0], ans[1]);
    }

    // sweep line algorithm
    public int[] maxGuests(int[] arrl, int[] exit) {
        Arrays.sort(arrl);
        Arrays.sort(exit);
        int guests = 0, maxGuests = 0, time = 0, n = arrl.length;
        for (int i = 0, j = 0; i < n; ++i) {
            while (j < n && exit[j] < arrl[i]) {
                j++;
                guests--;
            }
            guests++;
            if (maxGuests < guests) {
                maxGuests = guests;
                time = arrl[i];
            }
        }
        return new int[]{maxGuests, time};
    }
}
