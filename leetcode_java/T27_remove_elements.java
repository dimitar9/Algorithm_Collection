public class Solution {
    public int removeElement(int[] A, int elem) {
        if(A.length==0) return A.length;
        int len = 0;
        for(int i = 0, j = 0; i < A.length; i++){
            if(A[i]!=elem){
                A[j++]=A[i];
                len++;
            }
        }
        return len;
        
    }
}
