//dmitar slution
class Solution {
public:
    vector<int> searchRange(int A[], int n, int target) {
        vector<int> a(2,-1);
        int st=-1; 
        int end = -1;

        
        if( n <1) return a;
        if(n==1) if (A[0]==target) {
            a[0] = 0;
            a[1] = 0;
            return a;
        }
        
        st = 0;
        end = n-1;
        int mid = 0;
        while(st<=end){
            mid = st + (end-st)/2;
            if(A[mid] < target){
                st = mid +1;
            } else if (A[mid] > target){
                end = mid - 1;
            } else if(A[mid] == target){
                st = mid;
                while( st > 0 && A[mid] == A[st-1]){
                    st--;
                }
                end = mid;
                while(end < n-1 && A[mid] == A[end+1]){
                    end++;
                }
                a[0]=st;a[1]=end;
                return a;
            }
        }
        
        
    }
};
