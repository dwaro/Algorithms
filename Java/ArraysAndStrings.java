import java.util.*;


public class ArraysAndStrings {
	ArraysAndStrings() {
		
	}
	
	/* Algorithm determines if a string has all unique characters.
	 * 
	 * Is string ASCII or UNICODE?
	 * ---------------------------
	 * 	- ASCII: uses 7 bit encoding to represent 128 characters, uses less storage,
	 * 	  however, is more limited in its "alphabet". It is not standardized. Extended
	 * 	  ASCII uses 8 bit encoding and can represent 256 characters.
	 * 
	 * 	- UNICODE: uses variable amounts of 8, 16, and 32 bit encodings, lets you
	 * 	  have a larger alphabet, but also takes much more storage. UNICODE is
	 * 	  standardized and can represent most languages of the world. UTF-8 is
	 * 	  capable of encoding over 1 million characters.
	 * 
	 * We will assume ASCII for this problem.
	 *
	 * Time complexity = O(n) with n being the length of the string.
	 * Space complexity = O(n)
	 *
	 */
	public boolean IsUnique(String str) {
		if (str.length() > 128) return false;
		
		HashSet<Character> tracker = new HashSet<Character>();
		
		for (int i = 0; i < str.length(); i++) {
			char val = str.charAt(i);
			if (tracker.contains(val)) {
				return false;
			} else {
				tracker.add(val);
			}
		}
		return true;
	}
	
}
