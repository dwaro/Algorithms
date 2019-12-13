import java.util.*;


public class ArraysAndStrings {
	ArraysAndStrings() {
		
	}
	
	public boolean IsUnique(String str) {
		HashSet<Character> counts = new HashSet<Character>();
		char[] items = str.toCharArray();
		for (char item: items) {
			if (counts.contains(item)) {
				return false;
			} else {
				counts.add(item);
			}
		}
		return true;
	}
	
}
