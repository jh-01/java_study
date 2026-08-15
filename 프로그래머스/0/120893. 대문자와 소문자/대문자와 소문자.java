import java.util.*;

class Solution {
    public String solution(String my_string) {
        int n = my_string.length();
        StringBuffer sb = new StringBuffer();
        
        for(int i = 0; i < n; i++){
            char c = my_string.charAt(i);
            if(c >= 'a' && c <= 'z'){
                sb.append(Character.toString(c).toUpperCase());
            } else {
                sb.append(Character.toString(c).toLowerCase());
            }
        }
        
        return sb.toString();
    }
}