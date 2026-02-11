class Solution {
    public void solve(int idx,int[] arr,int target,List<Integer>temp,List<List<Integer>>ans){
        if(target==0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(target<0)return;

        for(int i=idx;i<arr.length;i++){
            temp.add(arr[i]);   //do
            solve(i,arr,target-arr[i],temp,ans); //explore
            temp.remove(temp.size()-1); //backtrack
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>ans = new ArrayList<>();
        List<Integer>temp =new ArrayList<>();
        solve(0,candidates,target,temp,ans);
        return ans;
        
    }
}