import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuffer sb = new StringBuffer(number);
        
        int index = 0;
        while(index < sb.length()){
            int N = sb.length();
            if(k == 0) break;
            if(index < N - 1 && sb.charAt(index) < sb.charAt(index + 1)){
                sb.deleteCharAt(index);
                index = Math.max(0, index - 1);
                k--;
            } else {
                index++;
            }
        }
        
        return sb.substring(0, sb.length() - k);
    }
}