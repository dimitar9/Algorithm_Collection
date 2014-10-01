//  http://jane4532.blogspot.com/2014/08/reverse-linked-list-iileetcode.html
//  Reverse a linked list from position m to n. Do it in-place and in one-pass.
// For example:
// Given 1->2->3->4->5->NULL, m = 2 and n = 4,
// return 1->4->3->2->5->NULL.
// Note:
// Given m, n satisfy the following condition:
// 1 ≤ m ≤ n ≤ length of list.

// 这种linkedlist操作相关的题，别的没有，就是繁琐和噁心。反正当时ac了再写的时候还是很容易出错得很烦，只能看反应速度了吧。没太多参考价值。 
// 考虑各种边界条件，像这个题还是得加个dumpHead.

//  1. m == n || head == NULL || head->next == NULL 就直接return head

//  2. m != n && # of nodes = 2
//  m or n在某个边界点上， m or n不在。 dumpHead的作用就出现了，把dumpHead加上，所有的情况都是m, n不在边界点上，反正最后一个null节点可以当作正常节点看。
// 这个时候拿一个pre node记录m之前一个node, post是n的node. 中间的while循环就是 reverse linked list. 最后再操作一下把前后连接起来就行了，记得删除dumpHead, in case内存泄漏。

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *reverseBetween(ListNode *head, int m, int n) {
        if(!head || !head->next || m == n) return head;
        ListNode *dumpH = new ListNode(-1);
        dumpH->next = head;
        ListNode *pre = dumpH, *cur = head, *post = head;
        n -= m;
        while(m>1){
            pre = pre->next;
            cur = cur->next;
            m--;
        }
        post = cur->next;
        while(post!=NULL && n>0){
            ListNode *tmp = post->next;
            post->next = cur;
            cur = post;
            post = tmp;
            n--;
        }
        
            ListNode *tmp = pre->next;
            tmp->next = post;
            pre->next = cur;

            head = dumpH->next;
            delete dumpH;
            return head;
        
        
    }
};



void reverse(Node*& head)
{
    if(!head) return;
    Node* prev = NULL;
    Node* curr = head;

    while(curr) {
        Node* next = curr->next;
        curr->next = prev;
        prev = curr;
        curr = next;
    }
    head = prev;
}