/* leetcode Question 56: Minimum Path Sum
Minimum Path Sum

Given a m x n grid filled with non-negative numbers, find a path from top 
left to bottom right which minimizes the sum of all numbers along its path.
Note: You can only move either down or right at any point in time.


Analysis:
This is a DP problem.
Init: A[0][i] = A[0][i-1]+grid[0][i];
      A[i][0] = A[i-1][0]+grid[i][0];
State Change func:
      A[i][j] = min(A[i-1][j]+grid[i][j], A[i][j-1]+grid[i][j]);

*/

class Solution {
public:
    int minPathSum(vector<vector<int> > &grid) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if (grid.empty()){return 0;}
        int m=grid.size();
        int n=(*grid.begin()).size();
        vector<vector<int> > a(m,vector<int>(n,0));     
        a[0][0]=grid[0][0];
        for (int i=1;i<n;i++){ a[0][i]=a[0][i-1]+grid[0][i];}
        for (int i=1;i<m;i++){ a[i][0]=a[i-1][0]+grid[i][0];}   
        for(int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                a[i][j]= min( a[i][j-1]+grid[i][j], a[i-1][j]+grid[i][j]);
            }
        }
        return a[m-1][n-1];
    }
};
