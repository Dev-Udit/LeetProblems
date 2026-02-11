class Solution {
    String map[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public void solve(int idx,StringBuilder sb,List<String>list,String digits){
        if(idx == digits.length()){
            list.add(sb.toString());
            return;
        }

        String temp = map[digits.charAt(idx)-'0'];
        for(int i=0;i<temp.length();i++){
            sb.append(temp.charAt(i));   //do 
            solve(idx+1, sb,list,digits);  //explore
            sb.deleteCharAt(sb.length()-1);  //backtrack
        }
    }


    public List<String> letterCombinations(String digits) {
        List<String>list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        solve(0,sb,list,digits);
        return list;

    }
}