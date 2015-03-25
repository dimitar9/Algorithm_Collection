public class Solution {
    public int removeDuplicates(int[] A) {
        if(A.length<=1) return A.length;
        int prev = A[0];
       // A[0] = A[0];
        int len = 1;
        
        for(int i=1, j=1; i < A.length; i++){
            if(A[i] == prev){
                continue;
            } else {
                prev = A[i];
                A[j++]=A[i];
                len++;
            }
            
        }
        return len;
    }
}
