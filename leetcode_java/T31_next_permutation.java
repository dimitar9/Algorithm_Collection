Similar Solution, a bit fewer lines of code. Three steps:

    Reverse find first number which breaks descending order.
    Exchange this number with the least number that's greater than this number.

    Reverse sort the numbers after the exchanged number.

        public class Solution {
                public static void nextPermutation(int[] num) {
                    int i = num.length - 2;
                    for(; i >= 0 && num[i] >= num[i+1]; i--) 
                        ;

                    if(i >= 0) {
                        int j = i + 1;
                        for(; j<num.length && num[i] < num[j]; j++) 
                            ;
                        exchange(num, i, j-1);
                    }

                    i ++ ; 
                    int k = num.length - 1;
                    for(; i<k; i++, k--)
                        exchange(num, i, k);
                }

                private static void exchange(int[] num, int i, int j) {
                    int t = num[i];
                    num[i] = num[j];
                    num[j] = t;
                }
            }

