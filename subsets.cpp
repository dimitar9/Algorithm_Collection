/* leetcode Question 104: Subsets
Subsets:

Given a set of distinct integers, S, return all possible subsets.
Note:

    Elements in a subset must be in non-descending order.
    The solution set must not contain duplicate subsets.

For example,
If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]


Analysis:

The easiest idea is using the binary numbers.
e.g.
set [a,b,c], write the binary numbers of length 3.
000    []
001    [a]
010    [b]
011    [ab]
100    [c]
101    [ac]
110    [bc]
111    [abc]

Then the problem is pretty easy, just have to implement the int binary to string part.
Details see code.


Another approach is to use DFS, I'll post it out later.*/


class Solution {
public:
 
    string getbinary(int d,int len){
    }
    vector<vector<int> > subsets(vector<int> &S) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        sort(S.begin(),S.end());
        vector<vector<int> > res;
        int n = S.size();
        for (int i=0;i<pow(2,n);i++){
            string str = getbinary(i,n);
            vector<int> ss;
            for (int j=0;j<n;j++){
                if (str[j]=='1'){
                    ss.push_back(S[j]);
                }
            }
            res.push_back(ss);
        }
        return res;
         
    }
};i
