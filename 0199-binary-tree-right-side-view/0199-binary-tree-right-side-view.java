class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        dfs(root, 0, result);
        return result; 
    }

    public void dfs(TreeNode node, int depth, ArrayList<Integer> res) {
        if (node == null) {
            return;
        }
        if (depth == res.size()) {
            res.add(node.val);  
        }
        dfs(node.right, depth + 1, res); 
        dfs(node.left, depth + 1, res);
    }
}
