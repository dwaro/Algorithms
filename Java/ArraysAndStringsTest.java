import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArraysAndStringsTest {
	ArraysAndStrings aryStr = new ArraysAndStrings();

	@Test
	void testIsUnique() {
		assertTrue(aryStr.IsUnique("abcdefghijklmnopqrstuvwxyz"));
		assertFalse(aryStr.IsUnique("abcdeffedcba"));
		if (aryStr.IsUnique("abcdeffedcba") != true && aryStr.IsUnique("abcdeffedcba") != false) {
			fail("ArraysAndStrings.IsUnique() must return a boolean value.");
		}
	}

	@Test
	void testCheckPermutation() {
		assertTrue(aryStr.CheckPermutation("Hello", "elloH"));
		assertTrue(aryStr.CheckPermutation("stressed", "desserts"));
		assertFalse(aryStr.CheckPermutation("Hello", "hello"));
		assertFalse(aryStr.CheckPermutation("cats and dogs", "chocolate pillows"));
		if (aryStr.CheckPermutation("Hello", "elloH") != true && aryStr.CheckPermutation("Hello", "elloH") != false) {
			fail("ArraysAndStrings.CheckPermutation() must return a boolean value.");
		}
	}

}
