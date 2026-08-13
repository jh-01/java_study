import java.util.*;

class Solution {
    public int[] solution(int[] numbers, String direction) {
        int n = numbers.length;
        Deque<Integer> result = new LinkedList<>();

        for(int i = 0; i < n; i++){
            result.add(numbers[i]);
        }
        
        if(direction.equals("left")){
            int temp = result.pollFirst();
            result.add(temp);
        } else {
            int temp = result.pollLast();
            result.addFirst(temp);
        }
        
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            answer[i] = result.poll();
        }

        return answer;
    }
}