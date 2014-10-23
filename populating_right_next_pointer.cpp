class Solution {
public:
    void connect(TreeLinkNode *root) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        queue<TreeLinkNode*> que;
        if (root==NULL) {return;}
        que.push(root);
        int i=1;
        int l=1;
        while (!que.empty()){
            TreeLinkNode* p =que.front();
            que.pop();
            if ((p->right!=NULL)&&(p->left!=NULL)){
                que.push(p->left);
                que.push(p->right);
            }
            if (i==(pow(2,l)-1)){
                p->next = NULL;
                i++;
                l++;
            }else{
                p->next = que.front();
                i++;
            }
        }

    }
};



/// recursive
    public void connect(TreeLinkNode root) {
        if (root == null)
            return ;
        if (root.left != null){
           root.left.next = root.right;
        }
        if (root.right != null && root.next!= null)
           root.right.next = root.next.left;
        connect(root.left);
        connect(root.right);

    }
