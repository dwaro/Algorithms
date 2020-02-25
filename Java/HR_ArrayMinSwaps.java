/*

Given an array of integers, return the minimum number of swaps necessary in
order to make the list ordered ascending.

The time complexity of this is 2n, so therefore O(n)

*/


public class Solution {

    static int minimumSwaps(int[] arr) {
        int swaps = 0;
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] != i + 1) {
                int tmp = arr[i];
                arr[i] = arr[tmp - 1];
                arr[tmp - 1] = tmp;
                swaps++;
            }
        }
        return swaps;
    }
  }
