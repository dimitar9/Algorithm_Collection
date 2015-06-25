public class Solution {
public int lengthOfLastWord(String s) {
    if (s == null || s == "") {
        return 0;
    }
    s = s.trim();

    int index = s.lastIndexOf(' ');
    if (index < 0) {
        return  s.length();
    } else {
        String sub = s.substring(index + 1);
        return sub.length();
    }
}


}
