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
	
	/*
	 * This algorithm deletes the input node. The node can be in the
	 * middle of the list.
	 * 
	 * Time complexity: O(1)
	 * 
	 */
	public void deleteNode(SinglyNode node) {
		if (node != null) {
			if (node.getNext() == null) {
				node = null;
			} else {
				SinglyNode nextNode = node.getNext();
				node.setVal(nextNode.getVal());
				node.setNext(nextNode.getNext());
			}
		}
	}
	
	/*
	 * This method partitions a linked list such that all nodes with values
	 * less than the target appear before any nodes that are greater than
	 * or equal to the target. The target does not need to appear in between
	 * the "two" partitions.
	 * 
	 * Time complexity: O(n) because we have to iterate over the entire linked
	 * list.
	 * 
	 * A similar approach can be done by only using one linkedlist instead of two.
	 * If an element is greater we can add it to the end, and if it is smaller, we
	 * can insert it at the head.
	 * 
	 */
	public SinglyNode partitionList(SinglyNode head, int target) {
		SinglyNode bigHead = null, bigTail = null;
		SinglyNode lilHead = null, lilTail = null;
		SinglyNode current = head;
		
		while (current != null) {
			SinglyNode next = new SinglyNode(current.getVal());
			next.setNext(null);
			if (next.getVal() >= target) {
				if (bigHead != null) {
					bigTail.setNext(next);
					bigTail = next;
				} else {
					bigHead = next;
					bigTail = next;
				}
			} else {
				if (lilHead != null) {
					lilTail.setNext(next);
					lilTail = next;
				} else {
					lilHead = next;
					lilTail = next;
				}
			}
			current = current.getNext();
		}
		
		if (lilHead != null && bigHead != null) {
			lilTail.setNext(bigHead);
		} else if (bigHead != null) {
			return bigHead;
		}
		
		return lilHead;
	}
	
	/*
	 * This method takes in two linked lists and returns the sum of
	 * the linked lists. Each linked list represents a number in
	 * reverse order, for example, list 6 -> 5 -> 2 represents 256.
	 * add this linked list with 4 -> 9 we get 256 + 49 = 5 -> 0 -> 3.
	 * 
	 * The resultant list should also be in reverse order.
	 * 
	 * Time Complexity: O(N + M + R) where N is the length of l1, M is
	 * the length of l2, and R is the number of digits in the summed value
	 * of the lists.
	 * 
	 * 
	 */
	public SinglyNode sumLists(SinglyNode l1, SinglyNode l2) {
		SinglyNode result = null, tail = null;
		int num1 = buildNumber(l1);
		int num2 = buildNumber(l2);
		
		String newNum = String.valueOf(num1 + num2);
		char[] nums = newNum.toCharArray();
		
		for (int i = nums.length-1; i >=0; i--) {
			SinglyNode next = new SinglyNode(Character.getNumericValue(nums[i]));
			if (result == null) {
				result = next;
				tail = next;
			} else {
				tail.setNext(next);
				tail = next;
			}
		}
		
		return result;
	}
	
	private int buildNumber(SinglyNode node) {
		StringBuilder newNum = new StringBuilder();
		
		while (node != null) {
			newNum.append(node.getVal());
			node = node.getNext();
		}
		
		newNum.reverse();
		int result = Integer.valueOf(newNum.toString());
		
		return result;
	}
	
	/*
	 * This method checks if the given linked list is a palindrome,
	 * that is, it's the same forward as it is backwards.
	 * e.g. 1 -> 2 -> 3 -> 2 -> 1
	 * 
	 * Time Complexity: O(n) --> We have to iterate through the list
	 * once to get all the values, then we begin iterate through the
	 * list to check if it is a palindrome, with worse case scenario,
	 * we check half the list.
	 * 
	 * Another solution would be to implement two pointers and have
	 * one move twice as fast as the other, while adding nodes from
	 * the slow pointer to a stack. Then when the fast one hits null,
	 * the slow one is at half, and we can move forward checking the
	 * second half of the list against the stack.
	 * 
	 */
	public boolean isPalindrome(SinglyNode listNode) {
		if (listNode == null) return false;
		
		List<Integer> values = new ArrayList<Integer>();
		
		while (listNode != null) {
			values.add(listNode.getVal());
			listNode = listNode.getNext();
		}
		
		int length = values.size() / 2;
		
		for (int i = values.size() - 1, j = 0; i >= length; i--, j++) {
			if (values.get(i) != values.get(j)) {
				return false;
			}
		}
		
		return true;
	}
	
	
	/* Brute force approach results with O(n^2) time, while checking all
	 * of list 1 to see if any nodes intersect with list 2.
	 * 
	 * A better approach will be to create a hashset of one of the lists
	 * and then check the other list for each node if the hashset contains
	 * that node. If we have the lengths of the lists, we will want to 
	 * use the shorter list to build the hashset. 
	 * 
	 * Time Complexity: This approach is O(n + m) where n is the length of
	 * l1 and m is the length of l2.
	 * 
	 * Space Complexity: O(n)
	 * 
	 */
	public SinglyNode intersection(SinglyNode l1, SinglyNode l2) {
		HashSet<SinglyNode> l1Nodes = new HashSet<SinglyNode>();
		
		// O(n)
		while (l1 != null) {
			l1Nodes.add(l1);
			l1 = l1.getNext();
		}
		
		// O(m), O(1) for 'contains' call
		while (l2 != null) {
			if (l1Nodes.contains(l2)) {
				return l2;
			} else if (l1Nodes.contains(l2.getNext())) {
				return l2.getNext();
			}
			l2 = l2.getNext();
		}
		
		return null;
	}
	
	/*
	 * This method checks to see if there is a loop in the linked list,
	 * and if there is, it returns the first node that it cycles on.
	 * 
	 * e.g. E -> R -> G -> Y -> Q -> Y .... returns Y
	 * 
	 * Time Complexity: O(A) where A is 1 + the length of the list before 
	 * any loops.
	 * 
	 * Space Complexity: O(B) where B is the length of the list before the
	 * loop.
	 * 
	 */
	public SinglyNode loopDetection(SinglyNode node) {
		HashSet<SinglyNode> uniques = new HashSet<SinglyNode>();
		
		while (node != null) {
			if (uniques.contains(node)) {
				return node;
			} else {
				uniques.add(node);
			}
			node = node.getNext();
		}
		
		return null;
	}
	
}
