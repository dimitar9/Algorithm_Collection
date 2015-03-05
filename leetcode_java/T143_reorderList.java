
//Class definition of ListNode
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class Test143 {

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;

		printList(n1);

		reorderList(n1);

		printList(n1);
	}

	public static void reorderList(ListNode head) {

		if (head != null && head.next != null) {

			ListNode slow = head;
			ListNode fast = head;

			//use a fast and slow pointer to break the link to two parts.
			while (fast != null && fast.next != null && fast.next.next!= null) {
				//why need third/second condition?
				System.out.println("pre "+slow.val + " " + fast.val);
				slow = slow.next;
				fast = fast.next.next;
				System.out.println("after " + slow.val + " " + fast.val);
			}

			ListNode second = slow.next;
			slow.next = null;// need to close first part

			// now should have two lists: head and fast

			// reverse order for second part
			second = reverseOrder(second);

			ListNode p1 = head;
			ListNode p2 = second;

			//merge two lists here
			while (p2 != null) {
				ListNode temp1 = p1.next;
				ListNode temp2 = p2.next;

				p1.next = p2;
				p2.next = temp1;		

				p1 = temp1;
				p2 = temp2;
			}
		}
	}

	public static ListNode reverseOrder(ListNode head) {

		if (head == null || head.next == null) {
			return head;
		}

		ListNode pre = head;
		ListNode curr = head.next;

		while (curr != null) {
			ListNode temp = curr.next;
			curr.next = pre;
			pre = curr;
			curr = temp;
		}

		// set head node's next
		head.next = null;

		return pre;
	}

	public static void printList(ListNode n) {
		System.out.println("------");
		while (n != null) {
			System.out.print(n.val);
			n = n.next;
		}
		System.out.println();
	}
}
