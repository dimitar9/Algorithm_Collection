public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int i = m-1;
        int j = n-1;
        int k = m+n-1;
        while(j >= 0 || i >= 0){
            if(i<0){
                A[k--]= B[j--];
            } else if (j<0){
                A[k--] = A[i--];
            }
            else if(A[i]<=B[j]){
                A[k--] = B[j--]; 
            } else  {
                A[k--] = A[i--];
            }
        }
    }
}
