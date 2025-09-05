import java.util.*;

class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        long mod = 1_000_000_007L;
        Arrays.sort(arr);
        Map<Integer, Long> map = new HashMap<>();
        
        for (int i = 0; i < arr.length; i++) {
            long ways = 1; 
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0) {
                    int check = arr[i] / arr[j];
                    if (map.containsKey(check)) {
                        ways = (ways + map.get(arr[j]) * map.get(check)) % mod;
                    }
                }
            }
            map.put(arr[i], ways); 
        }

        long result = 0;
        for (long val : map.values()) {
            result = (result + val) % mod;
        }

        return (int) result;
    }
}
