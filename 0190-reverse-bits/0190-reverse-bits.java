class Solution {
    public int reverseBits(int n) {
        int ans = 0;

        for (int i = 0; i < 32; i++) {
            ans <<= 1;          // shift left
            ans |= (n & 1);     // add last bit of n
            n >>= 1;            // shift n right
        }

        return ans;
    }
}
