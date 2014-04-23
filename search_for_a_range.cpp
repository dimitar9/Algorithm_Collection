/*leetcode Question 93: Search for a Range 
 Search for a Range

 Given a sorted array of integers, find the starting and ending position of a given target value.
 Your algorithm's runtime complexity must be in the order of O(log n).
 If the target is not found in the array, return [-1, -1].
 For example,
 Given [5, 7, 7, 8, 8, 10] and target value 8,
 return [3, 4].
 Updated 201309
 Analysis:
 When see the O(log n) complexity requirement, it is highly possible that binary search is needed.
 As the array is sorted, thus, the "next" element of the result range must be less (left) or greater
 (right) than the target value, or meets the boundary of the array. So, we can do the binary search 
 twice, one search the left range, where A[mid-1]<A[mid], and one search for the right range, where A[mid+1]>A[mid].*/
class Solution {
public:
    int search(int A[], int n, int target,int st,int ed, bool left){
        if (st>ed){
            return -1;
        }else{
            int mid = st+(ed-st)/2;
            if (A[mid]==target){
                if (left){
                    if (mid==0 || A[mid-1]<A[mid]){return mid;}
                    else{return search(A,n,target,st,mid-1,left);}
                }
                if (!left){
                    if (mid==n-1 || A[mid+1]>A[mid]){return mid;}
                    else{return search(A,n,target,mid+1,ed,left);} 
                }
            }
            if (A[mid]<target){
                return search(A,n,target,mid+1,ed,left);
            }
            if (A[mid]>target){
                return search(A,n,target,st,mid-1,left);
            }
        }
    }
     
    vector<int> searchRange(int A[], int n, int target) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<int> res(2,-1);
        res[0]=search(A,n,target,0,n-1,true);
        res[1]=search(A,n,target,0,n-1,false);
        return res;        
    }
};
    
