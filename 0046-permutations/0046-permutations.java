class Solution {
    public void solve(int idx,int[]nums,List<List<Integer>>ans){
        if(idx==nums.length){
            List<Integer>list = new ArrayList<>();
            for(int ele:nums){
                list.add(ele);
            }
            ans.add(list);
            return;
        }

        for(int i=idx;i<nums.length;i++){
            swap(nums,i,idx);
            solve(idx+1,nums,ans);
            swap(nums,i,idx);
        }
    }

    public void swap(int[] arr,int i,int j){
        int temp =arr[j];
        arr[j]=arr[i];
        arr[i]=temp;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>ans = new ArrayList<>();
        solve(0,nums,ans);
        return ans;
    }
}