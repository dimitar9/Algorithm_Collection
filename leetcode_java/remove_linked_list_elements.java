/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head==null) return head;
        ListNode prev = new ListNode(0);
        ListNode k = prev;
        prev.next = head;
        while(head!=null){
            if(head.val == val){
               head = head.next;
               prev.next=head;
            }else {
                prev.next = head;
                head=head.next;
                prev = prev.next;
            } 
            
        }
        return k.next;
    }
}
