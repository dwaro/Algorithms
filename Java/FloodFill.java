import java.util.*;
public class FloodFill {
	private int target;
	private int rep;
	
	public void setTarget(int target) {
		this.target = target;
	}
	
	public void setReplacement(int r) {
		this.rep = r;
	}

	public int[][] indexFill(int[][] matrix, int[] index, int replacement) {
		int[][] result = matrix;
		target = matrix[index[0]][index[1]];
		rep = replacement;
		
		return bfs(result, index);
	}
	
	private int[][] bfs(int[][] matrix, int[] index) {
		
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(index);
		
		HashSet<int[]> visited = new HashSet<int[]>();
		visited.add(index);
		
		while (!queue.isEmpty()) {
			//checkNeighbors(matrix, queue, index, visited)) {
			int[] top = queue.poll();
			matrix[top[0]][top[1]] = rep;
		}
		
		return matrix;
	}
	
	private boolean checkNeighbors(int[][] matrix, Queue<int[]> queue, int[] index, HashSet<int[]> visited) {
		visited.add(index);
		
		int count = 0;
		boolean found = false;
		int row = index[0], col = index[1];
		
		while (count < 8) {
			switch (count) {
			case 0:
				if (row < 1 || col < 1) {
					count++;
					break;
				}
				if (checkValue(matrix, row - 1, col - 1, visited, queue)) {
					found = true;
				};
				count++;
				break;
			case 1:
				if (row < 1) {
					count++;
					break;
				}
				if (checkValue(matrix, row - 1, col - 1, visited, queue)) {
					found = true;
				};
				count++;
				break;
			case 2:
				if (row < 1 || col > matrix[0].length - 2) {
					count++;
					break;
				}
				if (checkValue(matrix, row - 1, col + 1, visited, queue)) {
					found = true;
				};
				count++;
				break;
			case 3:
				if (col < 1) {
					count++;
					break;
				}
				if (checkValue(matrix, row, col - 1, visited, queue)) {
					found = true;
				};
				count++;
				break;
			case 4:
				if (col > matrix[0].length - 2) {
					count++;
					break;
				}
				if (checkValue(matrix, row, col + 1, visited, queue)) {
					found = true;
				};
				count++;
				break;
			case 5:
				if (row > matrix.length - 2 || col < 1) {
					count++;
					break;
				}
				if (checkValue(matrix, row + 1, col - 1, visited, queue)) {
					found = true;
				};
				count++;
				break;
			case 6:
				if (row > matrix.length - 2) {
					count++;
					break;
				}
				if (checkValue(matrix, row + 1, col, visited, queue)) {
					found = true;
				};
				count++;
				break;
			case 7:
				if (row > matrix.length - 2 || col > matrix[0].length - 1) {
					count++;
					break;
				}
				if (checkValue(matrix, row + 1, col + 1, visited, queue)) {
					found = true;
				};
				count++;
				break;
			default:
				count++;
				break;
			}
		}
		
		return found;
	}
	
	private boolean checkValue(int[][] matrix, int r, int c, HashSet<int[]> visited, Queue<int[]> queue) {
		int[] pos = {r, c};
		if (!visited.contains(pos) && matrix[r][c] == target) {
			queue.add(pos);
			visited.add(pos);
			return true;
		}
		return false;
	}
	
}
