/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next == null) return head;
        ListNode start = new ListNode(0);
        start.next = head;
        while(head!=null){
            
            while(head.next!=null && head.val == head.next.val){
                head.next = head.next.next;
                
            }
            head=head.next;
        }
        return start.next;
        
    }
}
