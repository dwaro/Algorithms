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
	
	/* Algorithm takes a string and its length as input and replaces all occurrences of
	 * a space with '%20'.
	 * 
	 * Assumption is that the string has space at the end to hold the additional characters.
	 * 
	 * Time complexity: O(n log(n))
	 * 
	 * Could improve to O(n) by simply iterating through the char array, and noting the indices
	 * of spaces. Then create a new array of length of the string, and if the index is a space
	 * index, then add in the %20, and then continue moving forward until you hit
	 * str.length - 2 * #_of_spaces.
	 * 
	 * 
	 */
	public String URLify(String str, int length) {
		char[] letters = str.toCharArray();
		
		for (int i = 0; i < letters.length; i++) {
			int val = letters[i];
			if (val == ' ') {
				shiftRight(letters, i);
				letters[i] = '%';
				letters[i+1] = '2';
				letters[i+2] = '0';
			}
		}
		
		String result = String.valueOf(letters);
		
		return result;
	}
	
	private void shiftRight(char[] letters, int index) {
		for (int i = letters.length - 3; i > index; i--) {
			letters[i+2] = letters[i];
		}
	}
	
	/* Implementation has time complexity = O(n), with the additional of requiring more
	 * space. 
	 * 
	 */
	public String URLify2(String str, int trueLength) {
		char[] letters = str.toCharArray();
		char[] result = new char[letters.length];
		
		int pos = 0;
		for (int i = letters.length; i < trueLength; i++) {
			if (letters[i] == ' ') {
				result[pos] = '%';
				result[pos++] = '2';
				result[pos++] = '0';
			} else {
				result[i] = letters[i];
			}
			pos++;
		}
		
		return String.valueOf(result);
	}
	
	/* Algorithm checks whether the input string is a permutation of a palindrome. It only
	 * checks characters that are letters.
	 * 
	 * Time complexity: O(n), we iterate through the string once, keeping track of how many
	 * keys in the map have an odd frequency (can only be a palindrome if there are 1 or
	 * less characters with an odd count).
	 * 
	 */
	public boolean PalindromePermutation(String str) {
		HashMap<Character, Integer> lettermap = new HashMap<Character, Integer>();
		
		int oddCount = 0, frequency = 0;
		
		for (int i = 0; i < str.length(); i++) {
			char val = str.charAt(i);
			if (Character.isLetter(val)) {
				if (!lettermap.containsKey(val)) {
					oddCount++;
					lettermap.put(val, 1);
				} else {
					frequency = lettermap.get(val);
					if (frequency % 2 == 0) {
						oddCount++;
					} else {
						oddCount--;
					}
					lettermap.put(val, frequency + 1);
				}
			}
		}
		
		if (oddCount < 2) return true;
		return false;
	}
	
	/* Algorithm checks to see if two strings are within 1 edits difference from
	 * each other.
	 * 
	 * Time complexity: O(n) where n is the length of the strings if they are
	 * equal lengths, otherwise n is the length of the longer string.
	 * - If difference between string lengths > 1, then the runtime is O(1).
	 * 
	 */
	public boolean OneAway(String str1, String str2) {
		if (Math.abs(str1.length() - str2.length()) > 1) return false;
		if (str1.equals(str2)) return true;
		
		if (str1.length() < str2.length()) {
			CompareStrings(str2, str1);
		}
		
		return CompareStrings(str1, str2);
	}
	
	private boolean CompareStrings(String s1, String s2) {
		int pos = 0, diffs = 0;
		for (int i = 0; i < s1.length(); i++) {
			if (pos < s2.length() && s1.charAt(i) != s2.charAt(pos)) {
				diffs++;
				if (s1.length() != s2.length()) pos--;
			}
			if (diffs > 1) return false;
			pos++;
		}
		return true;
	}
	
}
