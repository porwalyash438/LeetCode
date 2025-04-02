import java.util.*;

class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        
        if (root == null) {
            return ans;
        }
        
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;
            
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                
                sum += currentNode.val;
                
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            
            ans.add(sum / size);
        }
        
        return ans;
    }
}
