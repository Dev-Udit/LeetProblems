class Solution {
    public int reverseBits(int n) {
        String bin = Integer.toBinaryString(n);

        //add zeros to make it 32 bit
        while(bin.length() < 32){
            bin = "0" + bin;
        }

        StringBuilder ans = new StringBuilder(bin).reverse();

        return (int)Long.parseLong(ans.toString() , 2);
    }
}
