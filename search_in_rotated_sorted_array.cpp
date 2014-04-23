/*leetcode Question 94: Search in Rotated Sorted Array 
 Search in Rotated Sorted Array

 Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 You are given a target value to search. If found in the array return its index, otherwise return -1.
 You may assume no duplicate exists in the array.
 Main idea is Binary Search.
 As the sequence is rotated, for any mid element, either it is of order with its previous part, or it is of order with its next part. e.g. 561234, middle element 1 has an order with its next part 1234.
                                  5678123, middle element 8 has an order with its previous part 5678.

 Normal binary search just compare the middle element with the target, here we need more than that.
 e.g.
 567123, the middle element is 1, if we want to search 6, first compare middle element with 1st element, to know which part is of order, if mid>1st, the first part is ordered,otherwise the last part is ordered. Then compare the target value with the bound value in each case. Details see the code.


 Complexity is O(log_n).*/
class Solution {
public:
 
    int se(int st, int ed, int target, int A[]){
        if (st>ed) {return -1;}
        else{
            int mid = st+(ed-st)/2;
            if (A[mid]==target){return mid;}
             
            if (A[mid]>=A[st]){
                if (target<=A[mid] && target>=A[st]){
                    return se(st,mid-1,target,A);
                }else{
                    return se(mid+1,ed,target,A);
                }
            }
             
            if (A[mid]<A[st]){
                 
                if (target<=A[mid] || target >= A[st]){
                    return se(st,mid-1,target,A);
                }else{
                    return se(mid+1,ed,target,A);
                }
                 
            }
            return -1;
        }
         
    }
 
    int search(int A[], int n, int target) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if (n==0){return -1;}
        return  se(0,n-1,target,A);
    }
};
