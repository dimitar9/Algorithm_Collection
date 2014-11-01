
/*Another idea is to use the recursion.
1. Find the last node in the postorder vector, which is the root of the current tree.
2. Find the position of root node in the inorder vector, which divide the inorder vector into 2 sub tree inorder vectors. Left part is the left sub-tree, right part is the right sub-tree.
3. Do 1 and 2 for the right and left sub-tree, respectively.
(Updated in 201309)
e.g. The tree is:
        1
   2        3
4   5         6
Inorder:         425136
Postorder:     452631

So, first we have 1 as the root node,  and find 1's position in inorder,   425   1    36
Then we search    inorder 36              as the right child,     and      inorder:    425    as the left child
                           postorder (452)63                                            postorder: 452
                           
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
    TreeNode *ct(vector<int> &inorder, vector<int> &postorder, int ist, int ied, int ped) {   
            if (ist>ied){return NULL;}
            TreeNode *res=new TreeNode(postorder[ped]);
            int mid;
            for (int i=ist;i<=ied;i++){
                if (inorder[i]==res->val){mid = i;break;}
            }
            res->right = ct(inorder,postorder,mid+1,ied,ped-1);
            res->left = ct(inorder,postorder,ist,mid-1, ped-1-ied+mid);
            return res;
    }
 
 
    TreeNode *buildTree(vector<int> &inorder, vector<int> &postorder) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if (postorder.size()==0){
            return NULL;
        }else{
            return ct(inorder,postorder,0,inorder.size()-1,postorder.size()-1);
        }
             
    }   
};
