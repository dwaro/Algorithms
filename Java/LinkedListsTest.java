import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;

class LinkedListsTest {
	LinkedLists ls = new LinkedLists();
	
	@Test
	void testRemoveDups() {
		SinglyNode n1 = new SinglyNode(1);
		SinglyNode n2 = new SinglyNode(2);
		SinglyNode n3 = new SinglyNode(2);
		SinglyNode n4 = new SinglyNode(4);
		SinglyNode n5 = new SinglyNode(5);
		n1.setNext(n2);
		n2.setNext(n3);
		n3.setNext(n4);
		n4.setNext(n5);
		
		ArrayList<SinglyNode> newlist1 = new ArrayList<SinglyNode>();
		newlist1.add(n1);
		
		ls.removeDups1(n1);
		ArrayList<SinglyNode> list1 = buildList(n1);
		
		n2.setNext(n4);
		newlist1.add(n2);
		newlist1.add(n4);
		newlist1.add(n5);
		
		assertTrue(newlist1.equals(list1));	
		
	}
	
	@Test
	void testFindIthElement() {
		SinglyNode n1 = new SinglyNode(1);
		SinglyNode n2 = new SinglyNode(2);
		SinglyNode n3 = new SinglyNode(3);
		SinglyNode n4 = new SinglyNode(4);
		SinglyNode n5 = new SinglyNode(5);
		n1.setNext(n2);
		n2.setNext(n3);
		n3.setNext(n4);
		n4.setNext(n5);
		
		SinglyNode result1 = ls.findIthElement(n1, 2);
		SinglyNode result2 = ls.findIthElement(n1, 5);
		assertTrue(result1.equals(n3));
		assertNull(result2);
	}
	
	@Test
	void testFindKthToLastElement() {
		SinglyNode n1 = new SinglyNode(1);
		SinglyNode n2 = new SinglyNode(2);
		SinglyNode n3 = new SinglyNode(3);
		SinglyNode n4 = new SinglyNode(4);
		SinglyNode n5 = new SinglyNode(5);
		n1.setNext(n2);
		n2.setNext(n3);
		n3.setNext(n4);
		n4.setNext(n5);
		
		SinglyNode result1 = ls.findKthToLastElement(n1, 2);
		SinglyNode result2 = ls.findKthToLastElement(n1, 5);
		SinglyNode result3 = ls.findKthToLastElement(n1, 1);
		SinglyNode result4 = ls.findKthToLastElement(n1, 6);
		assertTrue(result1.equals(n4));
		assertTrue(result2.equals(n1));
		assertTrue(result3.equals(n5));
		assertNull(result4);
	}
	
	private ArrayList<SinglyNode> buildList(SinglyNode head) {
		ArrayList<SinglyNode> result = new ArrayList<SinglyNode>();
		while (head != null) {
			result.add(head);
			head = head.getNext();
		}
		return result;
	}
	
	private void printLinkedList(SinglyNode head) {
		while (head != null) {
			System.out.println(head.getVal());
			head = head.getNext();
		}
	}

}
