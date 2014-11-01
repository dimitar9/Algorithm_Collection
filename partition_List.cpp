class Solution {
public:
    ListNode *partition(ListNode *head, int x) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        ListNode *p= new ListNode(0);
        p->next = head;
        head = p; // used to save the result head.
        ListNode *last=head; // used to get the last node
         
        if (head==NULL){return NULL;}
        if (head->next==NULL){return head->next;}
         
        int n=0; //length of the list
        while (last->next!=NULL){ last=last->next; n++; } //get the length and last node
         
        while (n>0){  // in case  of non-stop loop, count n.
            if (p->next->val < x){  // val<x keep the node
                p=p->next;
                n--;
            }else{                  // val>=x move to last
                last->next = p->next;//new ListNode(p->next->val);    // add node to the last
                last = last->next;
                p->next = p->next->next;                    //delete current node
                last->next = NULL;
                n--;
            }
        }
        return head->next;  //the 1st node is elmininated
    }
};
