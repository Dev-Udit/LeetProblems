class Solution {
    public StringBuilder invert(StringBuilder sb){
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)=='0')sb.setCharAt(i, '1');
            else sb.setCharAt(i, '0');;
        }
        return sb;
    }

    public char findKthBit(int n, int k) {
        StringBuilder sb = new StringBuilder("0");
        for(int i=1;i<n;i++){
            StringBuilder r = new StringBuilder(sb);
            StringBuilder s = sb.append("1").append(invert(r).reverse());
            sb = s;  
            
        }
        
        return sb.charAt(k-1);
    }
}