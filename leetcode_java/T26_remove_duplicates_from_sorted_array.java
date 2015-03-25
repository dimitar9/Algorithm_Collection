class Solution {
public:
    int removeDuplicates(int A[], int n) {
        if(n<=1) return n;
        int prev = A[0];
        A[0] = A[0];
        int len = 1;
        
        for(int i=1, j=1; i < n; i++){
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
};
