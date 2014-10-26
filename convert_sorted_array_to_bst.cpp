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

    TreeNode* toBST(vector<int> &num, int st, int end) {
        if (st > end) return NULL;
        int mid = st + (end-st)/2;
        TreeNode* node = new TreeNode(num[mid]);
        node->left = toBST(num, st,mid-1); //IMPORTANT< DON"T USE 0, USE ST> EASY MISTAKE!
        node->right = toBST(num, mid+1,end);
        return node;
    }
    TreeNode *sortedArrayToBST(vector<int> &num) {
        
        if (num.size()==0) return NULL;
        else 
            return toBST(num,0,num.size()-1);
        
    }
};
