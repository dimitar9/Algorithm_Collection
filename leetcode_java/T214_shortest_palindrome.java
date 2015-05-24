public class Solution {

        private static final int R = 26;

        public String shortestPalindrome(String s) {
            if (s == null || s.length() == 0) {
                return s;
            }

            final int N = s.length();
            final int ch[][] = new int[N + 1][R];
            final Deque<Integer> candidates = new LinkedList<>();

            for(int ind = 1; ind <= N; ind++) {
                final int len = ind;
                int odds = 0;

                ch[ind][s.charAt(ind - 1) - 'a']++;
                for(int c = 0; c < ch[ind].length; c++) {
                    ch[ind][c] += ch[ind - 1][c];
                    if(ch[ind][c] % 2 == 1) {
                        odds++;
                    }
                }

                if((len % 2 == 0 && odds == 0) || (len % 2 == 1 && odds == 1)) {
                    candidates.push(ind - 1);
                }
            }

            if(candidates.size() != 0) {

                while(candidates.size() > 0) {
                    final int end = candidates.pop() + 1;
                    if(isPalindrome(s, 0, end - 1)) {
                        String rest = s.substring(end);
                        return new StringBuilder()
                                .append(rest)
                                .reverse()
                                .append(s.substring(0, end))
                                .append(rest)
                                .toString();
                    }
                }
            }
            return new StringBuilder()
                    .append(s.substring(1))
                    .reverse()
                    .append(s)
                    .toString();
        }

        private boolean isPalindrome(String s, int lo, int hi) {
            while (lo < hi) {
                if (s.charAt(lo) != s.charAt(hi)) {
                    return false;
                }
                lo++;
                hi--;
            }
            return true;
        }
    }
