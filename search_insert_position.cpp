/*
leetcode Question 96: Search Insert Position 
 Search Insert Position

 Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 You may assume no duplicates in the array.
 Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0

 Analysis:
 O(n) algorithm is just searching from 1st to last, compare target with each element.

 More efficient O(log n) algorithm is to use binary search, only difference is to change return condition to the start position instead of "false", when start position > end position. (line 6 in code below )a*/
class Solution {
public:
 
    int se(int st, int ed, int A[], int target){
        if (st>ed){
            return st;
        }else{
            int mid = st+(ed-st)/2;
            if (A[mid]==target){
                return mid;
            }
            if (A[mid]<target){
                return se(mid+1,ed,A,target);
            }
            if (A[mid]>target){
                return se(st,mid-1,A,target);
            }
        }
    }
    int searchInsert(int A[], int n, int target) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function   
        return se(0,n-1,A,target);
    }
};
