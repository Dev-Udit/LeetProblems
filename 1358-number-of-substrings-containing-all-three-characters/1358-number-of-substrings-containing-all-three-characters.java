class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int fq[] = new int[3];
        int i=0;
        int ans = 0;
        for(int j=0;j<n;j++){
            char ch = s.charAt(j);
            fq[ch - 'a']++;
            while(fq[0] > 0 && fq[1]>0 && fq[2]>0){
                ans += n-j;
                fq[s.charAt(i)-'a']--;
                i++;
            }

        }
        return ans;
    }
}