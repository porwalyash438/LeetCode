class Solution {
    public int maxArea(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = n-1;
        int maxarea = 0;
        while(i < j){
            int w = j - i;
            int h = Math.min(nums[i],nums[j]);
            int area = w * h;
            maxarea = Math.max(maxarea,area);

            if(nums[i] > nums[j]){
                j--;
            }else{
                i++;
            }
        }
        return maxarea;
    }
}