public class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length(), longest = 0;
        Stack<Integer> st = new Stack<Integer>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') st.push(i);
            else {
                if (!st.isEmpty()) {
                    if (s.charAt(st.peek()) == '(') st.pop();
                    else st.push(i);
                }
                else st.push(i);
            }
        }
        if (st.isEmpty()) longest = n;
        else {
            int a = n, b = 0;
            while (!st.isEmpty()) {
                b = st.pop();
                longest = Math.max(longest, a-b-1);
                a = b;
            }
            longest = Math.max(longest, a);
        }
        return longest;
    }
}
