/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    int total;
    public int sumNumbers(TreeNode root) {
        total = 0;
        helper(root, 0);
        return total;
    }
    public void helper(TreeNode root, int num) {
        if (root == null)
            return;
        num = num * 10 + root.val;
        if (root.left == null && root.right == null) {
            total += num;
            return;
        }
        helper(root.left, num);
        helper(root.right, num);
    }
}