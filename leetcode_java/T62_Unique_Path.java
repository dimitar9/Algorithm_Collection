public class Solution {
    public int uniquePaths(int m, int n) {
        if(m<=0) return 0;
        if(n<=0) return 0;
        int[][] res = new int[m][n];
        for(int i=0;i<m;i++){
            res[i][0]=1;
        }
        for(int j=0;j<n;j++){
            res[0][j]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                res[i][j]=res[i][j-1]+res[i-1][j];
            }
        }
        return res[m-1][n-1];
    }
}
