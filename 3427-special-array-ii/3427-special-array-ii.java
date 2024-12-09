class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] count = new int[n];
        
        for (int i = 0; i < n - 1; i++) {
            count[i + 1] = count[i] + ((nums[i] % 2 == nums[i + 1] % 2) ? 1 : 0);
        }
        
        boolean[] result = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int from = queries[i][0];
            int to = queries[i][1];
            
            if (from == to) {
                result[i] = true;
            } else {
                result[i] = (count[to] - count[from] == 0);
            }
        }
        
        return result;
    }
}
