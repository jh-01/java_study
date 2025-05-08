class Solution {
    public String solution(String s) {
        int mid = -1;
        boolean flag = false;
        String result = "";
        if(s.length() % 2 == 1) mid = s.length() / 2;
        else {
            mid = s.length() / 2 - 1;
            flag = true;
        }
        if(flag){
            for(int i = mid; i <= mid + 1; i++){
                result = result.concat(Character.toString(s.charAt(i)));
            }
        }
        else result = result.concat(Character.toString(s.charAt(mid)));
        
        return result;
    }
}