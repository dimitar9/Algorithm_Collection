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
    vector<int> postorderTraversal(TreeNode *root) {
            vector<int> ret;
            if(root) {
            
            stack<TreeNode*> stack;
            stack.push(root);

            while(!stack.empty()){
                TreeNode* top = stack.top();
                if ((top->left == NULL) && (top->right==NULL))
                {
                    ret.push_back(top->val);
                    stack.pop();
                }
                if(top->left!=NULL){
                    stack.push(top->left);
                    top->left = NULL;
                    continue; //DON"T FORGET THIS!!!!
                }
                if(top->right!=NULL){
                    stack.push(top->right);
                    top->right =NULL;
                    continue; //DON"T FORGET THIS!!!!
                }
                
            }
        }
        return  ret;
    }
};
