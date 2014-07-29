class Solution {
public:
    int maxSubArray(int A[], int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int m=INT_MIN;
        int sum=0;
        for (int i=0;i<n;i++){
            sum = sum>=0?(sum+A[i]):A[i];
            m=max(sum,m);
        }
        return m;
    }
};

reviewed. pass
