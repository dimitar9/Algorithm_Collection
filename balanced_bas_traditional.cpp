#include <iostream>
#include <cstring>
#include <cmath>
#include <stdlib.h>
#include <stdio.h>
using namespace std;

struct Node {
    int data;
    Node *left, *right, *parent;
};
Node *head, *p;

struct Node* newNode (int data)
{
    struct Node* node; 
    node =(Node*) malloc(sizeof(struct Node));
    node->data = data;
    node->left = NULL;
    node->right = NULL;
    return (node);
}

struct Node* insert( struct Node* node, int data)
{
    if ( node == NULL)
        return (newNode(data));
    else {
        if ( data <= node->data)
            node->left = insert (node->left, data);
        else
            node->right = insert(node->right, data);
    }
    return node;
}

void outputAndDestroyTree (Node* root) 
{
    if (!root) {printf("return");
        return;}
    outputAndDestroyTree (root->left);
    printf("%d\n ", root->data);
    outputAndDestroyTree (root->right);
    free(root);
}

int getHeight(Node* root)
{
    if ( root== NULL) return 0;
    return max ( getHeight(root->left), getHeight (root->right));
}
bool isBalanced (Node* root)
{
    if (root == NULL)
        return true;
    int heightDiff = getHeight(root->left) -getHeight(root->right);
    if (std::abs(heightDiff) > 1) {
        printf("not balanced.");
        return false;
    }
    else
    {
        return isBalanced(root->left) && isBalanced(root->right);
    }

}

int main()
{
    struct Node* root = NULL;
    int a[] = {0,2,14,55,100, 5,3,8,1,4,7 };
    for(int i=0;i<(sizeof(a)/sizeof(int));i++)
    {
        
        printf("before insert %d.\n",i);
        root=insert(root, a[i]);
        printf("inserted %d.\n",i);
    }
    bool isb = isBalanced(root);
    if (isb) printf("is balanced.\n");
    outputAndDestroyTree(root);
    return 0;
}

