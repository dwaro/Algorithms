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
	
	@Test
	void testURLify() {
		assertEquals("Hello,%20my%20name%20is%20David", aryStr.URLify("Hello, my name is David        ", 23));
		assertEquals("Mr%20John%20Smith", aryStr.URLify("Mr John Smith    ", 13));
	}
	
	@Test
	void testURLify2() {
		assertEquals("Hello,%20my%20name%20is%20David", aryStr.URLify("Hello, my name is David        ", 23));
		assertEquals("Mr%20John%20Smith", aryStr.URLify("Mr John Smith    ", 13));
	}
	
	@Test
	void testPalindromePermutation() {
		assertTrue(aryStr.PalindromePermutation("taco cat"));
		assertTrue(aryStr.PalindromePermutation("tcac ota"));
		assertFalse(aryStr.PalindromePermutation("tca ota"));
	}
	
	@Test
	void testOneAway() {
		assertTrue(aryStr.OneAway("pale", "ale"));
		assertTrue(aryStr.OneAway("pales", "pale"));
		assertTrue(aryStr.OneAway("pale", "bale"));
		assertTrue(aryStr.OneAway("aloha", "loha"));
		assertTrue(aryStr.OneAway("loha", "lohaa"));
		assertTrue(aryStr.OneAway("Hello", "Hello"));
		assertFalse(aryStr.OneAway("pale", "bake"));
		assertFalse(aryStr.OneAway("snake", "croc"));
		assertFalse(aryStr.OneAway("lion", "lioness"));
		assertFalse(aryStr.OneAway("Hello world", "world"));
	}

}
