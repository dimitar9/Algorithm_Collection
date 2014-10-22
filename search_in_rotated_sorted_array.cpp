class Solution {
public:
     // two branches, 6 if statement!
     // don't forget to check n==1 n==0 2 cases
    int helper(int A[], int st, int end, int target,int n) {
        if ((n==0) || (st>end)) return -1;
        if (n==1){
            return (A[st]==target)?st:-1;
        }
        int mid = st+ (end - st + 1)/2;
        
        if (A[mid]==target) {
            return mid;
        }
        if (A[mid] >= A[st]) {
            if(target < A[mid]  && (target >= A[st])) {
                return helper(A,st,mid-1,target,mid-st);
            }
            if(target < A[mid]  && (target <= A[st])) {
                return helper(A,mid+1,end,target,end-mid);
            }
            if(target > A[mid]  ) { //very tricky this line
                return helper(A,mid+1,end,target,end-mid);
            }
           
        }
        if (A[mid] < A[st]) {
            if(target > A[mid]  && (target >= A[st])) {
                return helper(A,st,mid-1,target,mid-st);
            }
            if(target > A[mid]  && (target <= A[st])) {
                return helper(A,mid+1,end,target,end-mid);
            }
            if(target < A[mid] ) { // very trick this line
                return helper(A,st,mid-1,target,mid-st);
            }
        }

        
    }
    int search(int A[], int n, int target) {
        if (n==0) return -1;
        if (n==1){
            return (A[0]==target)?0:-1;
        }
        else return helper(A,0,n-1,target,n);
        
    }
};
