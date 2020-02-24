import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class ArraysAndStringsTest {
	ArraysAndStrings aryStr = new ArraysAndStrings();

	@Test
	void testIsUnique() {
		assertTrue(aryStr.isUnique("abcdefghijklmnopqrstuvwxyz"));
		assertFalse(aryStr.isUnique("abcdeffedcba"));
		if (aryStr.isUnique("abcdeffedcba") != true && aryStr.isUnique("abcdeffedcba") != false) {
			fail("ArraysAndStrings.IsUnique() must return a boolean value.");
		}
	}

	@Test
	void testCheckPermutation() {
		assertTrue(aryStr.checkPermutation("Hello", "elloH"));
		assertTrue(aryStr.checkPermutation("stressed", "desserts"));
		assertFalse(aryStr.checkPermutation("Hello", "hello"));
		assertFalse(aryStr.checkPermutation("cats and dogs", "chocolate pillows"));
		if (aryStr.checkPermutation("Hello", "elloH") != true && aryStr.checkPermutation("Hello", "elloH") != false) {
			fail("ArraysAndStrings.CheckPermutation() must return a boolean value.");
		}
	}
	
	@Test
	void testURLify() {
		assertEquals("Hello,%20my%20name%20is%20David", aryStr.urLify("Hello, my name is David        ", 23));
		assertEquals("Mr%20John%20Smith", aryStr.urLify("Mr John Smith    ", 13));
	}
	
	@Test
	void testURLify2() {
		assertEquals("Hello,%20my%20name%20is%20David", aryStr.urLify("Hello, my name is David        ", 23));
		assertEquals("Mr%20John%20Smith", aryStr.urLify("Mr John Smith    ", 13));
	}
	
	@Test
	void testPalindromePermutation() {
		assertTrue(aryStr.palindromePermutation("taco cat"));
		assertTrue(aryStr.palindromePermutation("tcac ota"));
		assertFalse(aryStr.palindromePermutation("tca ota"));
	}
	
	@Test
	void testOneAway() {
		assertTrue(aryStr.oneAway("pale", "ale"));
		assertTrue(aryStr.oneAway("pales", "pale"));
		assertTrue(aryStr.oneAway("pale", "bale"));
		assertTrue(aryStr.oneAway("aloha", "loha"));
		assertTrue(aryStr.oneAway("loha", "lohaa"));
		assertTrue(aryStr.oneAway("Hello", "Hello"));
		assertFalse(aryStr.oneAway("pale", "bake"));
		assertFalse(aryStr.oneAway("snake", "croc"));
		assertFalse(aryStr.oneAway("lion", "lioness"));
		assertFalse(aryStr.oneAway("Hello world", "world"));
	}
	
	@Test
	void testCompress() {
		assertEquals("a2b1c5a3", aryStr.compress("aabcccccaaa"));
		assertEquals("a", aryStr.compress("a"));
		assertEquals("abc", aryStr.compress("abc"));
		assertEquals("aa", aryStr.compress("aa"));
		assertEquals("j2a4k5e1", aryStr.compress("jjaaaakkkkke"));
		assertEquals("A2a2D3r2E2", aryStr.compress("AAaaDDDrrEE"));
	}
	
	@Test
	void testRotate90() {
		int[][] matrix = { {0,0,0,1} , {0,1,1,1}, {0,1,1,1} , {0,1,1,1} };
		int[][] newMatrix = { {0,0,0,0} , {1,1,1,0}, {1,1,1,0} , {1,1,1,1} };
		int[][] matrix1 = { {2,2,1,1} , {0,1,4,1}, {0,1,1,4} , {0,1,3,1} };
		int[][] newMatrix1 = { {0,0,0,2} , {1,1,1,2}, {3,1,4,1} , {1,4,1,1} };
		int[][] matrix2 = { {1,2,3} , {4,5,6}, {7,8,9} };
		int[][] newMatrix2 = { {7,4,1} , {8,5,2}, {9,6,3} };
		
		assertEquals(true, Arrays.deepEquals(newMatrix, aryStr.rotate90(matrix)));
		assertEquals(true, Arrays.deepEquals(newMatrix1, aryStr.rotate90(matrix1)));
		assertEquals(true, Arrays.deepEquals(newMatrix2, aryStr.rotate90(matrix2)));
	}
	
	@Test
	void testRotate90InPlace() {
		int[][] matrix = { {0,0,0,1} , {0,1,1,1}, {0,1,1,1} , {0,1,1,1} };
		int[][] newMatrix = { {0,0,0,0} , {1,1,1,0}, {1,1,1,0} , {1,1,1,1} };
		int[][] matrix1 = { {2,2,1,1} , {0,1,4,1}, {0,1,1,4} , {0,1,3,1} };
		int[][] newMatrix1 = { {0,0,0,2} , {1,1,1,2}, {3,1,4,1} , {1,4,1,1} };
		int[][] matrix2 = { {1,2,3} , {4,5,6}, {7,8,9} };
		int[][] newMatrix2 = { {7,4,1} , {8,5,2}, {9,6,3} };
		
		aryStr.rotate90InPlace(matrix);
		aryStr.rotate90InPlace(matrix1);
		aryStr.rotate90InPlace(matrix2);
		
		assertEquals(true, Arrays.deepEquals(newMatrix, matrix));
		assertEquals(true, Arrays.deepEquals(newMatrix1, matrix1));
		assertEquals(true, Arrays.deepEquals(newMatrix2, matrix2));
	}
	
	@Test
	void testZeroMatrix() {
		int[][] matrix = { {1,1,1,1} , {1,1,0,1}, {1,1,1,1} , {1,1,1,1} };
		int[][] newMatrix = { {1,1,0,1} , {0,0,0,0}, {1,1,0,1} , {1,1,0,1} };
		int[][] matrix1 = { {0,1,0} , {1,0,1}, {0,1,0} };
		int[][] newMatrix1 = { {0,0,0} , {0,0,0}, {0,0,0} };
		int[][] matrix2 = { {1,1,1,1} , {1,1,1,1}, {1,1,1,1} , {1,1,1,1} };
		int[][] newMatrix2 = { {1,1,1,1} , {1,1,1,1}, {1,1,1,1} , {1,1,1,1} };
		
		aryStr.zeroMatrix(matrix);
		aryStr.zeroMatrix(matrix1);
		aryStr.zeroMatrix(matrix2);
		
		assertEquals(true, Arrays.deepEquals(newMatrix, matrix));
		assertEquals(true, Arrays.deepEquals(newMatrix1, matrix1));
		assertEquals(true, Arrays.deepEquals(newMatrix2, matrix2));
	}
	
	@Test
	void testIsStringRotation() {
		assertTrue(aryStr.isStringRotation("zebra", "razeb"));
		assertTrue(aryStr.isStringRotation("Hello world", "worldHello "));
		assertTrue(aryStr.isStringRotation("a b c d", "a b c d"));
		assertTrue(aryStr.isStringRotation(" a b c d", "c d a b "));
		assertFalse(aryStr.isStringRotation("Rodgers", "sregdoR"));
	}
	
	@Test
	void testArrayDupes() {
		int[] test1 = {1, 4, 5, 2, 1, 4, 10, 5, 7, 8};
		int[] t1 = {1, 4, 5};
		int[] test2 = {1, 2, 2, 3, 4, 4, 5, 6, 6, 7};
		int[] t2 = {2, 4, 6};
		int[] test3 = {1};
		int[] test4 = {1, 2, 3, 4, 5};
		int[] t3 = {};
		
		assertArrayEquals(aryStr.arrayDupes(test1), t1);
		assertArrayEquals(aryStr.arrayDupes(test2), t2);
		assertArrayEquals(aryStr.arrayDupes(test3), t3);
		assertArrayEquals(aryStr.arrayDupes(test4), t3);
		
	}

}
