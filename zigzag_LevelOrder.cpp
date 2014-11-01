/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
 
 
 //author Dimitar
 
class Solution {
public:
    vector<vector<int> > zigzagLevelOrder(TreeNode *root) {
        vector<vector<int>> result;
        if(!root) return result;
        queue<pair<TreeNode*, int>> level_queue;
        vector<int> tmp_vec;
        level_queue.push(make_pair(root,1));
        int level = 1;
        while(!level_queue.empty()){
            pair<TreeNode*,int> p = level_queue.front();
            level_queue.pop();
            if(p.second != level){
                if (p.second %2== 1) reverse(tmp_vec.begin(), tmp_vec.end());
                result.push_back(tmp_vec);
                level = p.second;
                tmp_vec.clear();
            }
            
            tmp_vec.push_back(p.first->val);
            if(p.first->left != NULL) level_queue.push(make_pair(p.first->left, (p.second+1) ));
            if(p.first->right != NULL) level_queue.push(make_pair(p.first->right, (p.second+1) ));
        }
        level++;
        if (level%2==1)  reverse(tmp_vec.begin(), tmp_vec.end());
        result.push_back(tmp_vec);
        return result;
    }
};
