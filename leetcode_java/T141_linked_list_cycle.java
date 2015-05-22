/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if((head == null) ||(head.next == null)) return false;
        ListNode slow = head;
        ListNode fast = head;
        slow = slow.next;
        fast = fast.next.next;
        while(slow != null && fast!=null) {
            if(slow==fast) {
                return true;
            }
            slow = slow.next;
            if(fast.next == null) {
                return false;
            }
            else {
                fast = fast.next.next;
            }
        }
        return false;
    }
}
