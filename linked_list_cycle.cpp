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
    bool hasCycle(ListNode *head) {
        if (!head) return false;
        
        ListNode* fast = head;
        ListNode* slow = head;
        do{
            if((fast->next) && (fast->next->next)){
                fast = fast->next->next;
            } else
                return false;
            if(slow->next)
                slow = slow->next;
            else
                return false;
        } while(fast->val != slow->val);
        return true;
    }
};
