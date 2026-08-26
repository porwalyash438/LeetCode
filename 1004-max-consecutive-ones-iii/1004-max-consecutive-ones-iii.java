class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0, r = 0, zero = 0, maxlen = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zero++;
            }
            while (zero > k) {
                if (nums[l] == 0)
                    zero--;
                l++;
            }
            maxlen = Math.max(maxlen, i - l + 1);
        }
        return maxlen;
    }
}