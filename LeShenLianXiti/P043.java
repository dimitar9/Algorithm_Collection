package 狗.练习题;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * AA 制问题:有一题是比如有一群朋友一起出去玩,然后在外面的消费可能有些人先垫付了, 比如 ABCDE 五个人出去聚会,总共消费 150,然后 A 垫付了
 * 100,B 垫付了 50,然后大家回来之后要 AA 制结清花费, 问使得所有人平摊总消费的最少 transaction 次数,比如 C 回来之后给 A30
 * 块就算一次 transaction。
 * 
 * a. 通过 2sum,3sum...nsum 一路算下来是面试官最推荐的解法(不现实)
 * 
 * b. BFS 更好
 * 
 * c. 最多 n-1 次 transaction
 * 
 * @author LiP
 *
 */
public class P043_minimizedNumberofPaymentsAA {
	class Balance {
		int level;
		List<Integer> lender;
		List<Integer> borrower;

		Balance(int level, List<Integer> posVals, List<Integer> negVals) {
			this.level = level;
			lender = posVals;
			borrower = negVals;
		}

		public List<Balance> payOnce() {
			List<Balance> ans = new ArrayList<>();
			for (int i = 0; i < lender.size(); i++)
				for (int j = 0; j < borrower.size(); j++) {
					int pos = lender.get(i);
					int neg = borrower.get(j);
					List<Integer> newLender = new ArrayList<>(lender);
					List<Integer> newBorrower = new ArrayList<>(borrower);
					newLender.remove(i);
					newBorrower.remove(j);

					int diff = pos + neg;
					if (diff > 0)
						newLender.add(pos + neg);
					else if (diff < 0)
						newBorrower.add(pos + neg);

					ans.add(new Balance(level + 1, newLender, newBorrower));
				}
			return ans;
		}

		public boolean balanced() {
			return lender.isEmpty() && borrower.isEmpty();
		}

		public String toString() {
			return borrower.toString() + ", " + lender.toString()
					+ ", # of payments: " + level;
		}
	}

	public int pay(int[] paid) {
		int n = paid.length;
		long total = 0;
		for (int amount : paid) {
			total += amount;
		}
		if (total % n != 0)
			throw new IllegalArgumentException(
					"Total amount can not be evenly divided.");
		int avg = (int) total / n;

		List<Integer> pos = new ArrayList<>();
		List<Integer> neg = new ArrayList<>();
		for (int amount : paid) {
			int diff = amount - avg;
			if (diff > 0)
				pos.add(diff);
			else if (diff < 0)
				neg.add(diff);
		}

		Balance initialBalance = new Balance(0, pos, neg);
		Queue<Balance> queue = new LinkedList<>();
		queue.offer(initialBalance);
		int ans = Integer.MAX_VALUE;
		while (true) {
			Balance cur = queue.poll();
			System.out.println(cur);
			if (cur.balanced()) {
				ans = cur.level;
				break;
			}
			List<Balance> nextLevel = cur.payOnce();
			for (Balance newBalance : nextLevel)
				queue.offer(newBalance);
		}

		return ans;
	}

	public static void main(String[] args) {
		int[] paid = new int[] { 1, 2, 3, 6, 8 };
		int[] paid1 = new int[] { 14, 2, 1, 13, 0, 3, 9 };

		P043_minimizedNumberofPaymentsAA mnpaa = new P043_minimizedNumberofPaymentsAA();
		System.out.println(mnpaa.pay(paid)); // 3
		System.out.println(mnpaa.pay(paid1)); // 5
	}
}
/*


wrap long lines

lzb700m Aug 6th at 3:25 PM

AA制还钱问题的最暴力解法...

Adrian Yang Aug 9th at 11:29 PM

AA还钱的，设一共n个人，m个人出了足额的钱，剩下的没出。那么最优策略下，最多transaction：n－m个人分别转给m个人中的一个，然后他再匀给其他。特殊情况：n个人中，有若干出的钱是每人AA应付钱的倍数。所以，解是n - 1 - (付款是应付数目的倍数的人的个数) 或 n - m + (付款不是应付数目的倍数的人的个数)

lzb700m Aug 10th at 12:30 AM

你是再说怎么还钱是最优的策略吗？能举个例子吗

Shawn Zhou Aug 14th at 5:23 AM

试试这个input  int[] paid = new int[] {14, 2, 1, 13, 0, 3, 9};

Shawn Zhou Aug 14th at 5:24 AM

你的程序跑出的是4  但我觉得好像最少也要5次？

lzb700m Aug 16th at 10:31 AM

@stupidbird911: 你说的对，我的程序有bug，现在已经改过来了。多谢指正。

Shawn Zhou Aug 16th at 5:15 PM

刚看了你的代码 :+1:一个  我这题用ksum写的 我觉得bfs并不比ksum更好。一个是bfs空间消耗大太多指数级别? ksum只需O(n) 另一个是 这个问题应该本来就是NPC，ksum不需要写成2sum 3sum... 只需要写一个函数take input k as an argument, 然后把k sum成0的index删掉就好  最后是这个问题的解法应该也是尽可能group k内部zero out，k越小越好，写ksum更直接直观。仅个人观点欢迎指正
*/
