import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> result = new ArrayList<>();
        
        int cnt = 1;
        int temp = (int)Math.ceil((100.0 - progresses[0]) / speeds[0]);
        for(int i = 1; i < progresses.length; i++){
            int next = (int)Math.ceil((100.0 - progresses[i]) / speeds[i]);
            if (next <= temp) {
                cnt++;
            } else {
                result.add(cnt);
                cnt = 1;
                temp = next;
            }
        }
        result.add(cnt);
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}