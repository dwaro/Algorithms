import java.util.HashMap;

public class FloodFill {
	private int largestClass;
	private HashMap<String, String> visited = new HashMap<String, String>();
	private HashMap<String, String> tempMem = new HashMap<String, String>();
	private int largestClassSize;
	private int keyIndex;
	private int size;
	private int capacity;
	private int buckets = 10;
	private static double threshold = 0.4;
	
	public FloodFill(int[][] grid) {
		
	}
	
	public int[] largestClassArea(int[][] grid) {
		int[] a = {largestClass, largestClassSize};
		return a;
	}
	
	private int hashit(int key) {
		if (size > threshold * capacity) {
			resizeTable();
		}
		keyIndex = (key*key)%buckets;
		return keyIndex;
	}
	
	private void resizeTable() {
		buckets = buckets * 2;
		visited = tempMem;
	}
}
