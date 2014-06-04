/** leetcode Question 89: Rotate List
Rotate List

Given a list, rotate the list to the right by k places, where k is non-negative.
For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.

Analysis:
The idea is to get the whole length of the list, then compute the rotate position.
And cut the list from the rotate position, link the front part to the last part.

e.g.
1->2->3->4->5->null , k =2;
len = 5;
rotate pos = 5-2 = 3;

cut list:  1->2->3  --->  4->5->null
link :     4->5->1->2->3->null


//**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *rotateRight(ListNode *head, int k) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if (head==NULL || k==0) {return head;}
         
        ListNode* p = head;
        int len=0;
        //get total length
        while (p!=NULL){
            len++;
            p=p->next;
        }
        //get rotate position
        int r;
        if (k%len==0){
            return head;
        }else{
            r = len-(k%len)-1;   
        }
        p=head;
        while (r>0){
            p=p->next;
            r--;
        }
         
         
        //cut current list, link the back to the front
        ListNode *q =p->next;
        if (q==NULL){return head;}
        while (q->next!=NULL){
            q=q->next;
        }
        q->next = head;
        q=p->next;
        p->next=NULL;
         
        return q;
    }
};
