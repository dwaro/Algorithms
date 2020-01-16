import java.util.Queue;
import java.util.LinkedList;

public class FloodFill {
	/*
	 * This class is used to handle matrix operations on a 2D matrix, also to be thought of as
	 * raster data or images.
	 * 
	 */
	
	void replaceAt(int[] start, int[][] matrix, int replacement) {
		Queue<int[]> q = new LinkedList<>();
		q.add(start);
		
		int target = matrix[start[0]][start[1]];
		
		while(!q.isEmpty()) {
			int count = 0;
			while (count < 4) {
				checkNeighbor(q, matrix, target, count);
				count++;
			}
			int[] current = q.remove();
			matrix[current[0]][current[1]] = replacement;
		}
	}
	
	void checkNeighbor(Queue<int[]> q, int[][] matrix, int target, int count) {
		int[] pos = q.peek();
		int row = pos[0], col = pos[1];
		int width = matrix[0].length;
		int height = matrix.length;
		
		switch(count) {
			case 0:
				if (row >= 1) {
					if (matrix[row-1][col] == target) {
						int[] found = {row-1, col};
						q.add(found);
					}
				}
				break;
			case 1:
				if (col >= 1) {
					if (matrix[row][col-1] == target) {
						int[] found = {row, col-1};
						q.add(found);
					}
				}
				break;
			case 2:
				if (col <= width - 2) {
					if (matrix[row][col+1] == target) {
						int[] found = {row, col+1};
						q.add(found);
					}
				}
				break;
			case 3:
				if (row <= height - 2) {
					if (matrix[row+1][col] == target) {
						int[] found = {row+1, col};
						q.add(found);
					}
				}
				break;
		}
	}

	void mask(int threshold, int[][] matrix, String side) {
		int adjust = 1;
		
		if (side.equals("bottom")) {
			adjust = -1;
			threshold *= -1;
		}
		
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[0].length; col++) {
				if (matrix[row][col] * adjust > threshold) {
					matrix[row][col] = 0;
				}
			}
		}
	}
}
