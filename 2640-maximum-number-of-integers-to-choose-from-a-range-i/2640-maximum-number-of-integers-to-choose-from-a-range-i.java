import java.util.ArrayList;
import java.util.HashSet;

class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        HashSet<Integer> bannedSet = new HashSet<>();
        for (int num : banned) {
            bannedSet.add(num);
        }
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (!bannedSet.contains(i)) {
                arr.add(i);
            }
        }
        int sum = 0;
        int count = 0;
        for (int num : arr) {
            if (sum + num <= maxSum) {
                sum += num;
                count++;
            } else {
                break; 
            }
        }

        return count;
    }
}
