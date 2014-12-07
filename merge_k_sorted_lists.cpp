//divide and conquer. O(nklogk)
// check leetcode book page 40 41 42

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
    ListNode *mergeKLists(vector<ListNode *> &lists) {
        if(lists.size()==0)
            return NULL;
        int end = lists.size()-1;
        while(end > 0){
            int begin = 0;
            while(begin < end) {
                lists[begin] = mergeTwoLists(lists[begin], lists[end]);
                begin++;
                end--;
            }
        }
        return lists[0];
    }
    
    ListNode *mergeTwoLists(ListNode *l1, ListNode *l2) {
        ListNode* dummyHead = new ListNode(0);
        ListNode* p = dummyHead;
        while(l1 != NULL && l2 != NULL){
            if(l1->val < l2-> val)
            {
                p->next = l1;
                l1 = l1->next;
            }
            else 
            {
               p->next = l2;
               l2 = l2->next;
            }
            p = p->next;
        }
        if (l1 != NULL) p->next = l1;
        if (l2 != NULL) p->next = l2;
        return dummyHead->next;
    }
};
