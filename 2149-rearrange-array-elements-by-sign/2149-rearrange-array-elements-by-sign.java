class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        for(int i : nums){
            if(i < 0){
                neg.add(i);
            }else{
                pos.add(i);
            }
        }
        for (int i = 0; i < n / 2; i++) {
            nums[2 * i] = pos.get(i);       
            nums[2 * i + 1] = neg.get(i);   
        }
        return nums;
    }
}