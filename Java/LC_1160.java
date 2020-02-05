/*

Leetcode problem 1160: Find Words That Can Be Formed by Characters

"You are given an array of strings, words and a string, chars. A string is good
if it can be formed by characters from chars (each character can only be used
once). Return the sum of lengths of all good strings in words."

Time complexity: O(n + m * w) where n is the length of chars, m is the number of
words, and w is the length of each word.

*/

class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] charCounts = new int[128];

        for (int i = 0; i < chars.length(); i++) {              // O(n)
            charCounts[chars.charAt(i)]++;
        }

        int sum = 0;

        for (String word: words) {                              // O(m)
            boolean holds = true;
            int[] wordCounts = new int[128];

            for (int j = 0; j < word.length(); j++) {           // O(w)
                char letter = word.charAt(j);
                if (wordCounts[letter] < charCounts[letter]) {
                    wordCounts[letter]++;
                } else {
                    holds = false;
                    break;
                }
            }
            if (holds) sum += word.length();
        }

        return sum;

    }
}
