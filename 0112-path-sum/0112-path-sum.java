class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return PathSum(root, targetSum);
    }   

    public boolean PathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        return PathSum(root.left, targetSum - root.val) || PathSum(root.right, targetSum - root.val);
    }
}
