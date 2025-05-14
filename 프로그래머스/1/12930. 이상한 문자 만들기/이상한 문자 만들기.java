class Solution {
    public String solution(String s) {
        s = s.toLowerCase();
        
        int index = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' ') {
                index = 0;
                continue;
            }
            if(index % 2 == 0) {
                s = s.substring(0, i) + 
                Character.toString(s.charAt(i)).toUpperCase() + 
                s.substring(i + 1);
            }
            index++;
        }
        return s;
    }
}