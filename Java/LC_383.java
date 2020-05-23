/**
 * From LeetCode: "Given an arbitrary ransom note string and another string
 * containing letters from all the magazines, write a function that will
 * return true if the ransom note can be constructed from the magazines;
 * otherwise, it will return false.
 *
 * Each letter in the magazine string can only be used once in your ransom
 * note."
 *
 * e.g.
 * ransomNote = "a", magazine = "b" --> false
 * ransomNote = "aa", magazine = "ab" --> false
 * ransomNote = "aa", magazine = "aab" --> true
 *
 * Time Complexity: O(r + m)
 * Space Complexity: O(r + m)
 *
 * where r represents the size of the ransomNote and m represents the size of
 * the magazine.
 *
 */
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] magazineArray = new char[26];

        // build map of magazine's letters
        for (char c: magazine.toCharArray()) {
            magazineArray[Character.toLowerCase(c) - 'a']++;
        }

        // verify all letters in ransomNote exist in the magazine map
        for (char c: ransomNote.toCharArray()) {
            if (magazineArray[Character.toLowerCase(c) - 'a'] == 0) {
                return false;
            } else {
                magazineArray[Character.toLowerCase(c) - 'a']--;
            }
        }

        return true;
    }
}
