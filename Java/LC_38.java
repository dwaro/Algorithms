/*
 * The count-and-say sequence is the sequence of integers with the first five
 * terms as following:
 *  1.     1
 *  2.     11
 *  3.     21
 *  4.     1211
 *  5.     111221
 *
 *  1 is read off as "one 1" or 11.
 *  11 is read off as "two 1s" or 21.
 *  21 is read off as "one 2, then one 1" or 1211.
 *
 * Given an integer n where 1 ≤ n ≤ 30, return the nth term of the
 * count-and-say sequence.
 *
 * Each term of the sequence of integers will be represented as a string.
 *
 * Example: input 3 --> return "21"
*/

class Solution {
    public String countAndSay(int n) {
        String num = "1";
        if (n < 2) return num;

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < n; i++) {
            sb.setLength(0);
            int pos = 0, count = 0;
            int size = num.length();
            char val;

            while (pos < size) {
                val = num.charAt(pos);
                count = 1;
                while (pos < size - 1 && num.charAt(pos+1) == val) {
                    count++;
                    pos++;
                }
                pos++;
                sb.append(count);
                sb.append(val);
            }
            num = sb.toString();
        }
        return sb.toString();
    }
}
