import java.util.*;

public class LinkedLists {
	
	public LinkedLists() {
		
	}
	
	
	/* This method removes duplicates from a linked list, given
	 * the head of the linked list. There are two options for
	 * solving this problem:
	 * 	1. Using a hashset to store values we've already seen
	 * 	2. Using two pointers, and have one stary as the current
	 * 	   node and the other iterate the rest of the list looking
	 * 	   for the same value.
	 * 
	 */
	public void removeDups1(SinglyNode head) {
		if (head != null && head.getNext() != null) {
			HashSet<Object> values = new HashSet<Object>();
			SinglyNode current = head;
			SinglyNode prev = null;
			
			while (current != null) {
				if (values.contains(current.getVal())) {
					prev.setNext(current.getNext());
					current.setNext(null);
					current = prev.getNext();
				} else {
					values.add(current.getVal());
				}
				prev = current;
				current = current.getNext();
			}
		}
	}
	
}
