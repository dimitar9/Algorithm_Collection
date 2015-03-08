public class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0) return 0;
    
        int[] dp = new int[n+1];
        dp[n] = 1;
        if(s.charAt(n-1) != '0')    
            dp[n-1] = 1;
        else 
            dp[n-1] = 0;
        for(int i = n-2; i >=0; i--){
            if (s.charAt(i) =='0') continue;
            if(Integer.parseInt(s.substring(i,i+2)) <= 26 )
            {
                dp[i] = dp[i+1] + dp[i+2];
            } else {
                dp[i] = dp[i+1];
            }
            
        }
        return dp[0];
        
    }
}

// s:
// ___________
// |1 | 2 | 7|
// |__|___|__|
// memo:
// ______________
// |2 | 1 | 1|1 |
// |__|___|__|__|
