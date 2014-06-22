/**
* Definition for binary tree
* struct TreeNode {
* int val;
* TreeNode *left;
* TreeNode *right;
* TreeNode(int x) : val(x), left(NULL), right(NULL) {}
* };
*/
class Solution {
public:
bool isSymmetric(TreeNode *root) {
// Start typing your C/C++ solution below
// DO NOT write int main() function
if(root==NULL) return true;
queue<TreeNode*> q1;
queue<TreeNode*> q2;
q1.push(root->left);
q2.push(root->right);
while(!q1.empty()&&!q2.empty())
{
TreeNode *t1=q1.front();
TreeNode *t2=q2.front();
q1.pop();
q2.pop();
if((t1!=NULL&&t2==NULL)||(t1==NULL&&t2!=NULL))
return false;
if(t1!=NULL&&t2!=NULL)
{
if(t1->val!=t2->val)
return false;
q1.push(t1->left);
q1.push(t1->right);
q2.push(t2->right);
q2.push(t2->left);
}
}
return true;
}
};
