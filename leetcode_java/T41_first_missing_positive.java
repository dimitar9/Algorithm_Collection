public class Solution {
    public int firstMissingPositive(int[] A) {
        int[] arr = new int[A.length];
        Arrays.fill(arr,new Integer(-1));
        int len = A.length;
        for(int i = 0; i < A.length; i++){
            if(0<A[i] && A[i]<=len){
                arr[A[i]-1]=1;
            }
        }
        for(int i = 0; i < A.length; i++){
            if(arr[i]!=1){
                return i+1;
            }
        }
        return len+1;
        
    }
}
