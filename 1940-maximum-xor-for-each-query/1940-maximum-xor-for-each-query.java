class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int[] result = new int[n];
        int xor = 0;
        int maxValue = (1 << maximumBit) - 1; 
        for (int num : nums) {
            xor ^= num;
        }
        for (int i = 0; i < n; i++) {
            result[i] = xor ^ maxValue;
            xor ^= nums[n - 1 - i];     
        }

        return result;
    }
}
