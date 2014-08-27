package code4reference.test;
 
import java.util.LinkedHashMap;
import java.util.Map;
 
public class LRUCacheImpl extends LinkedHashMap<Integer, String> {
   private static final long serialVersionUID = 1L;
   private int capacity;
    
   public LRUCacheImpl(int capacity, float loadFactor){
      super(capacity, loadFactor, true);
      this.capacity = capacity;
   }
    
   /**
    * removeEldestEntry() should be overridden by the user, otherwise it will not 
    * remove the oldest object from the Map.
    */
   @Override
   protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest){
      return size() > this.capacity;
   }
    
   public static void main(String arg[]){
      LRUCacheImpl lruCache = new LRUCacheImpl(4, 0.75f);
       
      lruCache.put(1, "Object1");
      lruCache.put(2, "Object2");
      lruCache.put(3, "Object3");
      lruCache.get(1);
      lruCache.put(4, "Object4");
      System.out.println(lruCache);
      lruCache.put(5, "Object5");
      lruCache.get(3);
      lruCache.put(6, "Object6");
      System.out.println(lruCache);
      lruCache.get(4);
      lruCache.put(7, "Object7");
      lruCache.put(8, "Object8");
      System.out.println(lruCache);
   }
}


//http://code4reference.com/2014/06/lru-implementation-linkedhashmap/ 
// output 

//{2=Object2, 3=Object3, 1=Object1, 4=Object4}
//{4=Object4, 5=Object5, 3=Object3, 6=Object6}
//{6=Object6, 4=Object4, 7=Object7, 8=Object8}


























RAW impl


package leetcode;
 
import java.util.HashMap;
 
/**
 * Solution: HashMap + Double Linked List + head, tails nodes. A very good OOD problem. 
 * We need to take care public private problem in this kind of question.
 * 
 * Why HashMap and Double Linked List
 * 1. HashMap could check if a value is in the list using O(1)
 * 2. Double Linked List could delete a node and insert a node to rails using O(1).
 * 
 * 1. Put hashMap, head, tail node initialization in LRU but not construct function.
 * 2. Use map.size() == capacity to check full state! Don't need external var.
 * 3. LinkedList should store key which makes it easy to delete when map.size() == capacity
 * 
 * My solution(Wrong): HashMap + Single Linked List. use capacity, another volum var to check if it's full. 
 * set: 
 * 1. not full, add to tails directly. 
 * 2. full,head move on. add new ListNode to tails.(delete head node(oldest)) Actually, head node is not oldest, 
 * LRU node depends on the time use it but not the add sequence. 
 * It's a dynamic queue but not a fix linked list, we must update it. I ignore this point.
 * 
 * @author jeffwan
 * @date Apr 1, 2014
 */
 
public class LRUCache {
	private class Node {
		Node prev;
		Node next;
		int key;
		int value;
 
		public Node(int key, int value) {
			this.key = key;
			this.value = value;
			this.prev = null;
			this.next = null;
		}
	}
 
	private int capacity;
	private HashMap<Integer, Node> map = new HashMap<Integer, Node>();
	private Node head = new Node(-1, -1);
	private Node tail = new Node(-1, -1);
 
	public LRUCache(int capacity) {
		this.capacity = capacity;
		tail.prev = head;
		head.next = tail;
	}
 
	public int get(int key) {
		if (!map.containsKey(key)) {
			return -1;
		}
 
		// remove current from list 
		Node current = map.get(key);
		current.prev.next = current.next;
		current.next.prev = current.prev;
 
		// move current to tails - - update its frequecy 
		addToTail(current);
		return current.value;
	}
 
	public void set(int key, int value) {
		if (get(key) != -1) {
			map.get(key).value = value;
			return;
		}
 
		if (map.size() == capacity) {
			// remove head.next node
			map.remove(head.next.key);
			head.next = head.next.next;
			head.next.prev = head;
		}
 
		Node insert = new Node(key, value);
		map.put(key, insert);
		addToTail(insert);
	}
 
	private void addToTail(Node current) {
		current.prev = tail.prev;
		tail.prev = current;
		current.prev.next = current;
		current.next = tail;
	}
}
 
 


