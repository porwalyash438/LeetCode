class Solution {
    public void reverseString(char[] s) {
        helper(s,0,s.length-1);
    }

    public void helper(char[] str,int i,int j){
        if(i>=j){
            return;
        }

        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;

        i++;
        j--;

        helper(str,i,j);
    }
}