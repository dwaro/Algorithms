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
	
	@Test
	void testDeleteNode() {
		SinglyNode n1 = new SinglyNode(1);
		SinglyNode n2 = new SinglyNode(2);
		SinglyNode n3 = new SinglyNode(3);
		SinglyNode n4 = new SinglyNode(4);
		SinglyNode n5 = new SinglyNode(5);
		n1.setNext(n2);
		n2.setNext(n3);
		n3.setNext(n4);
		n4.setNext(n5);
		
		ls.deleteNode(n2);
		ArrayList<Integer> list1 = buildIntList(n1);
		ArrayList<Integer> newlist1 = new ArrayList<Integer>();
		
		newlist1.add(n1.getVal());
		newlist1.add(n3.getVal());
		newlist1.add(n4.getVal());
		newlist1.add(n5.getVal());
		
		assertTrue(newlist1.equals(list1));
		
	}
	
	@Test
	void testPartitionList() {
		SinglyNode n1 = new SinglyNode(1);
		SinglyNode n2 = new SinglyNode(10);
		SinglyNode n3 = new SinglyNode(5);
		SinglyNode n4 = new SinglyNode(4);
		SinglyNode n5 = new SinglyNode(8);
		n1.setNext(n2);
		n2.setNext(n3);
		n3.setNext(n4);
		n4.setNext(n5);
		
		ArrayList<Integer> test1 = buildIntList(ls.partitionList(n1, 5));
		ArrayList<Integer> results = new ArrayList<Integer>();
		results.add(1);
		results.add(4);
		results.add(10);
		results.add(5);
		results.add(8);
		
		assertEquals(results, test1);
		
		ArrayList<Integer> test2 = buildIntList(ls.partitionList(n1, 7));
		results.clear();
		results.add(1);
		results.add(5);
		results.add(4);
		results.add(10);
		results.add(8);
		
		assertEquals(results, test2);
		
		ArrayList<Integer> test3 = buildIntList(ls.partitionList(n1, 0));
		results.clear();
		results.add(1);
		results.add(10);
		results.add(5);
		results.add(4);
		results.add(8);
		
		assertEquals(results, test3);
		
	}
	
	@Test
	void testSumLists() {
		ArrayList<Integer> test = new ArrayList<Integer>();
		
		SinglyNode n1 = new SinglyNode(4);
		SinglyNode n2 = new SinglyNode(5);
		SinglyNode n3 = new SinglyNode(1);
		SinglyNode n4 = new SinglyNode(6);
		n1.setNext(n2);
		n3.setNext(n4);
		ArrayList<Integer> result1 = buildIntList(ls.sumLists(n1, n3));
		
		test.add(5);
		test.add(1);
		test.add(1);
		
		assertEquals(test, result1);
		test.clear();
		
		SinglyNode a = new SinglyNode(1);
		SinglyNode b = new SinglyNode(2);
		SinglyNode c = new SinglyNode(3);
		SinglyNode d = new SinglyNode(4);
		SinglyNode e = new SinglyNode(5);
		SinglyNode f = new SinglyNode(6);
		SinglyNode g = new SinglyNode(7);
		SinglyNode h = new SinglyNode(8);
		a.setNext(b);
		b.setNext(c);
		c.setNext(d);
		d.setNext(e);
		f.setNext(g);
		g.setNext(h);
		ArrayList<Integer> result2 = buildIntList(ls.sumLists(a, f));
		
		test.add(7);
		test.add(9);
		test.add(1);
		test.add(5);
		test.add(5);
		
		assertEquals(test, result2);
		test.clear();
		
	}
	
	@Test
	void testIsPalindrome() {
		SinglyNode a = new SinglyNode(1);
		SinglyNode b = new SinglyNode(2);
		SinglyNode c = new SinglyNode(1);
		a.setNext(b);
		b.setNext(c);
		
		assertTrue(ls.isPalindrome(a));
		
		SinglyNode d = new SinglyNode(2);
		SinglyNode e = new SinglyNode(2);
		SinglyNode f = new SinglyNode(1);
		d.setNext(e);
		e.setNext(f);
		
		assertFalse(ls.isPalindrome(d));
		
		SinglyNode g = new SinglyNode(5);
		SinglyNode h = new SinglyNode(4);
		SinglyNode i = new SinglyNode(4);
		SinglyNode j = new SinglyNode(3);
		SinglyNode k = new SinglyNode(3);
		SinglyNode l = new SinglyNode(4);
		SinglyNode m = new SinglyNode(4);
		SinglyNode n = new SinglyNode(5);
		g.setNext(h);
		h.setNext(i);
		i.setNext(j);
		j.setNext(k);
		k.setNext(l);
		l.setNext(m);
		m.setNext(n);
		
		assertTrue(ls.isPalindrome(g));
		
	}
	
	// -------------------- Helper Methods -------------------------
	
	private ArrayList<SinglyNode> buildList(SinglyNode head) {
		ArrayList<SinglyNode> result = new ArrayList<SinglyNode>();
		while (head != null) {
			result.add(head);
			head = head.getNext();
		}
		return result;
	}
	
	private ArrayList<Integer> buildIntList(SinglyNode head) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		while (head != null) {
			result.add(head.getVal());
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
