// 1 swap elements agains diagonal
// 2 swap agains midle column

public class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        if(m==0) return;
        int n = matrix[0].length;
        for(int i = 0; i < m-1; i ++){
            for(int j = i+1; j<n; j++ ){
                int tmp = matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=tmp;
            }
        }
        for(int j = 0; j < n/2; j ++){
            for(int i = 0; i<m; i++ ){
                int tmp = matrix[i][j];
                matrix[i][j]=matrix[i][n-j-1];
                matrix[i][n-j-1]=tmp;
            }
        }
    }
}
