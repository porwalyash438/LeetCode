class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        for(int i=0;i<k;i++){
            sum=sum+nums[i];
        }
        int maxsum=sum;
        int i=0;
        int j=k;
        while(j<n){
            sum=sum-nums[i];
            i++;
            sum=sum+nums[j];
            j++;
            maxsum=Math.max(maxsum,sum);
        }
        return maxsum/(double) k;
    }
}
