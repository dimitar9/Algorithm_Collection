public class Solution {
    List al = new ArrayList<String>();
    public List<String> findMissingRanges(int[] A, int lower, int upper) {
        if (A.length==0) 
        {
            insertRange(lower,upper);
            return al;
        }
        int m = lower;
        int n = lower;
        if(m < A[0]){
            insertRange(m,A[0]-1);
            m = A[0];
            n = A[0];
        }
        for(int i = 0; i < A.length; i++){
            
            if(m == A[i]) {
                m++;n++;
            } else {
                while(m < A[i]){
                    m++;
                }
                insertRange(n, m-1);
                n=m+1;
            }
        }

        if(m<=upper){
            if(m>A[A.length-1]){
                insertRange(m,upper);
            } else if(m==A[A.length-1] && m < upper){
                insertRange(m+1,upper);
            }
        }
        return al;
    }
    void insertRange(int n, int m){
        if(m<n) return;
        if(m==n){
            al.add(Integer.valueOf(n).toString());
            
        }
        else{
            al.add(Integer.valueOf(n).toString()+ "->" + Integer.valueOf(m).toString());
        }
        
    }
}
