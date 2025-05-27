import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        
        List<Integer> arr = new ArrayList<>();
        
        for (int i = 0; i < score.length; i++) {
            if(i < k){
                arr.add(score[i]);
                Collections.sort(arr);
                answer[i] = arr.get(0);
            } else {
                if(arr.get(0) < score[i]){
                    arr.remove(0);
                    arr.add(0, score[i]);
                    Collections.sort(arr);
                }
                answer[i] = arr.get(0);
            }
            
        }
        return answer;
    }
}