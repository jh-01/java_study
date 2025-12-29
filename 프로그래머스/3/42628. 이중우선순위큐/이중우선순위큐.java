import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        int maxN = 0;
        int minN = 123456789;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < operations.length; i++){
            String s = operations[i];
            String[] operation = s.split(" ");
            
            if(operation[0].equals("I")) {
                maxHeap.offer(Integer.parseInt(operation[1]));
                minHeap.offer(Integer.parseInt(operation[1]));
            }
            else if(operation[0].equals("D")){
                if (minHeap.isEmpty()) continue;
                
                if (operation[1].equals("1")) {          // 최대값 삭제
                    int max = maxHeap.poll();
                    minHeap.remove(max);
                } else {                // 최소값 삭제
                    int min = minHeap.poll();
                    maxHeap.remove(min);
                }
            }
        }
        
        if (!minHeap.isEmpty()) {
            answer[0] = maxHeap.peek(); // 최대값
            answer[1] = minHeap.peek(); // 최소값
        }

        return answer;
    }
}