class Solution {
    public int[] twoSum(int[] arr, int target) {
        int n = arr.length;
        int i = 0;
        int j = n-1;

        while(j < n){
            if(arr[i]+arr[j] == target){
                return new int[]{i+1,j+1};
            }
            else if(arr[i]+arr[j] > target){
                j--;
            }else{
                i++;
            }
        }
        return new int[] {-1,-1};
    }
}