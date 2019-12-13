import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArraysAndStringsTest {

	@Test
	void testIsUnique() {
		ArraysAndStrings aryStr = new ArraysAndStrings();
		assertTrue(aryStr.IsUnique("abcdefghijklmnopqrstuvwxyz"));
		assertFalse(aryStr.IsUnique("abcdeffedcba"));
		if (aryStr.IsUnique("abcdeffedcba") != true && aryStr.IsUnique("abcdeffedcba") != false) {
			fail("ArraysAndStrings.IsUnique() must return a boolean value.");
		}
	}

}
