1: Populating Next Right Pointers in Each Node   
void connect(TreeLinkNode *root) {  
2:      // Start typing your C/C++ solution below  
3:      // DO NOT write int main() function  
4:      if(root == NULL) return;  
5:      if(root->left != NULL)  
6:        root->left->next = root->right;  
7:      if(root->right !=NULL)  
8:        root->right->next = root->next? root->next->left:NULL;  
9:       connect(root->left);  
10:       connect(root->right);  
11:    } 
