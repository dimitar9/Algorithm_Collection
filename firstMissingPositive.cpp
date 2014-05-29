 /*Given an unsorted integer array, find the first missing positive integer.
For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.
Your algorithm should run in O(n) time and uses constant space.

Analysis:

If we can use another array flag, we can assign flag[A[i]-1] = A[i] to present its occurrence.And get the first element from flag that the flag[i-1]!=i as the result. Here A[i]-1 and i-1 because the array is from 0 to n-1 to store 1 to n.
But the question requires that we can not use additional space. So we have to use the original array A, to save the flag. 
The idea is as follow:
e.g. 3,2,5,1,7
For each element,
1. Do not consider the element which <=0, or value > length n
2. Swap this element A[i] with the A[A[i]-1], e.g. when we met A[0]=3, we swap A[0] and A[2], then A[0]=5
3. For the current element A[i], if A[i]<=0 or A[i]>length n, or A[i] has already occurred, break. Else go to step 2.
    e.g. A[0]=5, swap A[0] and A[5], A[0]=7, break.Now the array A is {7,2,3,1,5}.
    Next round, A is {1,2,3,7,5}
4. Scan the array A and find the result. e.g. {1,2,3,7,5}, the A[3]!=3+1, print 3+1, result =4.

*/
class Solution {
public:
    int firstMissingPositive(int A[], int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function   
        for (int i = 0; i<n;i++){
            if ( (A[i]>0)&&(A[i]<=n)){
                while (A[i]!=(i+1)){
                    if ((A[i]>n)||(A[i]<=0)||(A[A[i]-1]==A[i])) {break;}
                    int tmp;
                    tmp = A[A[i]-1];
                    A[A[i]-1]=A[i];
                    A[i]=tmp;
                }
            }
        }
         
        int i=0;
        for (; i<n;i++){
            if (A[i]!=(i+1)){
                return i+1;
            }
        }
        return i+1;
         
    }
};
