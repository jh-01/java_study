import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<int[]> q = new LinkedList<>();
        
        for(int i = 0; i < priorities.length; i++){
            q. add(new int[] {i, priorities[i]});
        }
        
        int index = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            boolean hasHigher = false;

            for (int[] doc : q) {
                if (doc[1] > cur[1]) {
                    hasHigher = true;
                    break;
                }
            }

            if (hasHigher) {
                q.add(cur);
            } else {
                answer++;
                if (cur[0] == location) {
                    return answer;
                }
            }
        }
        
        return answer;
    }
}