import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QueueTest {
	Queue<Integer> queue = new Queue<Integer>(5);

	@Test
	void peekTest() {
		assertEquals(5, queue.peek());
	}
	
	@Test
	void addTest() {
		queue.add(10);
		assertEquals(10, queue.peekEnd());
		assertEquals(5, queue.peek());
	}
	
	@Test
	void removeTest1() {
		queue.add(3);
		queue.add(6);
		queue.add(12);
		queue.add(9);
		int top = (int) queue.remove();
		
		assertEquals(5, top);
		assertEquals(10, queue.peek());
	}
	
	@Test
	void isEmptyTest1() {
		assertFalse(queue.isEmpty());
	}
	
	@Test
	void removeTest2() {
		int top = (int) queue.remove();
		assertEquals(10, top);
		assertEquals(3, queue.peek());
		
		top = (int) queue.remove();
		assertEquals(3, top);
		assertEquals(6, queue.peek());
		
		top = (int) queue.remove();
		assertEquals(6, top);
		assertEquals(12, queue.peek());
		
		top = (int) queue.remove();
		assertEquals(12, top);
		assertEquals(9, queue.peek());
		
		top = (int) queue.remove();
		assertEquals(9, top);
		assertNull(queue.peek());
	}
	
	@Test
	void isEmptyTest2() {
		assertTrue(queue.isEmpty());
	}
	
	@Test
	void peeksTest2() {
		assertNull(queue.peek());
		assertNull(queue.peekEnd());
		
		queue.add(11);
		
		assertEquals(11, queue.peek());
		assertEquals(11, queue.peekEnd());
		
		queue.add(14);
		
		assertEquals(11, queue.peek());
		assertEquals(14, queue.peekEnd());
		
		int top = (int) queue.remove();
		
		assertEquals(11, top);
	}
}
