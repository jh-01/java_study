import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights){
        int answer = 0;
        int index = 0;
        int sum = 0;
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < bridge_length; i++){
            q.add(0);
        }

        while(!q.isEmpty() && index < truck_weights.length){
            answer++;
            int prev = q.poll();
            sum -= prev;
            
            if(sum + truck_weights[index] <= weight){
                q.offer(truck_weights[index]);
                sum += truck_weights[index];
                index++;
            } else {
                q.offer(0);
            }
        }
        return answer + bridge_length;
    }
}