//============================================================================
// Binary Tree Level Order Traversal
// Given a binary tree, return the level order traversal of its nodes' values.
// (ie, from left to right, level by level).
//
// For example:
// Given binary tree {3,9,20,#,#,15,7},
// 3
// / \
// 9 20
// / \
// 15 7
// return its level order traversal as:
// [
// [3],
// [9,20],
// [15,7]
// ]
//============================================================================

#include<iostream>
#include<vector>
#include<queue>
using namespace std;

struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode(int x):val(x),left(NULL),right(NULL){}
};


vector<vector<int>> levelOrder(TreeNode *root){
  return levelOrder1(root);
}

vector<vector<int>>levelOrder1(TreeNode *root) {
  vector<vector<int>> res;
  vector<int> row;
  for(int level = 1;level<= maxHeight(root);level++){
    row.clear();
    levelOrderHelper1(root,level,row);
    res.push_back(row);
  }
  return res;

}
int maxHeight(TreeNode *node){
  if (NULL == node) return 0;
  return 1+ max(maxHeight(node->left),maxHeight(node->right));
};

void levelOrderHelper1(TreeNode *node, int level, vector<int> &row) {
  if(level == 0 || node == NULL) return;
  if(level == 1){
    row.push_back(node->val);
    return;
  }
  levelOrderHelper1(node->left, level-1, row);
  levelOrderHelper1(node->right, level-1, row);
}

    vector<vector<int> > levelOrder3(TreeNode *root) {
        vector<vector<int> > res;
        vector<int> row;
        queue<TreeNode*> currQ;
        int currNum = 1, nextNum = 0;
        if (root) currQ.push(root);
        while (!currQ.empty()) {
            TreeNode* front = currQ.front();
            currQ.pop(), currNum--;
            row.push_back(front->val);
            if (front->left) currQ.push(front->left), nextNum++;
            if (front->right) currQ.push(front->right), nextNum++;
            if (currNum == 0) {
                res.push_back(row);
                row.clear();
                currNum = nextNum;
                nextNum = 0;
            }
        }
        return res;
    }
  









































