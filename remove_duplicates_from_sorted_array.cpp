class Solution {
public:
    int removeDuplicates(int A[], int n) {
        if (n==0) return 0;
        if(n==1) return 1;
        int i = 0;
        int j = 1;
        while((i<n) && (j<n)){
            
            if (A[i]!=A[j]){
                A[++i] = A[j++];
            }
            else {
                j++;
            }
        }
        return i+1;
        
    }
};
