

class Solution {
public:
    int maxSubArray(int A[], int n) {
        int max_sum = INT_MIN; //SO EASY TO MAKE MISTAKE DON'T INIT IT AS 0, IT IS WRONG>
        int sum = 0;
        for(int i=0;i<n;i++){
            sum = sum > 0 ? sum+A[i]:A[i];
            max_sum = max (max_sum, sum);
        }
        return max_sum;
        
    }
};
