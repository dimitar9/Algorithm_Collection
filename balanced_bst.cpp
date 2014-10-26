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

    int maxD(TreeNode *root) {
        if (!root) return 0;
        return   max (( 1 + maxD(root->left)), (1+maxD(root->right)));
        
    }
    bool isBalanced(TreeNode *root) {
        if (!root) return true;
        if  (abs(maxD(root->left) - maxD(root->right)) >1) return false;
        else 
            return (isBalanced(root->left) && isBalanced(root->right));
        
    }
};


// #include <iostream>
// #include <cstring>
// #include <cmath>
// using namespace std;

// const int maxn = 100;
// struct Node{
//     int key;
//     Node *lchild, *rchild, *parent;
// };
// Node *head, *p, node[maxn];
// int cnt;

// void init(){
//     head = p = NULL;
//     memset(node, '\0', sizeof(node));
//     cnt = 0;
// }
// void insert(Node* &head, int x){
//     if(head == NULL){
//         node[cnt].key = x;
//         node[cnt].parent = p;
//         head = &node[cnt++];
//         return;
//     }
//     p = head;
//     if(x < head->key)
//         insert(head->lchild, x);
//     else
//         insert(head->rchild, x);
// }
// int d = 0, num = 0, dep[maxn];
// void getDepth(Node *head){
//     if(head == NULL) return;
//     ++d;
//     getDepth(head->lchild);
//     if(head->lchild == NULL && head->rchild == NULL)
//         dep[num++] = d;
//     getDepth(head->rchild);
//     --d;
// }
// bool isBalance(Node *head){
//     if(head == NULL) return true;
//     getDepth(head);
//     int max = dep[0], min = dep[0];
//     for(int i=0; i<num; ++i){
//         if(dep[i]>max) max = dep[i];
//         if(dep[i]<min) min = dep[i];
//     }
//     if(max-min > 1) return false;
//     else return true;
// }
// int main(){
//     init();
//     int a[] = {
//         5, 3, 8, 1, 4, 7, 10, 2, 6, 9, 11, 12
//     };
//     for(int i=0; i<12; ++i)
//         insert(head, a[i]);
//     cout<<isBalance(head)<<endl;
//     return 0;
// }
