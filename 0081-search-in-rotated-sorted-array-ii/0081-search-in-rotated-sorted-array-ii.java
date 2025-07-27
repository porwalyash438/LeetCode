class Solution {
    public boolean search(int[] nums, int target) {
        return helper(nums, target, 0, nums.length - 1);
    }

    public static boolean helper(int[] nums, int target, int low, int high) {
        if (low > high) return false;
        
        int mid = low + (high - low) / 2;
        
        if (nums[mid] == target) return true;
    
        if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
        
            return helper(nums, target, low + 1, high - 1);
        }
        
       
        if (nums[low] <= nums[mid]) {  
            if (nums[low] <= target && target < nums[mid]) {
                return helper(nums, target, low, mid - 1);  
            } else {
                return helper(nums, target, mid + 1, high);  
            }
        } else {  
            if (nums[mid] < target && target <= nums[high]) {
                return helper(nums, target, mid + 1, high); 
            } else {
                return helper(nums, target, low, mid - 1);  
            }
        }
    }
}