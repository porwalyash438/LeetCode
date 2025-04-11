class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count=0;
      for(int i=low;i<=high;i++){
        String strArray = Integer.toString(i);
        int n = strArray.length();
        if(n%2 != 0) continue; 

        int half = n/2;
        int left = 0;
        int right = 0;
        
        for(int j=0;j<half;j++){
            left += strArray.charAt(j) - '0';
        }

        for(int k=half;k<n;k++){
            right += strArray.charAt(k) - '0';
        }

        if(left == right){
            count++;
        }
      }
      return count;  
    }
}