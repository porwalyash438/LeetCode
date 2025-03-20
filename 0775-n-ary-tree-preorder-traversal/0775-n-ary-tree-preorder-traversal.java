class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        Stack<Node> st = new Stack<Node>();
        if (root == null) {
            return list;
        }

        st.push(root);
        while (!st.isEmpty()) {
            Node curr = st.pop();
            list.add(curr.val);
            if (curr.children != null) {
                for (int i = curr.children.size() - 1; i >= 0; i--) {
                    st.push(curr.children.get(i));
                }
            }
        }
        return list;
    }
}
