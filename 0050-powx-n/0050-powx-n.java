class Solution {
    public double helper(double a, long b) {
        if (b == 0) return 1;

        double half = helper(a, b / 2);

        if (b % 2 == 0) return half * half;
        else return half * half * a;
    }

    public double myPow(double x, int n) {
        long N = n; 
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return helper(x, N);
    }
}
