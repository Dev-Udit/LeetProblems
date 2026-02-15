class Solution {
    public String addBinary(String a, String b) {
        int i = a.length()-1;
        int j = b.length()-1;

        StringBuilder ans = new StringBuilder();
        int sum = 0;
        int car = 0;

        while(i >= 0 || j>=0){
            sum = car;
            if(i>=0){
                sum += a.charAt(i)-'0';
                i--;
            }
            if(j>=0){
                sum += b.charAt(j)-'0';
                j--;
            }

            ans.append(sum % 2);
            car = (sum > 1) ? 1:0;  // sum/2
        }

        if(car==1)ans.append(1);
        return ans.reverse().toString();
    }
}