//Use method 2.
/*#CC150 #CC150-chap1 Implement a method to perform basic string compression 
using the counts of repeated characters. For example, the string aabcccccaaa 
would become a2blc5a3. If the "compressed" string would not become smaller
than the original string, your method should return the original string.*/
public class CompressString {

	public static void main(String args[]) {
		System.out.println(compressString("abc"));
		System.out.println(compressString("aabc"));
		System.out.println(compressString("aabcccccaaa"));
	}

	/**
	 * Solution: Go through each character in the input string, compare it with
	 * the previous one, count the frequency and store in the result. Return the
	 * original string if the result length is no smaller than the length of the
	 * original string.
	 * 
	 * Time Complexity: O(n), Space Complexity: O(n)
	 * 
	 * @param input
	 * @return
	 */
	public static String compressString(String input) {
		// Optimization: if the length is no larger than 3 then we can't
		// compress it
		if (input == null || input.isEmpty() || input.length() <= 2) {
			return input;
		}
		// Count the frequency of this char
		char last = input.charAt(0);
		// Freq count of the last char
		int count = 1;
		// Use StringBuilder or StringBuffer time is O(n+k) where k is the
		// number of distinct char we
		// encounter (k<=n). If we use string, the time
		// complexity is O(n +k^2) makes O(n^2) time.
		StringBuilder result = new StringBuilder();
		for (int i = 1; i < input.length(); i++) {
			// Compare each character with the previous one and save the count
			if (input.charAt(i) == last) {
				count += 1;
			} else {
				// Encountered a different char, append it to the result
				result.append(last).append(count);
				last = input.charAt(i);
				count = 1;
				// If it cannot be compressed, means the result length is no
				// smaller
				// than the input, return the original input string
				if (result.length() >= input.length()) {
					return input;
				}
			}
		}
		// Don't forget the last pair
		result.append(last).append(count);

		return result.length() >= input.length() ? input : result.toString();
	}

	// --------------- Solution 2 -----------------------------------------//
	/**
	 * Method2: instead of checking the length at the end, scan first to check
	 * if the input string can be compressed. If the string cannot be
	 * compressed, saves space O(N) time, O(N) space, otherwise it uses an extra
	 * O(N) time
	 */
	public static String compressString2(String input) {
		if (input == null || input.isEmpty() || input.length() <= 2) {
			return input;
		}

		// First check if compression generates a longer string, get the length
		// of the compressed string
		int size = countCompression(input);
		if (size < input.length()) {
			// The others are the same as the other solution
			// The character of interest, we are counting its frequency
			char c = input.charAt(0);
			int count = 1;
			StringBuilder result = new StringBuilder();
			for (int i = 1; i < input.length(); i++) {
				if (input.charAt(i) == c) {
					count += 1;
				} else {
					result.append(c).append(count);
					c = input.charAt(i);
					count = 1;
				}
			}
			result.append(c).append(count);
			return result.toString();
		}
		return input;
	}

	public static int countCompression(String input) {
		int size = 0;
		char last = input.charAt(0);
		int count = 1;
		for (int i = 1; i < input.length(); i++) {
			if (input.charAt(i) == last) {
				count++;
			} else {
				last = input.charAt(i);
				count = 1;
				// 1 for the char, then add the number of digits of the int
				size += 1 + String.valueOf(count).length();
			}
		}
		// Don't forget the last one
		size += 1 + String.valueOf(count).length();
		return size;
	}

	// --------------- Solution 3 -----------------------------------------//

	/**
	 * Method3: Scan first to get the compressed length, if smaller than
	 * original str, use a char array of the compressed length to store the
	 * result.
	 * 
	 * O(N) time, O(N) space
	 */

	public static String compressStringWithCharArray(String input) {
		if (input == null || input.isEmpty() || input.length() <= 2) {
			return input;
		}

		// First check if compression generates a longer string, get the length
		// of the compressed string
		int size = countCompression(input);
		if (size >= input.length()) {
			return input;
		}
		char[] result = new char[size];
		char last = input.charAt(0);
		int count = 1;
		int index = 0;// where we are at in the result char array
		for (int i = 1; i < input.length(); i++) {
			if (input.charAt(i) == last) {
				count++;
			} else {
				last = input.charAt(i);
				count = 1;
				index = setChar(result, last, index, count);
			}
		}

		return new String(result);

	}

	// Put the char and the int as a char array at the right place in the char
	// array
	private static int setChar(char[] array, char c, int index, int count) {
		array[index++] = c;
		// convert the int count into a char array
		char[] countAsChars = String.valueOf(count).toCharArray();
		// copy the characters
		for (char digit : countAsChars) {
			array[index++] = digit;
		}
		return index;
	}

}
