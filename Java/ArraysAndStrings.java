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
	
	
	/* Algorithm is given two strings, and checks if one is a permutation of the other.
	 * 
	 * If the two strings are of different lengths, the cannot be permutations of each other.
	 * The permutations are case sensitive, so "Hello World" is different than "hello world".
	 * 
	 * Time complexity: O(n) where n is the length of both strings. We look through all of
	 * string 1, length n. We then look through all of string 2 unless we find it has a
	 * variance from string 1, in which case we return early.
	 * 
	 * A second solution is to sort the strings as char arrays and return whether they are
	 * equal to each other.
	 * 
	 */
	public boolean CheckPermutation(String str1, String str2) {
		if (str1.length() != str2.length()) return false;
		
		HashMap<Character, Integer> map1 = new HashMap<Character, Integer>();
		
		for (int i = 0; i < str1.length(); i++) {
			char val = str1.charAt(i);
			if (map1.containsKey(val)) {
				map1.put(val, map1.get(val) + 1);
			} else {
				map1.put(val, 1);
			}
		}
		
		for (int j = 0; j < str2.length(); j++) {
			char val = str2.charAt(j);
			if (!map1.containsKey(val) || map1.get(val) < 1) return false;
			map1.put(val, map1.get(val) - 1);
		}
		
		return true;
	}
	
}
