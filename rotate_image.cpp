Rotate Image 解题报告

You are given an n x n 2D matrix representing an image.
Rotate the image by 90 degrees (clockwise).
Follow up:
Could you do this in-place?
» Solve this problem

[解题思路]
如下图，首先沿逆对角线翻转一次，然后按x轴中线翻转一次。




1:    void rotate(vector<vector<int> > &matrix) {  
2:      // Start typing your C/C++ solution below  
3:      // DO NOT write int main() function  
4:      int len = matrix[0].size();  
5:      for(int i =0; i<len-1; i++)  
6:      {  
7:        for(int j=0;j<len-i;j++)  
8:        {  
9:          swap(matrix[i][j], matrix[len-1-j][len-1-i]);  
10:        }  
11:      }  
12:      for(int i =0; i<len/2; i++)  
13:      {  
14:        for(int j=0;j<len;j++)  
15:        {  
16:          swap(matrix[i][j], matrix[len-i-1][j]);  
17:        }  
18:      }  
19:    }  
20:    void swap(int& a1, int&a2)  
21:    {  
22:      int temp = a1;  
23:      a1=a2;  
24:      a2=temp;  
25:    }  
