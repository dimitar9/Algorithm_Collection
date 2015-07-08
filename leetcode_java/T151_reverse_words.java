public class Solution {
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                word.append(s.charAt(i));
            } else {
                if (word.length() > 0) {
                    result.insert(0, word.toString());
                    result.insert(0, " ");
                    word.setLength(0);
                }
            }
        }
        if (word.length() > 0) {
            result.insert(0, word.toString());
        }
        if (result.length()>0 && result.charAt(0) == ' ') {
            return result.substring(1);
        }
        return result.toString();
    }
}
