import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StackTest {
	
	@Test
	void testInitialize() {
		Stack<Integer> s1 = new Stack<Integer>();
		assertTrue(s1.isEmpty());
		
		Stack<Integer> s2 = new Stack<Integer>(2);
		assertFalse(s2.isEmpty());
	}

}
