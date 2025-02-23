class Solution {
    public int searchInsert(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;
        int mid;
        int index=nums.length;
        while(start <= end) {
            mid=start+(end-start)/2;
            if(nums[mid] == target) {
                index=mid;
                break;
            }
            else if (nums[mid] < target) {
                start = mid+1;
            }
            else {
                index=mid;
                end=mid-1;
            }
        }
        return index;
    }
}