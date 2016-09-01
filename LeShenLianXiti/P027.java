/*
第二题就是给你一个string,你返回remove最少数量的character之后形成的palindrome
*/

public class Solution {
    public int minRemoval(String s) {
        int n = s.length();
        int[][] min = new int[n][n + 1]; // start, len
        for (int len = 2; len <= n; ++len) {
            for (int i = 0; i + len <= n; ++i) {
                if (s.charAt(i) == s.charAt(i + len - 1)) min[i][len] = min[i + 1][len - 2];
                else min[i][len] = Math.min(min[i][len - 1], min[i + 1][len - 1]) + 1;
            }
        }
        return min[0][n];
    }
}

///follow up，合法的edit包括add, delete and replace
package 狗.练习题;
//by lzb700m

/**
 * In this problem you are asked to convert a string into a palindrome with
 * minimum number of operations. The operations are described below: Here you’d
 * have the ultimate freedom. You are allowed to:
 * 
 * • Add any character at any position
 * 
 * • Remove any character from any position
 * 
 * • Replace any character at any position with another character
 * 
 * Every operation you do on the string would count for a unit cost. You’d have
 * to keep that as low as possible.
 * 
 * For example, to convert “abccda” you would need at least two operations if we
 * allowed you only to add characters. But when you have the option to replace
 * any character you can do it with only one operation. We hope you’d be able to
 * use this feature to your advantage.
 * 
 * @author LiP
 *
 */
public class P027_PalindromeEditDistance {

	public int minEditPalindrome(String s) {
		int n = s.length();
		// dp[i][j] min edit distance for substring s.substring(i, j + 1)
		int[][] dp = new int[n][n];

		for (int i = 0; i + 1 < n; i++)
			if (s.charAt(i) != s.charAt(i + 1))
				dp[i][i + 1] = 1;

		for (int k = 3; k <= n; k++) { // k - length of substring
			for (int i = 0; i + k - 1 < n; i++) {
				int j = i + k - 1;
				if (s.charAt(i) == s.charAt(j))
					dp[i][j] = dp[i + 1][j - 1];
				else {
					dp[i][j] = Math.min(dp[i + 1][j - 1],
							Math.min(dp[i][j - 1], dp[i + 1][j])) + 1;
				}
			}
		}

		return dp[0][n - 1];
	}

	public static void main(String[] args) {
		P027_PalindromeEditDistance ped = new P027_PalindromeEditDistance();
		System.out.println(ped.minEditPalindrome("abccda")); // expected 1
		System.out.println(ped.minEditPalindrome("tanbirahmed")); // expected 5
		System.out.println(ped.minEditPalindrome("shahriarmanzoor"));// expected
																		// 7
		System.out.println(ped.minEditPalindrome("monirulhasan"));// expected 6
		System.out.println(ped.minEditPalindrome("syedmonowarhossain"));// expected
																		// 8
		System.out.println(ped.minEditPalindrome("sadrulhabibchowdhury"));// expected
																			// 8
		System.out.println(ped.minEditPalindrome("mohammadsajjadhossain"));// expected
																			// 8
	}
}
