import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class FloodFillTest {
	FloodFill ff = new FloodFill();
	
	int[][] test1 = {
			{0, 0, 0, 0, 0},
			{0, 1, 1, 0, 0},
			{0, 1, 1, 0, 0}
	};
	int[][] test2 = {
			{1, 0, 1, 0, 1},
			{0, 1, 0, 1, 0},
			{1, 0, 1, 0, 1}
	};

	@Test
	void testIndexFill() {
		int[][] result1 = {
				{8, 8, 8, 8, 8},
				{8, 1, 1, 8, 8},
				{8, 1, 1, 8, 8}
		};
		
		int[] index = {0, 3};
		assertTrue(Arrays.deepEquals(result1, ff.indexFill(test1, index, 8)));
	}
	
	@Test
	void testEntireFill() {
		
	}

}
