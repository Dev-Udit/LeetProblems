class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if(N < 0) N = -N;
        double ans = 1;
        while(N > 0){
            if((N & 1) == 0){
                x = x*x;
                N /= 2;
            }
            else {
                ans *= x;
                N -= 1;
            }
        }

        if(n < 0) ans = 1/ans;
        return ans;

    }
}