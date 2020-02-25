/*

The Starbucks Roastery just opened and there's a line full of people waiting to
get inside! Each person in line has a sticker that represents their position in
line, starting with position 1.

Anyone in line is able to bribe the person in front of them. They do not swap
stickers however. Each person is able to bribe at most two people.

Given an integer array as input, representing individuals stickers in line,
print the minimum number of bribes that took place to result with this array.
If the given array is not a possible result given the constraints on only two
bribes, print "Too chaotic".

E.g.
int[] arr = {1, 2, 5, 4, 3} --> print 3 (swaps of 4 & 3, 5 & 3, and 5 & 4)

int[] arr = {5, 1, 2, 4, 3} --> print Too chaotic

*/

public class Solution {

    static void minimumBribes(int[] q) {
        int count = 0;
        boolean chaos = false;
        for (int i = 0; i < q.length; i++) {
            if (q[i] - 1 - i > 2) {
                chaos = true;
                break;
            }
        }
        if (chaos) {
            System.out.println("Too chaotic");
            return;
        }
        for (int j = q.length-1; j > 0; j--) {
            if (q[j] < q[j-1]) {
                int tmp = q[j-1];
                q[j-1] = q[j];
                q[j] = tmp;
                count++;
                count += bubbleUp(j, q);
            }
        }
        System.out.println(count);
    }

    private static int bubbleUp(int index, int[] q) {
        int add = 0;
        while (index < q.length - 1 && q[index] > q[index+1]) {
            add++;
            int tmp = q[index+1];
            q[index+1] = q[index];
            q[index] = tmp;
            index++;
        }
        return add;
    }
  }
