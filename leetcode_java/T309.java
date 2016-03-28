public class Solution {
// best time to buy and sell stock with cooldown.
// profit1: max profit if sell on day i.
// profit2: max profit if do nothing on day i
    public int maxProfit(int[] prices) {

        int profit1 = 0;

        int profit2 = 0;

        int tmp = 0;

        for(int i = 1; i < prices.length; i++){

            tmp = profit1;

            profit1 = Math.max(profit1 - prices[i-1] + prices[i], profit2);

            profit2 = Math.max(tmp, profit2);

        }

        return Math.max(profit1, profit2);

    }

}
