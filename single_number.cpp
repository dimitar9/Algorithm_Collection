class Solution {
public:
    int singleNumber(int A[], int n) {
        
        for (int i=1;i<n;i++){
            A[0] = A[0] ^ A[i];
        }
        return A[0];
    }
};
