class Solution {
public:
    bool canJump(int A[], int n) {
        for(int i=0;i<n-1;i++){
            if((A[i+1] >= A[i]) && (A[i]>0))
                continue;
            else{
                A[i+1]=A[i]-1;
            }
        }
        return (A[n-1]>=0);
        
    }
};
