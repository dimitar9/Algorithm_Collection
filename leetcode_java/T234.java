/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
public boolean isPalindrome(ListNode head) {
    if(head == null)
        return true;
    if(head.next == null)
        return true;
    ListNode fast = head;
    ListNode slow = head;
    while(fast.next != null && fast.next.next != null){
        fast = fast.next.next;
        slow = slow.next;
    }
    ListNode partNode = slow.next;
    slow.next = null;
    ListNode newList = reverse(partNode);
    ListNode pointer = head;
    while(newList != null){
        if(pointer.val != newList.val)
            return false;
        pointer = pointer.next;
        newList = newList.next;
    }
    return true;
}
public ListNode reverse(ListNode head){
    if(head == null)
        return head;
    if(head.next == null)
        return head;
    ListNode node = head.next;
    ListNode point = head;
    head.next = null;
    while(node != null){
        ListNode temp = node.next;
        node.next = point;
        point = node;
        node = temp;
    }
    return point;
}
}
