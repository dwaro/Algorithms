import java.util.*;


public class ArraysAndStrings {
	ArraysAndStrings() {
		
	}
	
	/* 
	 * Algorithm determines if a string has all unique characters.
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
	public boolean isUnique(String str) {
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
	
	
	/* 
	 * Algorithm is given two strings, and checks if one is a permutation of the other.
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
	public boolean checkPermutation(String str1, String str2) {
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
	
	/* 
	 * Algorithm takes a string and its length as input and replaces all occurrences of
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
	public String urLify(String str, int length) {
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
	
	/* 
	 * Implementation has time complexity = O(n), with the additional of requiring more
	 * space. 
	 * 
	 */
	public String urLify2(String str, int trueLength) {
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
	
	/* 
	 * Algorithm checks whether the input string is a permutation of a palindrome. It only
	 * checks characters that are letters.
	 * 
	 * Time complexity: O(n), we iterate through the string once, keeping track of how many
	 * keys in the map have an odd frequency (can only be a palindrome if there are 1 or
	 * less characters with an odd count).
	 * 
	 */
	public boolean palindromePermutation(String str) {
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
	
	/* 
	 * Algorithm checks to see if two strings are within 1 edits difference from
	 * each other.
	 * 
	 * Time complexity: O(n) where n is the length of the strings if they are
	 * equal lengths, otherwise n is the length of the longer string.
	 * - If difference between string lengths > 1, then the runtime is O(1).
	 * 
	 */
	public boolean oneAway(String str1, String str2) {
		if (Math.abs(str1.length() - str2.length()) > 1) return false;
		if (str1.equals(str2)) return true;
		
		if (str1.length() < str2.length()) {
			return compareStrings(str2, str1);
		}
		
		return compareStrings(str1, str2);
	}
	
	private boolean compareStrings(String s1, String s2) {
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
	
	/* 
	 * Algorithm returns a string compression, where the occurrence of contiguous
	 * letters is replaced with the letter and the count of the letter. If the
	 * compression results in a longer string, then we return the original string.
	 * 
	 * Time Complexity: O(n);
	 * 
	 */
	public String compress(String s1) {
		int s1Length = s1.length();
		if (s1Length == 1) return s1;
		
		StringBuilder result = new StringBuilder();
		
		int count = 0;
		for (int i = 0; i < s1Length; i++) {
			count++;
			char val = s1.charAt(i);
			if (i + 1 >= s1Length || val != s1.charAt(i+1)) {
				result.append(String.valueOf(val) + String.valueOf(count));
				if (result.length() >= s1Length) return s1;
				count = 0;
			}
		}
		
		String compressed = result.toString();
		return compressed.length() >= s1Length ? s1 : compressed;
	}
	
	/* 
	 * This method rotates an image by 90 degrees. It takes an N x N matrix to
	 * represent the image. Each pixel in the image is represented by an integer.
	 * 
	 * | 0 0 0 1 |     | 0 0 0 0 |
	 * | 0 1 1 1 | --> | 1 1 1 0 |
	 * | 0 1 1 1 |	   | 1 1 1 0 |
	 * | 0 1 1 1 |	   | 1 1 1 1 |
	 * 
	 * Rotating the matrix requires O(n^2) time, assuming the matrix is n x n.
	 * 
	 * This approach uses O(n^2) space, but if we edit it in place, we can
	 * achieve O(1) space.
	 * 
	 */
	public int[][] rotate90(int[][] matrix) {
		int[][] newmatrix = new int[matrix.length][matrix[0].length];
		int newrow = 0, newcol = 0, val = 0;
		int width = matrix[0].length;
		
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[0].length; col++) {
				val = matrix[row][col];
				newrow = col;
				newcol = width - 1 - row;
				newmatrix[newrow][newcol] = val;
			}
		}
		
		return newmatrix;
		
	}
	
	/* 
	 * This approach is still O(n^2) since it is necessary to touch every single
	 * element of the list. However, the space complexity is reduced to O(1)
	 * since we are able to do make changes in place.
	 * 
	 */
	public void rotate90InPlace(int[][] matrix) {
		HashSet<String> visited = new HashSet<String>();
		int newrow = 0, newcol = 0, val = 0, tmpval = 0, tmprow = 0;
		int width = matrix[0].length;
		String pair = "";
		
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[0].length; col++) {
				newrow = col;
				newcol = width - 1 - row;
				tmpval = matrix[row][col];
				
				pair = String.valueOf(newrow)+newcol;
				
				while (!visited.contains(pair)) {
					val = tmpval;
					visited.add(pair);
					tmpval = matrix[newrow][newcol];
					matrix[newrow][newcol] = val;
					
					tmprow = newrow;
					newrow = newcol;
					newcol = width - 1 - tmprow;
					
					pair = String.valueOf(newrow) + newcol;
				}
			}
		}
	}
	
	/*
	 * This algorithm looks through a 2D array, and if an 0 elements
	 * are found, it replaces the entire row and column with 0s.
	 * 
	 * O(r*c) because we cannot set the rows and columns to 0s right
	 * away, but there may be other important zeros in the row or column
	 * that we need to visit first before knowing all of the rows and
	 * columns to set to zeros at the end.
	 * 
	 * Could use O(1) space by setting first row values to zeros and
	 * first column values to zeros as indicators that the row or column
	 * will be changed to 0.
	 * 
	 */
	public void zeroMatrix(int[][] matrix) {
		ArrayList<int[]> setToZero = new ArrayList<int[]>();
		int height = matrix.length;
		int width = matrix[0].length;
		
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				if (matrix[row][col] == 0) {
					int[] zero = {row, col};
					setToZero.add(zero);
				}
			}
		}
		convertZeros(matrix, setToZero, width, height);
	}
	
	private void convertZeros(int[][] matrix, ArrayList<int[]> setToZero, int width, int height) {
		int row = 0, col = 0;
		int[] zeros = new int[width];
		
		for (int[] zero: setToZero) {
			row = zero[0];
			col = zero[1];
			matrix[row] = zeros;
			for (int i = 0; i < height; i++) {
				if (i != row) {
					matrix[i][col] = 0;
				}
			}
		}
	}
	
	/*
	 * Method checks to see if str2 is a rotation of str1. I.e. if str2 is a shift
	 * of str1 at all. With this, we know the strings must be the same length,
	 * and we know that if str2 is a substring of str1, then it must be contained within
	 * one concatenation (2 x) str1.
	 * 
	 * Time complexity is O(n) per the String.contains() search.
	 * 
	 */
	public boolean isStringRotation(String str1, String str2) {
		if (str1.length() != str2.length()) return false;
		if (str1.length() == 0) return true;
		
		String str1str1 = str1+str1;
		
		return str1str1.contains(str2);
	}

}
