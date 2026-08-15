import java.util.*;

class Solution {
    public int solution(String A, String B) {
        int n = A.length();
        StringBuilder sb = new StringBuilder();
        
        if(A.equals(B)) return 0;
        for(int i = 1; i < n; i++){
            sb.append(A.substring(n - 1, n));
            sb.append(A.substring(0, n - 1));
            
            A = sb.toString();
            if(A.equals(B)) return i;
            sb = new StringBuilder();
        }
        
        return -1;
    }
}