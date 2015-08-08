public class Solution {
    public boolean isStrobogrammatic(String num) {
        if (num == null) 
            return false;

        return helper(num, 0, num.length() - 1);
    }

    boolean helper(String num, int lo, int hi) {
        if (lo > hi) 
            return true;

        char c1 = num.charAt(lo), c2 = num.charAt(hi);

        int mul = (c1 - '0') * (c2 - '0');

        if (mul == 1 || mul == 64 || mul == 54 || (mul == 0 && c1 == c2))
            return helper(num, lo + 1, hi - 1);
        else
            return false;
    }
}
