public class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] row = new int[m];
        int[] col = new int[n];
        Arrays.fill(row,new Integer(1));
        Arrays.fill(col,new Integer(1));
        for(int i =0;i<m;i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j]==0){
                    row[i] = 0;
                    col[j] = 0;
                }
            }
        }
        for(int i =0;i<m;i++){
            for(int j = 0; j < n; j++){
                if((row[i] == 0) || (col[j] == 0)){
                    matrix[i][j]=0;
                }
            }
        }
        
    }
}
