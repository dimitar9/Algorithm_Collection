public class Solution {
    public int rob(int[] num) {
    
    int le = num.length;
    if(le==0) return 0;
    else if (le==1) return num[0];
    else if (le==2) return Math.max(num[0],num[1]);
        
    int[][] dp = new int[num.length + 1][2];
    
    for (int i = 1; i <= num.length-1; i++) {
        dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
        dp[i][1] = num[i - 1] + dp[i - 1][0];
    }
    int ret1 =  Math.max(dp[num.length-1][0], dp[num.length-1][1]);

    int[][] dp2 = new int[num.length + 1][2];
    
    for (int i = 2; i <= num.length; i++) {
        dp2[i][0] = Math.max(dp2[i - 1][0], dp2[i - 1][1]);
        dp2[i][1] = num[i - 1] + dp2[i - 1][0];
    }
    int ret2 =  Math.max(dp2[num.length][0], dp2[num.length][1]);
    return Math.max(ret1, ret2);

    }

}


//[2 1 1 1]
