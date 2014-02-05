    ListNode *swapPairs(ListNode *head) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        ListNode *p = new ListNode(0);
        p->next = head;
        head = p;
        while(true){
            if (p->next==NULL){break;}
            if (p->next->next==NULL){break;}
            ListNode* q1 = p->next;
            ListNode* q2 = q1->next;
            q1->next = q2->next;
            q2->next = q1;
            p->next = q2;
            p=q1;
        } 
        return head->next;
    }
