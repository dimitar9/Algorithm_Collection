public class Solution {
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix=new int[n][n];

        int val=1,bX,eX,bY,eY; // b = begining, e = end
        bX=bY=0;
        eX=eY=n-1;

        do{
            //  Top row
            for(int i=bX;i<=eX;i++){
                matrix[bY][i]=val++;
            }
            bY++;
            //  Right column
            for(int i=bY;i<=eY;i++){
                matrix[i][eX]=val++;
            }
            eX--;
            // Bottom row
            for(int i=eX;i>=bX;i--){
                matrix[eY][i]=val++;
            }
            eY--;
            // Left column
            for(int i=eY;i>=bY;i--){
                matrix[i][bX]=val++;
            }
            bX++;
        }while((bX<=eX)&&(bY<=eY));

        return matrix;
    }
}
}
