class Solution {
    public int addDigits(int x) {
        if (x == 0 ){
            return 0;
        }
        int digit = x % 10;
        x = x / 10;
        int num = digit + addDigits(x);
        if (num > 9){
            return addDigits(num);
        }
        else{
            return num;
        }
    }
}