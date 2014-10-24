class Solution {
public:
    int res;
      
    bool isValid(int A[], int r){
        for (int i=0;i<r;i++){
            if ( (A[i]==A[r])||(abs(A[i]-A[r])==(r-i))){
                return false;
            }
        }
        return true;
    }
    void nqueens(int A[], int cur, int n){
        if (cur==n){ res++;return;}
        else{
            for (int i=0;i<n;i++){
                A[cur]=i;
                if (isValid(A,cur)){
                    nqueens(A,cur+1,n);
                }
            }
        }
    }
    int totalNQueens(int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        res=0;
        int *A = new int[n];
        nqueens(A,0,n);
        return res;
    }
};
