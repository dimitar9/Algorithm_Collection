package 狗.练习题;

/**
 * 有一列袋子,袋子上标有内含的硬币价值,两个人轮流取,只能取头和尾的袋子, 看谁最后能取到的总价值最大,然后程序是计算作为先手玩家最大能取多少
 * 
 * @author LiP
 *
 */
public class P020_CoinGame {
	/*
	 * return the maximum profit for the first player
	 */
	public int maxProfit(int[] coins) {
		int n = coins.length;
		int[][] dp = new int[n][n];

		// initialization
		for (int i = 0; i < n; i++) {
			// best strategy for one coin is to take it
			dp[i][i] = coins[i];
		}

		for (int i = 0; i + 1 < n; i++) {
			// best strategy for two coins is to take the larger one
			dp[i][i + 1] = Math.max(coins[i], coins[i + 1]);
		}

		for (int k = 3; k <= n; k++) {
			// k is length of sequence we check
			for (int i = 0; i + k - 1 < n; i++) {
				int j = i + k - 1;
				int takeFirst = coins[i]
						+ Math.min(dp[i + 2][j], dp[i + 1][j - 1]);
				int takeLast = coins[j]
						+ Math.min(dp[i][j - 2], dp[i + 1][j - 1]);
				dp[i][j] = Math.max(takeFirst, takeLast);
			}
		}

		return dp[0][n - 1];
	}

	public static void main(String[] args) {
		int[] coins1 = { 1, 2, 100, 4 };
		int[] coins2 = { 5, 8, 2, 4, 10 };
		P020_CoinGame cg = new P020_CoinGame();
		System.out.println(cg.maxProfit(coins1)); // expected 101 [1, 100]
		System.out.println(cg.maxProfit(coins2)); // expected 17 [10, 5, 2]
	}
}
