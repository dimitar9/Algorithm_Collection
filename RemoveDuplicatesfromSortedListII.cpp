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
    ListNode *deleteDuplicates(ListNode *head) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if ((head==NULL) || (head->next == NULL) ){return head;}
        ListNode* pre = new ListNode(0);
        pre->next = head;
        
        ListNode* p = pre;
                     
        while(p->next!=NULL){
            ListNode *p2 = p->next;
            while ((p2->next!=NULL)&&(p2->val==p2->next->val)){
                p2=p2->next;
            }
            if (p2!=p->next){
                p->next=p2->next;
            }else{
                p=p->next;
            }
        } 
        return pre->next;
    }
};
