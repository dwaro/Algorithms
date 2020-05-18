/**
 * From LeetCode: "Given a fixed length array arr of integers, duplicate each
 * occurrence of zero, shifting the remaining elements to the right. Note that
 * elements beyond the length of the original array are not written. Do the
 * above modifications to the input array in place, do not return anything from
 * your function."
 *
 * e.g. [1,0,2,3,0,4,5,0] --> [1,0,0,2,3,0,0,4]
 * e.g. [1,2,3] --> [1,2,3]
 *
 */
class Solution {
  public void duplicateZeros(int[] arr) {
    List<Integer> locs = new ArrayList<Integer>();

    // O(n)
    for (int i = 0; i < arr.length && locs.size() < arr.length; i++) {
      if (arr[i] == 0) {
        locs.add(0);
      }
      locs.add(arr[i]);
    }

    // O(n)
    for (int j = 0; j < arr.length; j++) {
      arr[j] = locs.get(j);
    }
  }
}
