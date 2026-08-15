import java.util.*;

class Solution {
    public String solution(String my_string, int s, int e) {
        int n = my_string.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s; i++){
            sb.append(my_string.substring(i, i + 1));
        }
        for(int i = e; i >= s; i--){
            sb.append(my_string.substring(i, i + 1));
        }
        for(int i = e + 1; i < n; i++){
            sb.append(my_string.substring(i, i + 1));
        }
        
        return sb.toString();
    }
}