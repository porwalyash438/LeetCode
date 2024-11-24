class Solution {
    public int findLHS(int[] nums) {
    //    int i=0;
    //    int j=0;
    //    int len=0;
    //    int maxlen=0;
    //    int n=nums.length;
    //    while(j<n){
    //     if((nums[j] -nums[i]) == 1){
    //         len=j-i+1;
    //         maxlen=Math.max(maxlen,len);
    //     }else{
    //         j++;
    //     }
        
    //    }
    //    return maxlen; 
    Arrays.sort(nums);
    int n=nums.length;
    int i=0;
    int maxlen=0;
        for(int j=0;j<n;j++){
            if((nums[j] - nums[i]) == 1){
                maxlen=Math.max(maxlen,j-i+1);
            }
            while((nums[j] - nums[i]) > 1){
                i++;
            }
        }
        return maxlen;
    }
}