/**
 * Problem Description from LeetCode: "Given a List of words, return the words
 * that can be typed using letters of alphabet on only one row's of American
 * keyboard like the image below.
 *
 * e.g.
 * Input: ["Hello", "Alaska", "Dad", "Peace"]
 * Output: ["Alaska", "Dad"]
 *
 * You may assume the words only contain alphabetical characters."
 *
 */
class Solution {
  /**
   * This method finds words in an array of Strings that can be typed using
   * only a single row of an American keyboard.
   * @param - words: string array of words to check for.
   **/
  public String[] findWords(String[] words) {
    HashMap<Character, Integer> letterMap = populateLetterMap();
    ArrayList<String> results = new ArrayList<String>();

    // loop over words.
    for (String word: words) {
      // set the row for this word.
      int row = letterMap.get(Character.toUpperCase(word.charAt(0)));
      boolean gtg = true; // is the word good to go?
      for (int i = 1; i < word.length(); i++) {
        // deviation from the row
        if (letterMap.get(Character.toUpperCase(word.charAt(i))) != row) {
          gtg = false;
          break;
        }
      }
      if (gtg) results.add(word);
    }

    // convert to String array
    String[] output = new String[results.size()];
    for (int i = 0; i < results.size(); i++) {
      output[i] = results.get(i);
    }

    return output;
  }

  /**
   * This method returns a mapping of each letter to their respective row on the
   * keyboard.
   **/
  private HashMap<Character, Integer> populateLetterMap() {
    HashMap<Character, Integer> letterMap = new HashMap<Character, Integer>();
    letterMap.put('A', 1);
    letterMap.put('B', 0);
    letterMap.put('C', 0);
    letterMap.put('D', 1);
    letterMap.put('E', 2);
    letterMap.put('F', 1);
    letterMap.put('G', 1);
    letterMap.put('H', 1);
    letterMap.put('I', 2);
    letterMap.put('J', 1);
    letterMap.put('K', 1);
    letterMap.put('L', 1);
    letterMap.put('M', 0);
    letterMap.put('N', 0);
    letterMap.put('O', 2);
    letterMap.put('P', 2);
    letterMap.put('Q', 2);
    letterMap.put('R', 2);
    letterMap.put('S', 1);
    letterMap.put('T', 2);
    letterMap.put('U', 2);
    letterMap.put('V', 0);
    letterMap.put('W', 2);
    letterMap.put('X', 0);
    letterMap.put('Y', 2);
    letterMap.put('Z', 0);
    return letterMap;
  }
}
