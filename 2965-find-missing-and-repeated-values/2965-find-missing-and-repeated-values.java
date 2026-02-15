class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        
        long N = n*n;
        long asum = N*(N+1)/2;
        long asum2= (N*(N+1)*(2*N+1))/6;

        long sum = 0;
        long sum2 = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                sum += grid[i][j];
                sum2 += grid[i][j] * grid[i][j];
            }
        }

        //x2-y2 = (x+y)(x-y)  x->repeating  y->missing
        long sqdiff = sum2 - asum2;
        long ndiff = sum - asum;
        long add = sqdiff / ndiff;

        long x = (add + ndiff)/2;
        long y = add-x;
        return new int[]{(int)x,(int)y};
    }
}