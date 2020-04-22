/**
 * Problem Description from LeetCode: "Given a non-empty array of integers,
 * every element appears twice except for one. Find that single one.""
 */
class Solution {
  /**
   * This method finds the lone number in the array of doubles
   * @param - nums: array of numbers, in which every number appears twice except
   *          for one.
   **/
  public int singleNumber(int[] nums) {
    Arrays.sort(nums);
    for (int i = 0; i < nums.length-2; i+=2) {
        if (nums[i+1] != nums[i]) return nums[i];
    }
    return nums[nums.length-1];
  }
}
