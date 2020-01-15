/*
Leetcode Problem 198 -- House Robber

"You are a professional robber planning to rob houses along a street. Each house
has a certain amount of money stashed, the only constraint stopping you from
robbing each of them is that adjacent houses have security system connected and
it will automatically contact the police if two adjacent houses were broken
into on the same night.

Given a list of non-negative integers representing the amount of money of each
house, determine the maximum amount of money you can rob tonight without
alerting the police."
*/

class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0

        int previous = 0;
        int plongest = 0;

        for (int i = 1; i < nums.length; i++) {
            previous = i - 1 > -1 ? nums[i - 1] : 0;
            plongest = i - 2 > -1 ? nums[i - 2] : 0;
            nums[i] = Math.max(previous, nums[i] + plongest);
        }
        return nums[nums.length - 1];
    }
}
