class Solution {
    public int minRemoval(int[] nums, int k) {
        //find the longest subarray follow the condition
        Arrays.sort(nums);
        int n = nums.length;
        int i=0;
        int j=0;
        int maxLen = 0;
        while(j<n){
            while(i<j && nums[j] > (long)nums[i]*k){
                i++;
            }
            maxLen = Math.max(maxLen, j-i+1);
            j++;
        }
        
        return  n-maxLen;        //deletion
    }
}