class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n-1;
        while(l<=r){
            //if sorted then at l is minimum
            if(nums[l] <= nums[r])return nums[l];
            int mid = l+(r-l)/2;
            //if mid is minimum
            int next = (mid+1)%n;
            int prev = (mid-1+n)%n;

            if(nums[mid]<=nums[next] && nums[mid]<=nums[prev])return nums[mid];
            
            //if left sorted ---> go in right
            else if(nums[l] <= nums[mid]){
                l = mid+1;
            }
            else r = mid-1;
        }
        return -1;
    }
}