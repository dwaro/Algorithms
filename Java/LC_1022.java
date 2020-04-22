/**
 * Problem Description from LeetCode: "Given a binary tree, each node has value
 * 0 or 1.  Each root-to-leaf path represents a binary number starting with the
 * most significant bit.  For example, if the path is 0 -> 1 -> 1 -> 0 -> 1,
 * then this could represent 01101 in binary, which is 13.
 *
 * For all leaves in the tree, consider the numbers represented by the path
 * from the root to that leaf.
 *
 * Return the sum of these numbers."
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

  /**
   * DFS implementation to find the sum of the tree paths.
   * @param - root: the initial root to the tree
   *
   **/
  public int sumRootToLeaf(TreeNode root) {
    // early return edge cases
    if (root == null) return 0;
    if (root.left == null && root.right == null) return root.val;

    Stack<TreeNode> stack = new Stack<TreeNode>();
    HashSet<TreeNode> visited = new HashSet<TreeNode>();
    int sum = 0;

    stack.push(root);

    // dfs, operate until the stack is empty
    while (!stack.isEmpty()) {
      root = stack.peek();
      visited.add(root);
      if (root.left != null && !visited.contains(root.left)) {
        stack.push(root.left);
      } else if (root.right != null && !visited.contains(root.right)) {
        stack.push(root.right);
      } else {
        // ensure it's a leaf node when adding to the sum
        if (root.left == null && root.right == null) {
          sum = addToSum(sum, stack);
        }
        stack.pop();
      }
    }

    return sum;
  }

  /**
   * Helper method to calculate the binary sum of a path
   * @param - sum: the current sum of the paths
   * @param - stack: the current stack of the tree
   *
   **/
  private int addToSum(int sum, Stack<TreeNode> stack) {
    String binary = "";
    Iterator<TreeNode> iter = stack.iterator();

    // iterate over the stack, build a binary string of the path values
    while (iter.hasNext()) {
      TreeNode node = iter.next();
      binary += Integer.toString(node.val);
    }

    // convert from binary to int
    int number = Integer.parseInt(binary,2);

    // update sum
    return sum + number;
  }
}
