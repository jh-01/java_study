import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        int n = participant.length;
        int m = completion.length;
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            String temp = participant[i];
            
            if(map.containsKey(temp)){
                map.put(temp, map.get(temp) + 1);
            } else {
                map.put(temp, 1);
            }
        }
        
        for(int i = 0; i < m; i++){
            String temp = completion[i];
            if(map.get(temp) > 0){
                map.put(temp, map.get(temp) - 1);
            }
        }
        
        for(int i = 0; i < n; i++){
            String temp = participant[i];
            if(map.get(temp) > 0){
                answer = temp;
            }
        }
        
        return answer;
    }
}