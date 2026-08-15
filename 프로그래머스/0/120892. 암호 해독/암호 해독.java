import java.util.*;

class Solution {
    public String solution(String cipher, int code) {
        int n = cipher.length();
        StringBuffer sb = new StringBuffer();
        for(int i = code - 1; i < n; i+= code){
            sb.append(Character.toString(cipher.charAt(i)));
        }
        
        return sb.toString();
    }
}