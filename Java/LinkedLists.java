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
	
	/*
	 * This method returns the ith node in a linked list, assuming
	 * the input index is using 0-based indexing. If the index is 
	 * less than 0, we throw an error. If the list is too short to
	 * contain an item at the index, we return null.
	 * 
	 * Time complexity: O(n) since we need to traverse the list
	 * linearly to find the ith node.
	 * 
	 */
	public SinglyNode findIthElement(SinglyNode head, int index) {
		if (index < 0) {
			throw new java.lang.Error("Not a valid index.");
		}
		
		int count = 0;
		SinglyNode current = head;
		
		while (current != null) {
			if (index == count) {
				return current;
			}
			current = current.getNext();
			count++;
		}
		
		return null;
	}
	
}
