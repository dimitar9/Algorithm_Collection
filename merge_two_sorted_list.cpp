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
    ListNode *mergeTwoLists(ListNode *l1, ListNode *l2) {
        ListNode* res = new ListNode(0);
        ListNode* current = res;
        while (true){
            if (!l1){
                current->next = l2;
                break;
            }
            if (!l2){
                current->next = l1;
                break;
            }
            if (l1->val < l2->val){
                current->next = l1;
                l1 = l1->next;
            }else{
                current->next = l2;
                l2 = l2->next;
            }
            current = current->next;
        }
        return res->next;
    }
};
