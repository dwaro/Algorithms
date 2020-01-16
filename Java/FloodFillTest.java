import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class FloodFillTest {
	FloodFill ff = new FloodFill();

	@Test
	void testReplaceAt1() {
		int[][] matrix = createMatrix();
		
		int[][] result1 = {
				{7, 7, 7, 7},
				{0, 0, 0, 7},
				{0, 7, 0, 0},
				{7, 7, 0, 0}
		};
		
		int[] start = {1, 1};
		ff.replaceAt(start, matrix, 0);
		
		assertTrue(Arrays.deepEquals(matrix, result1));
	}
	
	@Test
	void testReplaceAt2() {
		int[][] matrix = createMatrix();
				
		int[][] result2 = {
			{0, 0, 0, 0},
			{3, 3, 3, 0},
			{3, 7, 3, 3},
			{7, 7, 3, 3}
		};
				
		int[] start = {0, 0};
		ff.replaceAt(start, matrix, 0);
		
		assertTrue(Arrays.deepEquals(matrix, result2));
	}
	
	@Test
	void testReplaceAt3() {
		int[][] matrix = bigMatrix();
				
		int[][] result3 = {
			{1, 1, 8, 8, 8, 8, 8, 8, 1, 5, 5, 5, 5, 1},
			{1, 1, 8, 1, 1, 1, 1, 1, 1, 5, 1, 1, 5, 1},
			{1, 1, 1, 1, 1, 1, 1, 1, 1, 5, 1, 1, 5, 1},
			{1, 5, 5, 5, 5, 5, 5, 1, 1, 5, 1, 1, 5, 5},
			{1, 5, 1, 1, 1, 1, 5, 5, 5, 5, 1, 5, 1, 5},
			{1, 5, 1, 8, 8, 1, 1, 1, 1, 1, 1, 5, 1, 5},
			{1, 5, 1, 8, 8, 8, 8, 8, 1, 1, 1, 5, 1, 5},
			{1, 5, 1, 8, 1, 1, 8, 8, 1, 1, 1, 5, 5, 5}
		};
				
		int[] start = {3, 1};
		ff.replaceAt(start, matrix, 5);
		
		assertTrue(Arrays.deepEquals(matrix, result3));
	}
	
	private int[][] createMatrix() {
		int[][] matrix = {
				{7, 7, 7, 7},
				{3, 3, 3, 7},
				{3, 7, 3, 3},
				{7, 7, 3, 3}
		};
		return matrix;
	}
	
	private int[][] bigMatrix() {
		int[][] matrix = {
				{1, 1, 8, 8, 8, 8, 8, 8, 1, 8, 8, 8, 8, 1},
				{1, 1, 8, 1, 1, 1, 1, 1, 1, 8, 1, 1, 8, 1},
				{1, 1, 1, 1, 1, 1, 1, 1, 1, 8, 1, 1, 8, 1},
				{1, 8, 8, 8, 8, 8, 8, 1, 1, 8, 1, 1, 8, 8},
				{1, 8, 1, 1, 1, 1, 8, 8, 8, 8, 1, 8, 1, 8},
				{1, 8, 1, 8, 8, 1, 1, 1, 1, 1, 1, 8, 1, 8},
				{1, 8, 1, 8, 8, 8, 8, 8, 1, 1, 1, 8, 1, 8},
				{1, 8, 1, 8, 1, 1, 8, 8, 1, 1, 1, 8, 8, 8}
		};
		return matrix;
	}

}
