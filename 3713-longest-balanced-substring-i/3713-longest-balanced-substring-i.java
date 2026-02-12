class Solution {
    public boolean isSamefreq(int[]freq,int j){
        int check = freq[j];
        for(int ele:freq){
            if(ele !=0 && ele != check)return false;
        }
        return true;
    }

    
    public int longestBalanced(String s) {
        
        int n = s.length();
        int maxLen = 0;
        for(int i=0;i<n;i++){
            int[] freq = new int[26];
            for(int j=i;j<n;j++){
                freq[s.charAt(j)-'a']++;
                if(isSamefreq(freq,s.charAt(j)-'a')){
                    maxLen = Math.max(maxLen,j-i+1);
                }

            }
        }
        return maxLen;
    }
}