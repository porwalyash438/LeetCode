class Solution {
    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;

        path(root);
        return max;
    }

    public int path(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(0, path(root.left));
        int right = Math.max(0, path(root.right));

        max = Math.max(max, left + right + root.val);

        return root.val + Math.max(left, right);
    }
}
