public class Solution {
    public void sortColors(int[] A) {
        int len = A.length;
        int r = 0;
        int w = 0;
        int b = len-1;
        while(w<=b){
            switch( A[w]){
            case 0:
                int tmp = A[r];
                A[r]=A[w];
                A[w]=tmp;
                r++;w++;
                break;
            case 1:
                w++;
                break;
            case 2:
                tmp = A[w];
                A[w]=A[b];
                A[b]=tmp;
                b--;
                break;
            }
        }
        
    }
}
