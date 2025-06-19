import java.util.ArrayList;
import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        int[] xArr = new int[10];
        int[] yArr = new int[10];
        
        for(int i = 0; i < X.length(); i++){
            char c = X.charAt(i);
            int num = Character.getNumericValue(c);
            xArr[num]++;
        }
                             
        for(int i = 0; i < Y.length(); i++){
            char c = Y.charAt(i);
            int num = Character.getNumericValue(c);
            yArr[num]++;
        }
        
        StringBuilder result = new StringBuilder();
        for(int i = 9; i >= 0; i--){
            while(true){
                if(xArr[i]-- > 0 && yArr[i]-- > 0){
                   result.append(i);
                }
                else break;
            }
        }
        
        if (result.length() == 0) return "-1";
        if (result.charAt(0) == '0') return "0";
        
        return result.toString();
    }
}