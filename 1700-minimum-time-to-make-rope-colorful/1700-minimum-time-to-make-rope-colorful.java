class Solution {
    public int minCost(String colors, int[] neededTime) {
        int minTime = 0;
        int currentSum = neededTime[0];
        int currentMax = neededTime[0];
        
        for (int i = 1; i < colors.length(); i++) {
            if (colors.charAt(i) == colors.charAt(i-1)) {
                currentSum += neededTime[i];
                currentMax = Math.max(currentMax, neededTime[i]);
            } else {
                minTime += currentSum - currentMax;
                currentSum = neededTime[i];
                currentMax = neededTime[i];
            }
        }
        minTime += currentSum - currentMax;
        return minTime;
    }
}