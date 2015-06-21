/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null||lists.length==0) return null;
        int k = lists.length;
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1, ListNode o2){
                if(o1.val < o2.val){
                    return -1;
                } else if (o1.val == o2.val){
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        for(int i = 0; i < k; i ++){
            if(lists[i]!=null){
                pq.offer(lists[i]);
            }
        }
        ListNode tmp = new ListNode(0);
        ListNode cur = tmp;
        
        while(!pq.isEmpty()){
            cur.next = pq.poll(); //very important here. Don't create new Node. Just point to the orignial one. otherwise you loose the link.
            
            cur = cur.next;
            if(cur.next!=null){
                pq.offer(cur.next);
            }
        }
        return tmp.next;
        
    }
}
