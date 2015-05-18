/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head==null) return head;
   
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        
        ListNode tmp = left;
        ListNode rtmp = right;
        while(head!=null){
            if(head.val < x){
                left.next = head;
                left=head;
                
            }else if(head.val >= x){
                right.next = head;
                right = head;
            }
            head = head.next;
        }
        right.next = null;
        left.next = rtmp.next;
        return tmp.next;
    }
}
