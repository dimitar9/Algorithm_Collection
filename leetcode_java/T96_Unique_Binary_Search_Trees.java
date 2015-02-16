
public class Ｔ96 {
	   public static int numTrees(int n) {
	        int[]dp = new int[n+1];
	        if ((n==1) || (n==0)) {
	        	return 1;
	        }
	        dp[0]=dp[1]=1;
	        for(int i = 2; i<=n; i++ ){
	        	dp[i] = 0;
	        	for(int j = 1; j <=i; j++){
	        		dp[i] += dp[j-1] * dp[i-j];
	        	}
	        }
	        return dp[n];
	   }
	   
	   public static void main(String[] args){
		   System.out.println(numTrees(3));
	   }
}
