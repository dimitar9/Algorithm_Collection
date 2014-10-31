/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
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
 
    TreeNode *l2bst(ListNode* &head,int st, int ed){
        if (st>ed) {return NULL;}
        TreeNode *lefttree = l2bst(head,st,int(st+(ed-st)/2)-1);
        TreeNode *parent = new TreeNode(head->val);
        head = head->next;
        TreeNode *righttree = l2bst(head,int(st+(ed-st)/2)+1,ed);
        parent->left  = lefttree;
        parent->right  = righttree;
        return parent;
    }
     
    TreeNode *sortedListToBST(ListNode *head) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if (head==NULL){return NULL;}
        ListNode *h=head;
        int len = 0;
        while (h){
            len = len+1;
            h = h->next;
        }
        TreeNode *root=l2bst(head,1,len);
        return root;
 
    }
};
