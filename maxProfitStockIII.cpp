class Solution {
public:
    int maxProfit(vector<int> &prices) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if(prices.size() <= 1)
            return 0;
            
        //stores the max profit in [0, ... , i] subarray in prices
        vector<int> maxEndWith;
        {//build the maxEndWith.
            int lowest = prices[0];
            int maxprofit = 0;
            maxEndWith.push_back(0);
            for(int i = 1; i < prices.size(); ++i) {
                int profit = prices[i] - lowest;
                if(profit > maxprofit) {
                    maxprofit = profit;
                }
                maxEndWith.push_back(maxprofit);
                if(prices[i] < lowest) lowest = prices[i];
            }
        }
        
        int ret = maxEndWith[prices.size() - 1];
        {//reverse to see what is the maxprofit of [i, ... , n-1] subarray in prices
        //and meanwhile calculate the final result
            int highest = prices[prices.size() - 1];
            int maxprofit = 0;
            for(int i = prices.size() - 2; i >= 0; --i) {
                int profit = highest - prices[i];
                if(profit > maxprofit)  maxprofit = profit;
                int finalprofit = maxprofit + maxEndWith[i];
                if(finalprofit > ret) ret = finalprofit;
                if(prices[i] > highest) highest = prices[i];
            }
        }
return ret;
    }
};


Input: 	[2,1,4,5,2,9,7]
Output: 	10
Expected: 	11
