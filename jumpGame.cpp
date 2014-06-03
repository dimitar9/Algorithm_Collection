/* leetcode Question 38: Jump Game
Jump Game

Given an array of non-negative integers, you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Determine if you are able to reach the last index.
For example:
A = [2,3,1,1,4], return true.
A = [3,2,1,0,4], return false.


Analysis:
Note that the A[i] means the maximum jump length. In other words, it is possible that we move j step (<A[i]) when we at A[i], e.g. if A[i]=2, we can move either 1 or 2 steps.

The simple but time-consuming way is O(n^2). Set every future step true according to the A[i]. But this only can pass the small test.

A better idea is use another variable to save the number of steps available. Just a little bit different from the O(n^2) one , see code for more details.*/

class Solution {
public:
    bool canJump(int A[], int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if (n==0) {return false;}
        if (n==1) {return true;}
         
        int m=0;
        for (int i=0;i<n;i++){
            if (i<=m){
             m=max(m,A[i]+i);
             if (m>=n-1){return true;}
            }
        }
        return false;
    }
};
