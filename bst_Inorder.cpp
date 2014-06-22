1:    vector<int> inorderTraversal(TreeNode *root) {  
2:      // Start typing your C/C++ solution below  
3:      // DO NOT write int main() function  
4:      vector<TreeNode*> sta;  
5:      vector<int> result;  
6:      if(root == NULL) return result;  
7:      TreeNode* node =root;  
8:      while(sta.size()>0 || node!=NULL)  
9:      {  
10:        while(node!=NULL)  
11:        {  
12:          sta.push_back(node);  
13:          node = node->left;  
14:        }  
15:        node= sta.back();  
16:        sta.pop_back();  
17:        result.push_back(node->val);  
18:        node =node->right;  
19:      }  
20:      return result;  
21:    }  
