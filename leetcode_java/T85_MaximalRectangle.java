//This question is similar as [Largest Rectangle in Histogram]:
//
//You can maintain a row length of Integer array H recorded its height of '1's,
//and scan and update row by row to find out the largest rectangle of each row.
//
//For each row, if matrix[row][i] == '1'. H[i] +=1, or reset the H[i] to zero. 
//and accroding the algorithm of [Largest Rectangle in Histogram], to update the maximum area.

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix==null||matrix.length==0||matrix[0].length==0)
            return 0;
        int cLen = matrix[0].length;    // column length
        int rLen = matrix.length;       // row length
        // height array 
        int[] h = new int[cLen+1];
        h[cLen]=0;
        int max = 0;


        for (int row=0;row<rLen;row++) {
            Stack<Integer> s = new Stack<Integer>();
            for (int i=0;i<cLen+1;i++) {
                if (i<cLen)
                    if(matrix[row][i]=='1')
                        h[i]+=1;
                    else h[i]=0;

                if (s.isEmpty()||h[s.peek()]<=h[i])
                    s.push(i);
                else {
                    while(!s.isEmpty()&&h[i]<h[s.peek()]){
                        int top = s.pop();
                        int area = h[top]*(s.isEmpty()?i:(i-s.peek()-1));
                        if (area>max)
                            max = area;
                    }
                    s.push(i);
                }
            }
        }
        return max;
    }
}



//Another solution
//dp solution


//The DP solution proceeds row by row, starting from the first row. Let the maximal rectangle area at 
//row i and column j be computed by [right(i,j) - left(i,j)]*height(i,j).
//
//All the 3 variables left, right, and height can be determined by the information from previous row, 
//and also information from the current row. So it can be regarded as a DP solution. The transition equations are:
//
//    left(i,j) = max(left(i-1,j), curleft), curleft can be determined from the current row
//
//    right(i,j) = min(right(i-1,j), curright), curright can be determined from the current row
//
//    height(i,j) = height(i-1,j) + 1, if matrix[i][j]=='1';
//
//    height(i,j) = 0, if matrix[i][j]=='0'
//
//The code is as below. The loops can be combined for speed but I separate them for more clarity of the algorithm.

class Solution {
	public int maximalRectangle(vector<vector<char> > &matrix) {
    if(matrix.empty()) return 0;
    const int m = matrix.size();
    const int n = matrix[0].size();
    int left[n], right[n], height[n];
    fill_n(left,n,0); fill_n(right,n,n); fill_n(height,n,0);
    int maxA = 0;
    for(int i=0; i<m; i++) {
        int cur_left=0, cur_right=n; 
        for(int j=0; j<n; j++) { // compute height (can do this from either side)
            if(matrix[i][j]=='1') height[j]++; 
            else height[j]=0;
        }
        for(int j=0; j<n; j++) { // compute left (from left to right)
            if(matrix[i][j]=='1') left[j]=max(left[j],cur_left);
            else {left[j]=0; cur_left=j+1;}
        }
        // compute right (from right to left)
        for(int j=n-1; j>=0; j--) {
            if(matrix[i][j]=='1') right[j]=min(right[j],cur_right);
            else {right[j]=n; cur_right=j;}    
        }
        // compute the area of rectangle (can do this from either side)
        for(int j=0; j<n; j++)
            maxA = max(maxA,(right[j]-left[j])*height[j]);
    }
    return maxA;
}

};

//This solution is so clever that I think so hard to understand it.
//height counts the number of successive '1's above (plus the current one). 
//The value of left & right means the boundaries of the rectangle 
//which contains the current point with a height of value height. 




