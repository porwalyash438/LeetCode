class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int start = 0, end = nums.length - 1;
        while (start < nums.length && nums[start] == arr[start]) {
            start++;
        }
        while (end > start && nums[end] == arr[end]) {
            end--;
        }
        if (start >= end) {
            return 0;
        }
        
        return end - start + 1;
    }
}