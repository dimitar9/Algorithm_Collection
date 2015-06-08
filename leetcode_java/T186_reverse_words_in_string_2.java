public class Solution {
public void reverseWords(char[] s) {
    // Three step to reverse
    // 1, reverse the whole sentence
    reverse(s, 0, s.length - 1);
    // 2, reverse each word
    int start = 0;
    int end = -1;
    for (int i = 0; i < s.length; i++) {
        if (s[i] == ' ') {
            reverse(s, start, i - 1);
            start = i + 1;
        }
    }
    // 3, reverse the last word, if there is only one word this will solve the corner case
    reverse(s, start, s.length - 1);
}

public void reverse(char[] s, int start, int end) {
    while (start < end) {
        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;
        start++;
        end--;
    }
}


}
