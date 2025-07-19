import java.util.*;

class LockingTree {
    private int[] parent;
    private List<Integer>[] children;
    private int[] lockedBy;

    public LockingTree(int[] parent) {
        this.parent = parent;
        int n = parent.length;
        this.lockedBy = new int[n];
        this.children = new List[n];

        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<>();
        }

        // Build the tree from parent array
        for (int i = 0; i < n; i++) {
            if (parent[i] != -1) {
                children[parent[i]].add(i);
            }
        }
    }

    public boolean lock(int num, int user) {
        if (lockedBy[num] != 0) return false;
        lockedBy[num] = user;
        return true;
    }

    public boolean unlock(int num, int user) {
        if (lockedBy[num] != user) return false;
        lockedBy[num] = 0;
        return true;
    }

    public boolean upgrade(int num, int user) {
        if (lockedBy[num] != 0) return false;
        if (hasLockedAncestor(num)) return false;

        List<Integer> lockedDescendants = new ArrayList<>();
        if (!collectLockedDescendants(num, lockedDescendants)) return false;

        // Unlock all locked descendants
        for (int desc : lockedDescendants) {
            lockedBy[desc] = 0;
        }

        // Lock the current node
        lockedBy[num] = user;
        return true;
    }

    private boolean hasLockedAncestor(int node) {
        int p = parent[node];
        while (p != -1) {
            if (lockedBy[p] != 0) return true;
            p = parent[p];
        }
        return false;
    }

    private boolean collectLockedDescendants(int node, List<Integer> lockedList) {
        boolean found = false;
        for (int child : children[node]) {
            if (lockedBy[child] != 0) {
                lockedList.add(child);
                found = true;
            }
            found |= collectLockedDescendants(child, lockedList);
        }
        return found;
    }
}


/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */