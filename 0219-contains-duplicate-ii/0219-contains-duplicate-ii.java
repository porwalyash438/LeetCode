class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int i=0;
        int j=0;
        int n=nums.length;
        HashSet<Integer> set=new HashSet<>(n);
        while( j < n){
            if(!set.contains(nums[j])){
                set.add(nums[j]);
            }
            else{
                return true;
            }
            if(set.size() > k){
                set.remove(nums[i]);
                i++;
            }
            j++;
        }
        return false;
    }
}