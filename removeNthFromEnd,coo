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
    ListNode *removeNthFromEnd(ListNode *head, int n) {
        if (n==0 || !head){
            return NULL;
        }
         
        ListNode* res = new ListNode(0);
        res->next = head;
        head = res;
         
        ListNode* p=head;
        ListNode* q=head;
         
        for (int i=0;i<=n;i++){
            if (q){
                q=q->next;
            }else{
                return NULL;
            }
        }
         
        while (q){
            p=p->next;
            q=q->next;
        }
         
        p->next=p->next->next;
         
        return head->next;
    }
};
