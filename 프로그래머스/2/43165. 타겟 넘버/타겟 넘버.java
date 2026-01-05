import java.util.*;

class Solution {  
    public int solution(int[] numbers, int target) {
        int N = numbers.length;
        int answer = 0;
        int index = 0;
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{index, 0});
        
        while(!q.isEmpty()){
            int[] temp = q.poll();
            if(temp[0] == N) {
                if(temp[1] == target) answer++;
            } else {
                q.offer(new int[]{temp[0] + 1, temp[1] + numbers[temp[0]]});
                q.offer(new int[]{temp[0] + 1, temp[1] - numbers[temp[0]]});
            }
        }
        
        return answer;
    }
}