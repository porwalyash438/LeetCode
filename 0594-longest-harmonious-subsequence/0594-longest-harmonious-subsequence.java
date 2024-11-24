class Solution {
    public int findLHS(int[] nums) {
        HashMap<Integer , Integer> map=new HashMap<>();
        int maxlen=0;
        for(int i: nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(int key:map.keySet()){
            if(map.containsKey(key+1)){
                maxlen=Math.max(maxlen, map.get(key)+map.get(key+1));
            }
        }
        return maxlen;
    }
}