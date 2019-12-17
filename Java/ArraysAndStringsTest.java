import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

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
	
	@Test
	void testCompress() {
		assertEquals("a2b1c5a3", aryStr.Compress("aabcccccaaa"));
		assertEquals("a", aryStr.Compress("a"));
		assertEquals("abc", aryStr.Compress("abc"));
		assertEquals("aa", aryStr.Compress("aa"));
		assertEquals("j2a4k5e1", aryStr.Compress("jjaaaakkkkke"));
		assertEquals("A2a2D3r2E2", aryStr.Compress("AAaaDDDrrEE"));
	}
	
	@Test
	void testRotate90() {
		int[][] matrix = { {0,0,0,1} , {0,1,1,1}, {0,1,1,1} , {0,1,1,1} };
		int[][] newMatrix = { {0,0,0,0} , {1,1,1,0}, {1,1,1,0} , {1,1,1,1} };
		int[][] matrix1 = { {2,2,1,1} , {0,1,4,1}, {0,1,1,4} , {0,1,3,1} };
		int[][] newMatrix1 = { {0,0,0,2} , {1,1,1,2}, {3,1,4,1} , {1,4,1,1} };
		int[][] matrix2 = { {1,2,3} , {4,5,6}, {7,8,9} };
		int[][] newMatrix2 = { {7,4,1} , {8,5,2}, {9,6,3} };
		
		assertEquals(true, Arrays.deepEquals(newMatrix, aryStr.Rotate90(matrix)));
		assertEquals(true, Arrays.deepEquals(newMatrix1, aryStr.Rotate90(matrix1)));
		assertEquals(true, Arrays.deepEquals(newMatrix2, aryStr.Rotate90(matrix2)));
	}
	
	@Test
	void testRotate90InPlace() {
		int[][] matrix = { {0,0,0,1} , {0,1,1,1}, {0,1,1,1} , {0,1,1,1} };
		int[][] newMatrix = { {0,0,0,0} , {1,1,1,0}, {1,1,1,0} , {1,1,1,1} };
		int[][] matrix1 = { {2,2,1,1} , {0,1,4,1}, {0,1,1,4} , {0,1,3,1} };
		int[][] newMatrix1 = { {0,0,0,2} , {1,1,1,2}, {3,1,4,1} , {1,4,1,1} };
		int[][] matrix2 = { {1,2,3} , {4,5,6}, {7,8,9} };
		int[][] newMatrix2 = { {7,4,1} , {8,5,2}, {9,6,3} };
		
		aryStr.Rotate90InPlace(matrix);
		aryStr.Rotate90InPlace(matrix1);
		aryStr.Rotate90InPlace(matrix2);
		
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
		
		aryStr.ZeroMatrix(matrix);
		aryStr.ZeroMatrix(matrix1);
		aryStr.ZeroMatrix(matrix2);
		
		assertEquals(true, Arrays.deepEquals(newMatrix, matrix));
		assertEquals(true, Arrays.deepEquals(newMatrix1, matrix1));
		assertEquals(true, Arrays.deepEquals(newMatrix2, matrix2));
	}

}
