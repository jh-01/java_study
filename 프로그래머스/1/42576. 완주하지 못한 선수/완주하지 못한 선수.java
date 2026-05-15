import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        int N = participant.length;
        String answer = "";
        
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < N - 1; i++){
            if(!map.containsKey(completion[i])){
                map.put(completion[i], 1);
            } else {
                map.put(completion[i], map.get(completion[i]) + 1);
            }
            
        }
        
        for(int i = 0; i < N; i++){
            boolean isContained = map.containsKey(participant[i]);
            if(!isContained) return participant[i];
            
            int x = map.get(participant[i]);
            if(x > 0) {
                map.put(participant[i], x - 1);
            }
            else {
                return participant[i];
            }
            
        }
        
        return answer;
    }
}