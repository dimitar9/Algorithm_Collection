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
    ListNode *detectCycle(ListNode *head) {
        if (!head){return NULL;}
        ListNode *p=head;
        ListNode *q=head;
        while (1){
            if (p->next!=NULL){p=p->next;}else{return NULL;}
            if (q->next!=NULL && q->next->next!=NULL){q=q->next->next;}else{return NULL;}
            if (p==q){ //if find the loop, then looking for the loop start
                q=head;
                while (p!=q){
                    p=p->next;
                    q=q->next;
                }
                return p;
            }
        }
    }
};
