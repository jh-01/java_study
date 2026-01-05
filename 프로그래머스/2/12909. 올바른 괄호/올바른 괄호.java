import java.util.*;

class Solution {
    boolean solution(String s) {
        if(s.charAt(0) == ')') return false;
        if(s.charAt(s.length() - 1) == '(') return false;
        
        int cnt = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(') cnt++;
            else cnt--;
            if (cnt < 0) return false;
        }

        return cnt == 0 ? true : false;
    }
}