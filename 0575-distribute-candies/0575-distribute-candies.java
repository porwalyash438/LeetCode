import java.util.HashSet;

class Solution {
    public int distributeCandies(int[] candyType) {
        int n = candyType.length;
        int size = n / 2;
        HashSet<Integer> set = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            set.add(candyType[i]);  
        }
        
        return Math.min(size, set.size());
    }
}
