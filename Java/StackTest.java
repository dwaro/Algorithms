import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StackTest {
	Stack<Integer> stack = new Stack<Integer>();
	
	@Test
	void testInitialize() {
		Stack<Integer> s1 = new Stack<Integer>();
		assertTrue(s1.isEmpty());
		
		Stack<Integer> s2 = new Stack<Integer>(2);
		assertFalse(s2.isEmpty());
	}
	
	@Test
	void testPeek() {
		assertEquals(null, stack.peek());
		
		stack.push(1);
		
		assertEquals(1, stack.peek());
		
		stack.poll();
		
		assertEquals(null, stack.peek());
	}
	
	@Test
	void testPush() {
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		
		assertEquals(4, stack.peek());
	}
	
	@Test
	void testPoll() {
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		
		int topVal = (int) stack.poll();
		assertEquals(4, topVal);
		assertEquals(3, stack.peek());
		
		stack.poll();
		stack.poll();
		
		assertEquals(1, stack.peek());
		assertFalse(stack.isEmpty());
		
		stack.poll();
		
		assertNull(stack.peek());
		assertTrue(stack.isEmpty());
	}

}
