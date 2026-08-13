import java.util.*;

class Solution {
    public String solution(String my_string, String letter) {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < my_string.length(); i++){
            String temp = my_string.substring(i, i + 1);
            if(!temp.equals(letter)){
                sb.append(temp);
            }
        }
        
        return sb.toString();
    }
}