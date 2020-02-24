public class Solution {

    /*
     *  Given a 2D Integer array, return the largest hour glass sum. In the following
     *  2D array, the x characters represent an hourglass:
     *    - x x x -
     *    - - x - -
     *    - x x x -
     *
     *  The sum is simply the sum of these positions. For example, the following
     *  2D should return 33. There are only 2 hour glasses, and the larger of the
     *  two is formed by [9, 2, 3, 8, 2, 5, 4]
     *    0 9 2 3
     *    9 1 8 7
     *    8 2 5 4
     */
    static int hourglassSum(int[][] arr) {
        int height = arr.length;
        int width = arr[0].length;
        if (height < 3 || width < 3) return 0;

        int max = Integer.MIN_VALUE;
        for (int row = 1; row < height - 1; row++) {
            for (int col = 1; col < width - 1; col++) {
                int sum = 0;
                sum += arr[row-1][col-1];
                sum += arr[row-1][col];
                sum += arr[row-1][col+1];
                sum += arr[row][col];
                sum += arr[row+1][col-1];
                sum += arr[row+1][col];
                sum += arr[row+1][col+1];
                if (sum > max) max = sum;
            }
        }
        return max;
    }
  }
