import java.util.*;

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        List<List<Integer>> wraplist = new LinkedList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> sublist = new ArrayList<>();
            boolean isXFound = false, isYFound = false;

            for (int i = 0; i < size; i++) {
                TreeNode currentNode = q.poll();
                sublist.add(currentNode.val);

                if (currentNode.val == x) isXFound = true;
                if (currentNode.val == y) isYFound = true;
                if (currentNode.left != null && currentNode.right != null) {
                    if ((currentNode.left.val == x && currentNode.right.val == y) ||
                        (currentNode.left.val == y && currentNode.right.val == x)) {
                        return false; 
                    }
                }

                if (currentNode.left != null) q.offer(currentNode.left);
                if (currentNode.right != null) q.offer(currentNode.right);
            }

            wraplist.add(sublist);

            if (isXFound && isYFound) return true;

            if (isXFound || isYFound) return false;
        }

        return false;
    }
}
