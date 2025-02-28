// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */
// class Solution {
//     public int height(TreeNode root){
//         if(root == null){
//             return 0;
//         }
//         int leftHeight=height(root.left);
//         int rightHeight=height(root.right);
//         int ht=leftHeight+rightHeight+1;
//         return ht;
//     }
//     public int diameterOfBinaryTree(TreeNode root) {
//         if(root == null){
//             return 0;
//         }
//         int leftDai=diameterOfBinaryTree(root.left);
//         int rightDai=diameterOfBinaryTree(root.right);
//         int leftHeight=height(root.left);
//         int rightHeight=height(root.right);

//         int self=leftHeight+rightHeight+1;

//         int ans = Math.max(self,Math.max(leftDai,rightDai));
//         return ans;
//     }
// }
class Solution {
    public int height(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftDiameter = diameterOfBinaryTree(root.left);
        int rightDiameter = diameterOfBinaryTree(root.right);
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int selfDiameter = leftHeight + rightHeight;

        int ans = Math.max(selfDiameter, Math.max(leftDiameter, rightDiameter));
        return ans;
    }
}
