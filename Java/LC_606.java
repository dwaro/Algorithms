/**
 * From LeetCode: "You need to construct a string consists of parenthesis and
 * integers from a binary tree with the preorder traversing way.
 *
 * The null node needs to be represented by empty parenthesis pair "()". And you
 * need to omit all the empty parenthesis pairs that don't affect the one-to-one
 * mapping relationship between the string and the original binary tree."
 *
 * e.g. Binary tree: [1,2,3,4] --> "1(2(4))(3)"
 * e.g. Binary tree: [1,2,3,null,4] --> "1(2()(4))(3)"
 *
 */

/**
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
    public String tree2str(TreeNode t) {
        if (t==null) return "";

        String result = String.valueOf(t.val);
        if (t.left == null && t.right == null) return result;

        result+=buildTreeStr(t.left, true);
        result+=buildTreeStr(t.right, false);

        return result;
    }

    private String buildTreeStr(TreeNode node, boolean isLeft) {
        if (node == null && isLeft) return "()";
        if (node == null) return "";

        String left = buildTreeStr(node.left, true);
        String right = buildTreeStr(node.right, false);

        if (left.equals("()") && right.equals("")) {
            return "(" + node.val + ")";
        }
        return "(" + node.val + left + right + ")";
    }
}
