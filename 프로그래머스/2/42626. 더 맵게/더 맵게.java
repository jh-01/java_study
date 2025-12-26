import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        // 배열을 힙으로 만든다.
		for(int i = 0; i < scoville.length; i++) {
			heap.add(scoville[i]);
		}
        
        // 가장 안 매운 음식부터 확인
        while (heap.size() > 1 && heap.peek() < K) {
			int x = heap.poll();
            int y = heap.poll();
            heap.add(x + (y * 2));
            answer++;
		}
        
        if(heap.peek() < K) return -1;
        
        return answer;
    }
}