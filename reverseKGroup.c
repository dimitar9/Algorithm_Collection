/*leetcode Question 86: Reverse Nodes in k-Group
Reverse Nodes in k-Group

Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
You may not alter the values in the nodes, only nodes itself may be changed.
Only constant memory is allowed.
For example,
Given this linked list: 1->2->3->4->5
For k = 2, you should return: 2->1->4->3->5
For k = 3, you should return: 3->2->1->4->5

Updated 201309:
Analysis:
First consider the atomic operation in this problem: reverse several nodes.
How to reverse? Let's take an example, we have linked list 3->2->1->4->5->6->7
We wan to reverse 4->5->6 to 6->5->4, so we do the following:
(1) 3->2->1->4->5->6->7
               p              q
(2) 3->2->1----->5->6->4->7
               p             q
(3) 3->2->1--------->6->5->4->7
               p             q

The 1st step is to find the locations q and q, where we want to reverse from p->next to q.
Then while p->next != q,  we do:
     (1) move p->next to q->next
     (2) connect p->next to p->next->next
Note that, p and q are fixed.

Now we solve this reverse problem, the final step is to scan the whole list:
When we finished one reverse, put p k steps further, set q=p, then put q k steps further to find the end node for the new reverse, if meet the end, no more reverse needed, return the list.


Code:
*/
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
    ListNode *reverseKGroup(ListNode *head, int k) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if (!head){return NULL;}
        ListNode* p=new ListNode(0);
        p->next=head;
        head = p;
        ListNode* q=p;
        while (true){
            int i=0;
            while (q && i<k){q=q->next;i++;}
            if (!q){return head->next;}
            else{
                while (p->next!=q){
                    ListNode* d = p->next;
                    ListNode* l = q->next;
                    p->next=p->next->next;
                    q->next=d;
                    d->next=l;
                }
                for(int j=0;j<k;j++){p=p->next;}
                q=p;
                }
        }
        return head->next;
    }
};
