package home;

import org.junit.Test;

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

		public ListNode(int x, ListNode next) {
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

	/*
	 * Determines a loop or cycle in a linked list.
	 */
	public boolean hasLoop(ListNode head) {
		boolean hasLoop = false;
		if (head != null) {
			ListNode slow = head;
			ListNode fast = head.next;

			while (fast != null && fast.next != null) {
				if (fast == slow || fast.next == slow) {
					hasLoop = true;
				} else {
					fast = fast.next.next;
					slow = slow.next;
				}
			}
		}
		return hasLoop;
	}

	public ListNode reverseList(ListNode head) {
		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return head;
		}

		ListNode secondElement = head.next;
		head.next = null;

		// Need to back up the reverse list's head. No change on rhead.
		ListNode rhead = reverseList(secondElement);

		secondElement.next = head;

		return rhead;
	}

	public ListNode reverseListIteratively(ListNode head) {
		if (head == null) {
			return null;
		}

		ListNode prev = null;
		ListNode curr = head;

		while (curr != null) {
			ListNode temp = curr.next;

			curr.next = prev;
			prev = curr;
			curr = temp;
		}

		return prev;
	}

	/*
	 * Input: 1->2->3->4->5->Null Output: 2->1->4->3->5->Null
	 */
	public ListNode evenOddMerge(ListNode head) {

		if (head == null || head.next == null) {
			return head;
		}

		ListNode first = head;
		ListNode second = first.next;
		ListNode third = null;

		ListNode result = second;

		// Logic: 1->2->3->4->5->6
		// First - 1, Second - 2, Third 3
		// Second.next = first
		// First.next = Third.next
		while (true) {
			
			third = second.next;

			second.next = first;

			if (third == null || third.next == null) {
				first.next = third;
				break;
			}

			first.next = third.next;

			first = third;
			second = first.next;
		}

		return result;
	}

	public ListNode getIntersection(ListNode l1, ListNode l2)
	{
		ListNode newList = null;
		
		ListNode curr = null;
		while(l1 != null && l2 != null)
		{
			if(l1.data == l2.data)
			{
				ListNode newNode = new ListNode(l1.data);
				
				if(newList == null)
				{
					newList = newNode;
					curr = newList;
				}
				else
				{
					curr.next = newNode;
					curr = curr.next;
				}
				l1 = l1.next;
				l2 = l2.next;
			}
			else
			{
				if(l1.data < l2.data)
				{
					l1 = l1.next;
				}
				else
				{
					l2 = l2.next;
				}
			}
		}
		
		return newList;
		
	}
	
	
	/*
	 * Prints a linked list.
	 */
	public void printLinkedList(ListNode head) {
		System.out.println();
		while (head != null) {
			System.out.print("->" + head.data);
			head = head.next;
		}
	}

	public void testLinkedList() {
		ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3)));

		this.printLinkedList(l1);
		ListNode l2 = reverseListIteratively(l1);
		this.printLinkedList(l2);
	}

	public void testMergeTwoLists() {
		ListNode l1 = new ListNode(1, new ListNode(3, new ListNode(5,
				new ListNode(7, new ListNode(9)))));
		ListNode l2 = new ListNode(2, new ListNode(4, new ListNode(6,
				new ListNode(8, new ListNode(10)))));

		ListNode mergedList = this.mergeTwoLists(l1, l2);

		ListNode temp = mergedList;

		while (temp != null) {

			System.out.print(temp.data + ", ");
			temp = temp.next;
		}
	}

	@Test
	public void testEvenOddMerge() {
		ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3,
				new ListNode(4, new ListNode(5)))));

		l1 = evenOddMerge(l1);

		printLinkedList(l1);
	}

	@Test
	public void testListIntersection()
	{
		ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3,
				new ListNode(4, new ListNode(5)))));
		
		ListNode l2 = new ListNode(3, new ListNode(4, new ListNode(10,
				new ListNode(11))));
		
		ListNode l3 = getIntersection(l1, l2);
		
		printLinkedList(l3);
	}
	
}
