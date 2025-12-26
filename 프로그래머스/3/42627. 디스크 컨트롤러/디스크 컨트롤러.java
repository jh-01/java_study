import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int N = jobs.length;
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.<int[]>comparingInt(o -> o[1])
              .thenComparingInt(o -> o[2]).thenComparingInt(o -> o[0]));
        
        int time = 0;
        int cnt = 0;
        int idx = 0;
        while(cnt < N){
            // time보다 요청 시간이 작은 경우에만 heap에 추가
             while (idx < jobs.length && jobs[idx][0] <= time) {
                heap.offer(new int[]{idx, jobs[idx][1], jobs[idx][0]});
                idx++;
            }

            if(heap.isEmpty()) {
                time = jobs[idx][0];
            } else {
                int[] temp = heap.poll();
                time += temp[1];
                answer += time - temp[2];
                cnt++;
            }
        }
        
        return answer / N;
    }
}