class Solution {
    public boolean solution(String s) {
        boolean isNumeric = true;
        int sLength = s.length();
        
        for(int i = 0; i < sLength; i++){
            if(!Character.isDigit(s.charAt(i))){
                isNumeric = false;
            }
        }
        if((sLength == 4 || sLength == 6) && isNumeric){
            return true;
        }
        return false;
    }
}