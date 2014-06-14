/* leetcode Question 63: Partition List
Partition List:

Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal tox.
You should preserve the original relative order of the nodes in each of the two partitions.
For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.

Analysis:
Simple idea but be careful with the operation of pointers.
The idea is:   first get the last element and the length of the list (1 while loop)
                    Then scan the whole list, if current node value < x, then go to the next node.
                                                          if current node value >=x, then move this node to the end of the list.
                    until  meet the length of the original list.*/

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
                last->next = new ListNode(p->next->val);    // add node to the last
                last = last->next;
                p->next = p->next->next;                    //delete current node
                n--;
            }
        }
        return head->next;  //the 1st node is elmininated
    }
};
