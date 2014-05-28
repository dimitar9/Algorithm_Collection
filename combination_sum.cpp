/*
 *   leetcode Question 17: Combination Sum
 *   Combination Sum
 *
 *
 *   Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 *   The same repeated number may be chosen from C unlimited number of times.
 *   Note:
 *
 *       All numbers (including target) will be positive integers.
 *           Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 *               The solution set must not contain duplicate combinations.
 *
 *               For example, given candidate set 2,3,6,7 and target 7,
 *               A solution set is:
 *               [7]
 *               [2, 2, 3] 
 *
 *               Analysis:
 *
 *               Because the problem is to get all the possible results, not the best or the number of result, thus we don't need to consider DP(dynamic programming), DFS is enough to handle it.
 *
 *               The idea is to scan from the first to the last element from the ordered array. check every possible combination of these numbers(multiple times for a single element).
 *
 *               the end condition of the dfs function is
 *               1. the target ==0 , print list, return
 *               2. the target < 0 return
 *               3. start position >= array size return
 *               otherwise, from for each element in the array, dfs(start, target-element value);
 *               details see the source code:
 * */
class Solution {
public:
    void dfs(vector<int>const &candidates, int target, vector<vector<int> > &res, vector<int> &r, int i){
        if (target<0){
            return;
        }else{
            if (target==0){
                res.push_back(r);
            }else{
                while (i<candidates.size() && target-candidates[i]>=0){
                    r.push_back(candidates[i]);
                    dfs(candidates,target-candidates[i],res,r,i);
                    i++;
                    r.pop_back();
                }
            }
        }
         
    }
    vector<vector<int> > combinationSum(vector<int> &candidates, int target) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<vector<int> > res;
        if (candidates.size()==0){return res;}
        sort(candidates.begin(),candidates.end());
        vector<int> r;
        dfs(candidates,target,res,r,0);
        return res;
    }
};




///version 2. no duplicattion from source


class Solution {
public:
    void dfs(vector<int> &num, int target, vector<vector<int> > &res, vector<int> &r,int st){
        if (target<0){
            return;
        }else{
            if (target==0){
                res.push_back(r);
            }else{
                int pre = -1;
                for (int i=st;i<num.size();i++){
                    if (num[i]!=pre){
                        r.push_back(num[i]);
                        dfs(num,target-num[i],res,r,i+1);
                        pre = num[i];
                        r.pop_back();
                    }
                }
            }
        }
    }
     
    vector<vector<int> > combinationSum2(vector<int> &num, int target) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<vector<int> > res;
        if (num.size()==0){return res;}
        sort(num.begin(),num.end());
        vector<int> r;
        dfs(num,target,res,r,0);
        return res;
    }
};

Reviewed 
