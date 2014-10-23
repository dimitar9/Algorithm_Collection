
class Solution {
public:
    vector<int> inorderTraversal(TreeNode *root) {
    	vector<int> ret;
    	if (!root) return ret;
    	stack<TreeNode*> stack;
    	TreeNode* top = root; //IMPORTANT
    	while(!stack.empty()  || top!=NULL){//IMPORTANT

    		while(top !=NULL){//IMPORTANT
    			stack.push(top);
    			top = top->left;
    		}
    		top = stack.top();
    		ret.push_back(top->val);
    		stack.pop();
    		top = top->right;//IMPORTANT
    	}
    	return ret;

    }
};
