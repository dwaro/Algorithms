/**
 * From LeetCode: 
 * "Given two equal-size strings s and t. In one step you can choose any 
 * character of t and replace it with another character.
 * 
 * Return the minimum number of steps to make t an anagram of s.
 * 
 * An Anagram of a string is a string that contains the same characters with a 
 * different (or the same) ordering."
 * 
 * Test Cases
 * -----------
 * Input: s = "bab", t = "aba"
 * Output: 1
 * Explanation: Replace the first 'a' in t with b, t = "bba" which is anagram 
 * of s.
 * 
 * Input: s = "anagram", t = "mangaar"
 * Output: 0
 * Explanation: "anagram" and "mangaar" are anagrams. 
 * 
 */

class Solution {
    /**
     * Time Complexity: O(s + t + r), where r is the length of result
     * 
     * Space Complexity: O(r) where r is the space of result
     * 
     * 
     * @param s - string we are trying to make t an anagram of
     * @param t - string we need to modify to make an anagram of s
     * @return the minimum # of steps to make t an anagram of s/
     */
    public int minSteps(String s, String t) {
        
        // space O(26)
        int[] result = new int[26];
        
        // time O(s)
        for (char c: s.toCharArray()) {
            int val = c - 97;
            result[val]++;
        }
        
        // time O(t)
        for (char c: t.toCharArray()) {
            int val = c - 97;
            result[val]--;
        }
        
        int count = 0;
        
        // time O(26)
        for (int i = 0; i < 26; i++) {
            int num = result[i];
            if (num > 0) {
                count += num;
            } else if (num < 0) {
                count -= num;
            }
        }
        
        // we want distance from 0
        int output = Math.abs(count);
        
        // if odd, we need to take 1 extra step to convert t to s
        if (output % 2 == 0) return output / 2;
        return (output / 2) + 1;
    }
}