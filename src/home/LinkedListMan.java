package home;

public class LinkedListMan {

	/*
	 * Singly Linked List definition
	 */
	public class ListNode {
		int data;
		ListNode next;

		public ListNode(int x) {
			this(x, null);
		}
		
		public ListNode(int x, ListNode next)
		{
			data = x;
			this.next = next;
		}
	}

	/*
	 * Merges two sorted linked list
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode curr = head;
		ListNode p1 = l1;
		ListNode p2 = l2;

		while (p1 != null && p2 != null) {
			if (p1.data <= p2.data) {
				curr.next = p1;
				p1 = p1.next;
			} else {
				curr.next = p2;
				p2 = p2.next;
			}
			curr = curr.next;
		}

		if (p1 != null) {
			curr.next = p1;
		} else if (p2 != null) {
			curr.next = p2;
		}
		
		return head.next;
	}
	
	public void testMergeTwoLists()
	{
		ListNode l1 = new ListNode(1, 
				new ListNode(3, 
						new ListNode(5, 
								new ListNode(7, 
										new ListNode(9)))));
		ListNode l2 = new ListNode(2, 
				new ListNode(4, 
						new ListNode(6, 
								new ListNode(8, 
										new ListNode(10)))));
		
		ListNode mergedList = this.mergeTwoLists(l1, l2);
		
		ListNode temp = mergedList;
		
		while(temp!= null)
		{
			
			System.out.print(temp.data +", ");
			temp = temp.next;
		}
	}
}
