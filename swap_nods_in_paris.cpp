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
    ListNode *swapPairs(ListNode *head) {
        if (!head) return NULL;
        
        ListNode* start = new ListNode(0);
        ListNode* pre = start;
        pre-> next = head;
        head = pre;
        
        while(true){
            if (!pre->next || !pre->next->next) break;
            ListNode* p1 = pre->next;
            ListNode* p2 = pre->next->next;
           
            p1->next = p2->next;
            p2->next = p1;
            pre->next = p2;
            pre = p1;
        }
     
        return head->next;
        
    }
};
