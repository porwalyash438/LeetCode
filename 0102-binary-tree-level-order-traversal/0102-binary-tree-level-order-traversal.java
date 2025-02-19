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

 import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
       List<List<Integer>> ans = new ArrayList<>();
       if(root == null){
        return ans;
       } 

       Queue<TreeNode> temp = new LinkedList<>();
        temp.add(root);

        
        while(!temp.isEmpty()){
            ArrayList<Integer> ls = new ArrayList<>();
            int size=temp.size();
            for(int i=0;i<size;i++){
                TreeNode t = temp.poll();

                if(t.left != null){
                    temp.add(t.left);
                }

                if(t.right != null){
                    temp.add(t.right);
                }
                ls.add(t.val);
            }
            ans.add(ls);
        }
        return ans;
    }
}