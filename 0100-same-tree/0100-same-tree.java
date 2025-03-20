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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> list1 = Preorder(p, new ArrayList<>());
        List<Integer> list2 = Preorder(q, new ArrayList<>());
        return list1.equals(list2);
    }

    public List<Integer> Preorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            list.add(null);
            return list;
        }
        list.add(root.val);
        Preorder(root.left, list);
        Preorder(root.right, list);
        return list;
    }

}