public class Solution {
    public int maxSubArray(int[] A) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < A.length;i++){
            if(sum<=0){
                sum = A[i];
            } else {
                sum = sum + A[i];
            }
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
        
    }
}
