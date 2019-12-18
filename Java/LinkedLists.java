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
	public SinglyNode findIthElement(SinglyNode head, int i) {
		if (i < 0) {
			throw new java.lang.Error("Not a valid index.");
		}
		
		int count = 0;
		SinglyNode current = head;
		
		while (current != null) {
			if (i == count) {
				return current;
			}
			current = current.getNext();
			count++;
		}
		
		return null;
	}
	
	/*
	 * Algorithm returns the kth to last node of the linked list. The assumption
	 * is that if k == 2, then the request is to return the 2nd to last element
	 * of the list. If k is larger than the list, then we return null.
	 * 
	 * This implementation uses a hashmap to store nodes at the list indices as
	 * we move through the list. This prevents from having to re-iterate through
	 * the list a second time. Though, in reality using a hashmap does save us 
	 * time by not needing to perform a second O(n) loop, it does not improve
	 * the asymptotic time complexity. The tradeoff is a faster algorithm in
	 * reality, with the expense of O(n) space, where a second iteration would
	 * require more time, but would only require constant space.
	 * 
	 * Two other implementations: 1. recursion to first recurse the entire list, then
	 * we return back a count moving backwards and when k == count, we can return
	 * the node. 2. use two pointers and offset them k spaces, start both at head,
	 * and begin moving second pointer once the first pointer is k spaces ahead. When
	 * the first pointer hits the end, return the second pointer.
	 * 
	 * Time complexity: O(n)
	 * Space complexity: O(n), can improve by using second O(n) iteration, but
	 * then we forego a speedier algorithm.
	 * 
	 */
	public SinglyNode findKthToLastElement(SinglyNode head, int k) {
		HashMap<Integer, SinglyNode> listMap = new HashMap<Integer, SinglyNode>();
		SinglyNode current = head;
		int size = 0;
		
		while (current != null) {
			listMap.put(size,  current);
			current = current.getNext();
			size++;
		}
		
		if (size - k < 0) {
			return null;
		}
		
		return listMap.get(size - k);
	}
	
}
