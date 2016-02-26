import java.util.Arrays;


public class LIS {
    public static int lengthOfLIS(int[] nums) {            
        int[] dp = new int[nums.length];
        int len = 0;

        for(int x : nums) {
        	System.out.println("processing x: " + x);
            int i = Arrays.binarySearch(dp, 0, len, x);
            System.out.println(" i is:" + i);
            if(i < 0) i = -(i + 1);
            dp[i] = x;
            if(i == len) len++;
            System.out.println("len ++ , len is:" + len);
        }

        return len;
    }
    public static void main(String[] args){
    	int[] nums = {3,4,-1,3,5,3,8,10};
    	lengthOfLIS(nums);
    }
}
