public class Solution {
StringBuilder longest = new StringBuilder("");

public String longestPalindrome(String s) {
    if (s.length() <= 1) return s;

    for (int i = 0; i < s.length(); i++) {
        expand(s, longest, i, i); //odd
        expand(s, longest, i, i + 1); //even
    }

    return longest.toString();
}

private void expand(String s, StringBuilder longest, int i, int j) {
    while (i >= 0 && j < s.length()) {
        if (s.charAt(i) == s.charAt(j)) {
            if (j - i + 1 > longest.length()) {
                longest.delete(0, longest.length());
                longest.append(s.substring(i, j + 1));
            }
            i--;
            j++;
        }
        else
            break;
    }
}

}
