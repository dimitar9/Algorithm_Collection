/*
3. (面经中看到多次)给一个string 比如aaabb，
重新排列这个string的character让相同的character不相邻

follow up 相同的character相距至少为k (已解决，用heap+queue)
a. 另一种问法：给一个String[] array, 和任意一个移动的window size k，
对array里的元素位置进行改变，使得window里的元素不重复. 要efficient的解法。

相距定义为 j - i >= k
*/

import java.util.*;

public class Solution {
    public static void main(String... args) {
        Solution sol = new Solution();
        System.out.println(sol.kInterleave("aaabb", 2));
    }

    public String kInterleave(String s, int k) {
        if (k <= 1) return s;
        PriorityQueue<Tuple> live = new PriorityQueue<>();
        Queue<Tuple> dead = new ArrayDeque<>();
        int[] count = new int[128];
        for (char ch : s.toCharArray()) count[ch]++;
        for (int i = 0; i < count.length; ++i)
            if (count[i] > 0)
                live.offer(new Tuple((char) (i), count[i], 0));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            if (!dead.isEmpty() && dead.peek().revIdx == i)
                live.offer(dead.poll());
            if (live.isEmpty()) throw new IllegalArgumentException("Can not rearrange.");
            Tuple t = live.poll();
            sb.append(t.ch);
            if (--t.count > 0) {
                t.revIdx = i + k;
                dead.offer(t);
            }
        }
        return sb.toString();
    }

    class Tuple implements Comparable<Tuple> {
        public int count;
        public int revIdx;
        public char ch;

        public Tuple(char ch, int count, int revIdx) {
            this.count = count;
            this.revIdx = revIdx;
            this.ch = ch;
        }

        @Override
        public int compareTo(Tuple that) {
            return that.count - this.count;
        }
    }
}
