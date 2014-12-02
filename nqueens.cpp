/* Given an integer n, return all distinct solutions to the n-queens puzzle.
Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]  
此题和数独问题类似，每试一个位子，去检查合法性，合法性包括行，列，对角线。 A[i]表示第i行 第A[i]列放置Q。 
*/
class Solution {
public:
 
  bool isValid(vector<int> A, int i){
      for(int r=0;r<i;r++)
          if(A[r]==A[i]||abs(A[r]-A[i])==abs(r-i))
              return false;
      return true;
  }
  void foo(vector<vector<string>> &res, vector<int> &A, int cur, int n){
      if(cur==n){
          vector<string> r;
          for(int i=0;i<n;i++){
              string str(n,'.');
              str[A[i]]='Q';
              r.push_back(str);
          }
          res.push_back(r);  
          return;
      }
       
      for(int i=0;i<n;i++){
          A[cur]=i;
          if(isValid(A,cur)){
               
              foo(res,A,cur+1,n);
          }
      }
       
  }
   
  vector<vector<string> > solveNQueens(int n) {
      // Start typing your C/C++ solution below
      // DO NOT write int main() function
      vector<vector<string> > res;
      vector<int> A(n,-1);
      foo(res, A, 0, n);
      return res;
  }
};
