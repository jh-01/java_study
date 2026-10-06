import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        int N = weights.length;
        Map<Integer, Integer> count = new HashMap<>();
        
        for(int w : weights){
            // 몸무게가 같은 경우
            answer += count.getOrDefault(w, 0);
            
            if(w * 3 % 2 == 0){
                int p = w * 3 / 2;
                answer += count.getOrDefault(p, 0);
            }
            
            if(w * 4 % 2 == 0){
                int p = w * 4 / 2;
                answer += count.getOrDefault(p, 0);
            }
            
            if(w * 4 % 3 == 0){
                int p = w * 4 / 3;
                answer += count.getOrDefault(p, 0);
            }
            
            if(w * 2 % 3 == 0){
                int p = w * 2 / 3;
                answer += count.getOrDefault(p, 0);
            }
            
            if(w * 2 % 4 == 0){
                int p = w * 2 / 4;
                answer += count.getOrDefault(p, 0);
            }
            
            if(w * 3 % 4 == 0){
                int p = w * 3 / 4;
                answer += count.getOrDefault(p, 0);
            }
            
            count.put(w, count.getOrDefault(w, 0) + 1);
        }
        
        
        return answer;
    }
}