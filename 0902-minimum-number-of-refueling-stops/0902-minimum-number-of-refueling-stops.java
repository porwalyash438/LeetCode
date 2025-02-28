class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
       int minStop=0;
       int currFuel=startFuel;
       PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
       for(int[] station : stations){
        int position = station[0];
        int fuel = station[1];

        while(currFuel < position){
            if(maxHeap.isEmpty()){
                return -1;
            }
            currFuel += maxHeap.poll();
            minStop++;
        }
        maxHeap.add(fuel);
       }
       while(currFuel < target){
           if(maxHeap.isEmpty()){
                return -1;
            }
            currFuel += maxHeap.poll();
            minStop++; 
       }
       return minStop;
    }
}