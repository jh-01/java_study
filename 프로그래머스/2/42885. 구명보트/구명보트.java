import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        // 내림차순 정렬
        int[] sorted = Arrays.stream(people)
                     .boxed()
                     .sorted(Collections.reverseOrder())
                     .mapToInt(Integer::intValue)
                     .toArray();
        
        // 배를 탈 수 있는지 확인
        int i = 0;
        int j = sorted.length - 1;
        while(i <= j){
            int sum = sorted[i] + sorted[j];
            if(sum > limit) {
                i++;
                answer++;
            } else if(sum <= limit){
                i++;
                j--;
                answer++;
            }
        }
        
        return answer;
    }
}