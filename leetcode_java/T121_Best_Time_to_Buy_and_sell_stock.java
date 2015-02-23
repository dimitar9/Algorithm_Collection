public class Solution {
    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        if(prices.length<=1) return 0;
        Arrays.fill(dp, 0);
        int min = prices[0];
        for(int i = 1; i < prices.length; i++){
            dp[i] = Math.max(dp[i-1], prices[i]-min);
            min = Math.min(min, prices[i]);
        }
        return dp[prices.length-1];
        
        
    }
}

//DP
