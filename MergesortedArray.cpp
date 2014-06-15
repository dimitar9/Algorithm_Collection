class Solution {
public:
    void merge(int A[], int m, int B[], int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int count=m+n-1;
        m--; n--;
        while (m>=0 && n>=0){
            A[count--] = A[m]>B[n]? A[m--]:B[n--];
        }
        while (n>=0){ A[count--] = B[n];}
    }
};
