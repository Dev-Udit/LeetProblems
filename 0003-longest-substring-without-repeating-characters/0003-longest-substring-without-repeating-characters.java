class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashSet<Character>set = new HashSet<>();
        int i=0;
        int maxLen = 0;
        for(int j=0;j<n;j++){
            char ch = s.charAt(j);
            while(i<j && set.contains(ch)){
                set.remove(s.charAt(i));
                i++;     
            }
            set.add(ch);
            maxLen = Math.max(maxLen, j-i+1);
        }
        return maxLen;
    }
}