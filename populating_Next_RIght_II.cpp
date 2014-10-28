// 和之前 Populating Next Right Pointers in Each Node 中的完全二叉树不同，
// 每一层的中间都可能出现断开的情况，有了parent的prev或者next都不能直接设置本层的next
// 。因此，理想的方法还是要层序遍历，遇到新的child就设置为之前child的next，直到某一层没有任何child
// 在constant space的要求下，可以利用next指针将每层作为一个单链表来处理。 traverse第i层链表的同时，
// 还需要找出第i+1层的head，如果没有的话head就是null。 代码如下：

class Solution {
public:
    void connect(TreeLinkNode *root) {
        TreeLinkNode * v = root;
        
        while(v)
        {
            TreeLinkNode * prev = NULL;
            TreeLinkNode * nextHead = NULL;    //! First node in next layer
            while (v)
            {
                if (nextHead == NULL) nextHead = v->left ? v->left : v->right;
                if (v->left)
                {
                    if (prev)  prev->next = v->left;
                    prev = v->left;
                }
                if (v->right)
                {
                    if (prev)  prev->next = v->right;
                    prev = v->right;
                }
                v = v->next;
            }
            v = nextHead;
        }
    }
};
