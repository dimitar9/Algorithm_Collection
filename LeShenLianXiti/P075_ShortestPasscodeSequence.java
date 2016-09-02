package 狗.练习题;

import java.util.Arrays;

/**
 * 一堆密码箱,每个密码都是四位 0-9 之间,算一个暴力破解序列,包含所有可能的四位序列,让这个序列 尽量短,给了一个贪心算法,代码写的比较长,而且没
 * bug free
 * 
 * 然后出了道 4 位 passcode 破解最短序列题
 * 
 * 密码箱,每个密码都是四位 0-9 之间,算一个暴力破解序列,包含所有可能的四位序列,让这个序列尽量 短 没有找出最佳解法
 * 
 * @author LiP
 *
 */
public class P075_ShortestPasscodeSequence {
	/*
	 * https://en.wikipedia.org/wiki/De_Bruijn_sequence
	 */
	public String shortestPasscodeSequence(int len, int[] digits) {
		StringBuilder ans = new StringBuilder();
		Arrays.sort(digits);
		for (int i = 0; i < len; i++)
			ans.append(digits[digits.length - 1]); // "9999" to start with
		int sequenceLength = (int) Math.pow(digits.length, len) + (len - 1);
		for (int i = len; i < sequenceLength; i++) {
			String suffix = ans.substring(i - len + 1);
			for (int digit : digits) {
				if (ans.indexOf(suffix + digit) == -1) {
					ans.append(digit);
					break;
				}
			}
		}
		return ans.toString();
	}

	public static void main(String[] args) {
		P075_ShortestPasscodeSequence sps = new P075_ShortestPasscodeSequence();
		String ans = sps.shortestPasscodeSequence(2, new int[] { 0, 1 });
		System.out.println(ans.length() + ", " + ans); // expected 5
		ans = sps.shortestPasscodeSequence(3, new int[] { 0, 1, 3 });
		System.out.println(ans.length() + ", " + ans);
		ans = sps.shortestPasscodeSequence(4, new int[] { 0, 1, 2, 3, 4, 5, 6,
				7, 8, 9 }); // expected 10003
		System.out.println(ans.length() + ", " + ans);
	}
}
