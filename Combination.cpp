/* leetcode Question 19: Combination
Combination


Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]


Analysis:

Standard DFS problem. Details see the code.
*/


class Solution {
public:
    vector<vector<int> > res;
     
     
     
    void dfs(vector<int> &cand, int st, int ed, vector<int> &lr){
        if (lr.size()==ed){
            res.push_back(lr);
            return;
        }
        for (int i = st; i< cand.size();i++){
                lr.push_back(cand[i]);
                dfs(cand,i+1,ed,lr);
                lr.pop_back();
        }
         
         
    }
    vector<vector<int> > combine(int n, int k) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        res.clear();
         
        if ((k<1)||(n<1)||(k>n)){return res;}
        vector <int> cand;
        for (int i = 1; i<=n;i++){
            cand.push_back(i);
        }
        vector<int> lr;
        dfs(cand,0,k,lr);
        return res;
    }
};
