import java.util.*;

class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        int n = my_string.length();
        
        for(int i = n - 1; i >= 0; i--){
            sb.append(my_string.substring(i, i + 1));
        }
        
        return sb.toString();
    }
}