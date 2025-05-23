/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftdai = diameterOfBinaryTree(root.left);
        int rightdai = diameterOfBinaryTree(root.right);
        int leftht = height(root.left);
        int rightht = height(root.right);

        int ht = leftht + rightht;

        int ans = Math.max(ht, Math.max(leftdai, rightdai));
        return ans;

    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);

        return 1 + Math.max(lh, rh);
    }
}