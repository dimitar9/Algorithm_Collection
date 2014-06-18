/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    void dfs(int st,int ed,vector<TreeNode *> &res){
        if (st>ed){
            res.push_back(NULL);
        }else{
            for (int i=st;i<=ed;i++){
                vector<TreeNode *> lefts;
                dfs(st,i-1,lefts);
                vector<TreeNode *> rights;
                dfs(i+1,ed,rights);
                 
                for (int li = 0; li<lefts.size();li++) {
                    for (int ri =0; ri<rights.size();ri++){
                        TreeNode* node = new TreeNode(i);
                        node->left=lefts[li];
                        node->right=rights[ri];
                        res.push_back(node);
                    }
                }
            }
        }
    }
     
    vector<TreeNode *> generateTrees(int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<TreeNode*> res;
        dfs(1,n,res);
        return res;
    }
};
