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
    ListNode *addTwoNumbers(ListNode *l1, ListNode *l2) {
    ListNode* result = new ListNode(0);
    int carry = 0;
    ListNode* lastNode = result;
    do {            
        int sum = carry;
        if(l1){
            sum += l1->val;
            l1 = l1 -> next;
        }
        if(l2){
            sum += l2->val;
            l2 = l2 -> next;
        }
        lastNode -> next = new ListNode(sum % 10);            
        carry = sum / 10;            
        lastNode = lastNode -> next;

    } while(l1 || l2 || carry);
    return result -> next;
    }
};
