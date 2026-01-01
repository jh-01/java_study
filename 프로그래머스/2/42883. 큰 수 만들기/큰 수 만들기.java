import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuffer sb = new StringBuffer();
        
        // int index = 0;
        // while(index < sb.length()){
        //     int N = sb.length();
        //     if(k == 0) break;
        //     if(index < N - 1 && sb.charAt(index) < sb.charAt(index + 1)){
        //         sb.deleteCharAt(index);
        //         index = Math.max(0, index - 1);
        //         k--;
        //     } else {
        //         index++;
        //     }
        // }
        
        for(char c : number.toCharArray()){
            while(sb.length() > 0 && k > 0 && sb.charAt(sb.length() - 1) < c){
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }
            sb.append(c);
        }
        
        // k가 남아있는 경우 뒤에서부터 삭제
        return sb.substring(0, sb.length() - k);
    }
}