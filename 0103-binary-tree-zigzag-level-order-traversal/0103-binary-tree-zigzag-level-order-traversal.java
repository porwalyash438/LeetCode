import java.util.*;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> wraplist = new LinkedList<>();

        if (root == null) {
            return wraplist;
        }

        queue.offer(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> sublist = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                sublist.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            if (!leftToRight) {
                Collections.reverse(sublist);
            }
            wraplist.add(sublist);
            leftToRight = !leftToRight;
        }
        return wraplist;
    }
}
