class Solution {
    public boolean isDivides(int[]arr,int k){
        for(int ele:arr){
            if(ele%k != 0)return false;
        }
        return true;
    }
    public int minOperations(int[] nums, int[] numsDivide) {
        TreeMap<Integer, Integer>map = new TreeMap<>();
        for(int ele:nums){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        int deletion = 0;
        for(int ele:map.keySet()){
            if(isDivides(numsDivide,ele)){
                return deletion;
            }
            deletion += map.get(ele);
        }
        return -1;
    }
}