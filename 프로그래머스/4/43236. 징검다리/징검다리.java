import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        int minDis = 1;
        int maxDis = distance;
        
        Arrays.sort(rocks); // 바위 정렬
        
        while(minDis <= maxDis){
            int removed = 0; // 제거한 바위 수
            int prev = 0; // 마지막으로 유지(제거되지 않은)한 지점
            int midDis = (minDis + maxDis) / 2;
            
            for(int rock : rocks){
                if(rock - prev < midDis) removed++; // 유지 불가능
                else prev = rock; // 유지 가능
            }
            
            if(distance - prev < midDis) removed++; // 도착 지점도 유지 가능한지 체크
            
            if(removed <= n){ // midDis는 가능한 거리. 좀 더 늘려보기로 시도
                answer = midDis;
                minDis = midDis + 1;
            } else { // 불가능. masxDis를 낮춰서 시도
                maxDis = midDis - 1;
            }
        }
        
        return answer;
    }
}