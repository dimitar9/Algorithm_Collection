/* leetcode Question 100: Spiral Matrix I
Spiral Matrix I

Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]

You should return [1,2,3,6,9,8,7,4,5].

Analysis:

When I first face this problem, it took me hours to handle the array indices, and always missed some cases. Then I give up get a whole line once, but tried to get one element in every step. The problem became much easier and took me less than 10 minutes to solve it!

Let's think in this way:
There are m*n elements I need to push into the result vector. So we just do it one by one.
For each element, there are only 4 directions can go to the next, left, down, right, and up.
The conditions are almost the same: while the next element in such direction is available, go to the next. Otherwise try the next one direction.
Available above means: (1) meet the bound of the array. (2) The next element has been visited.

Once we get the algorithm, coding becomes pretty clear, just use a mask bool array to store the visited elements. Big loop from 1 to n**/


class Solution {
public:
    vector<int> spiralOrder(vector<vector<int> > &matrix) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<int> res;
        if (matrix.empty()){return res;}
        if (matrix.size()==1){return matrix[0];}
        int m = matrix.size();
        int n = matrix[0].size();
        vector<vector<bool> > mask(m,vector<bool>(n,false));
        int i=0;
        int j=0;
        int k=0;
        res.push_back(matrix[i][j]);
        mask[0][0]=true;
        while (k<m*n-1){
            while ((j+1<n)&&(mask[i][j+1]==false)){
                j++;
                k++;
                res.push_back(matrix[i][j]);
                mask[i][j]=true;
            }
             
            while ((i+1<m)&&(mask[i+1][j]==false)){
                i++;
                k++;
                res.push_back(matrix[i][j]);
                mask[i][j]=true;
            }
             
            while ((j>0)&&(mask[i][j-1]==false)){
                j--;
                k++;
                res.push_back(matrix[i][j]);
                mask[i][j]=true;
            }
             
            while ((i>0)&&(mask[i-1][j]==false)){
                i--;
                k++;
                res.push_back(matrix[i][j]);
                mask[i][j]=true;
            }
        }
        return res;
    }
};
