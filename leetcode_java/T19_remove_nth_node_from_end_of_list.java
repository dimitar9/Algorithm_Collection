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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null) return null;
        ListNode iNode = new ListNode(0);
        iNode.next = head;
        ListNode fast = iNode;
        ListNode slow = iNode;
        for(int i = 0; i < n; i++){
            if(fast!=null){
                fast = fast.next;
            }
        }
        while(true){
            if(fast.next==null) break;
            else{
                fast = fast.next;
                slow = slow.next;
            }
        }
        slow.next=slow.next.next;
        return iNode.next;
    }
}
