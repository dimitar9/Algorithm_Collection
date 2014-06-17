 1 class Solution {  //Reverse Linked List II 
 2 public:
 3     ListNode *reverseBetween(ListNode *head, int m, int n) {
 4         ListNode *dummy = new ListNode(0);
 5         dummy->next = head;
 6 
 7         ListNode *pre = dummy, *cur = head;
 8         for(int i = 1; i < m; i++){
 9             pre = cur;
10             cur = cur->next;
11         }
12 
13         ListNode *p1,*p2;
14         if(cur)
15             p1 = cur->next;
16         if(p1)
17             p2 = p1->next;
18         for(int j = m; j < n; j++){
19             p1->next = cur;
20             cur = p1;
21             p1 = p2;
22             if(p2) p2 = p2->next;
23         }
24         pre->next->next = p1;
25         pre->next = cur;
26 
27         return dummy->next;
28     }
29 };

http://www.cnblogs.com/4everlove/p/3651002.html 
