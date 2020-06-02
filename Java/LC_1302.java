/**
 * From LeetCode, problem 1302.
 * 
 * Return the sum of values of a tree's deepest leaves.
 *
 * This approach uses two depth first searches. One to find the deepest level in the tree, and the
 * other to sum the deepest leaves of the tree.
 * 
 * Run Time Complexity: O(n) where n is the number of nodes in the tree, or also O(2^m) where m is the
 * max depth, and 2 is the branching factor.
 * 
 * Space Time Complexity: O(m), because depth first search only stores one path at a time, and the
 * longest path is to the deepest node.
 * 
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int deepestLeavesSum(TreeNode root) {
        if (root == null) return 0;
        
        int deepestLevel = Math.max(findDeepestLevel(root.left), findDeepestLevel(root.right));
        
        return sumDeepestLevel(deepestLevel, 0, root);
    }
    
    /**
     * Find the deepest level of the tree
     */
    private int findDeepestLevel(TreeNode current) {
        if (current == null) return 0;
        
        return 1 + Math.max(findDeepestLevel(current.left), findDeepestLevel(current.right));
    }
    
    /**
     * Sum the values of the deepest level of the tree
     */
    private int sumDeepestLevel(int deepest, int level, TreeNode current) {
        // null node has no value to add, even if it is the deepest level
        if (current == null) return 0;

        // node is at deepest level, return its value
        if (level == deepest && current != null) return current.val;

        // continue
        return 0 + 
            sumDeepestLevel(deepest, level + 1, current.left) + 
            sumDeepestLevel(deepest, level + 1, current.right);
    }
}
