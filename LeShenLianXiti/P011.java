package 狗.练习题;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给一个 int array,找任意一个 popular number, popular number 就是出现次数大于等于 array length 的
 * 1/4 的数。 其实就是 Leetcode 169, 229 Majority Element. 第一问unsortedarray用的hashmap。
 * 第二问sortedarray用的binarysearch。
 * 
 */
public class P011_PopularNumber {
	/*
	 * intput is unsorted array, use hashtable to solve, O(N)
	 */
	public int popular1(int[] numbers) {
		int n = numbers.length;
		Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
		for (int num : numbers) {
			if (!counts.containsKey(num)) {
				counts.put(num, 0);
			}
			counts.put(num, counts.get(num) + 1);
			if (counts.get(num) > n / 4) {
				return num;
			}
		}
		return Integer.MIN_VALUE;
	}

	/*
	 * intput is unsorted array, binary search to solve, O(logN)
	 */
	public int popular2(int[] numbers) {
		int n = numbers.length;
		int[] positions = { n / 4, n / 2, 3 * n / 4 };
		for (int pos : positions) {
			int target = numbers[pos];
			int firstIndex = search(numbers, target);
			if (target == numbers[firstIndex + n / 4])
				return target;
		}
		return Integer.MIN_VALUE;
	}

	/*
	 * find first occurrence of target in numbers
	 */
	private int search(int[] numbers, int target) {
		int lo = 0;
		int hi = numbers.length - 1;
		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			if (numbers[mid] < target) {
				lo = mid + 1;
			} else {
				hi = mid;
			}
		}
		return lo;
	}

	public static void main(String[] args) {
		int[] input = { 1, 2, 5, 4, 2, 3, 4, 3, 4, 4 };
		P011_PopularNumber pn = new P011_PopularNumber();
		System.out.println(pn.popular1(input));
		Arrays.sort(input);
		System.out.println(pn.popular2(input));
	}
}
