import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = 0;
        List<Set<Integer>> dp = new ArrayList<>();
        
        // dp 초기화
        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }
        
        dp.get(0).add(N);
        int num = 0;
        for (int i = 1; i <= 8; i++) {
            num = num * 10 + N;
            dp.get(i).add(num);
        }
        
        
        for (int i = 1; i <= 8; i++) { // N을 쓴 횟수
            for (int j = 1; j < i; j++) { // 왼쪽 식에서 N을 쓴 횟수
                for (int a : dp.get(j)) {
                    for (int b : dp.get(i - j)) {
                        dp.get(i).add(a + b);
                        dp.get(i).add(a - b);
                        dp.get(i).add(a * b);
                        // b가 0이 아닌지 반드시 확인
                        if (b != 0) dp.get(i).add(a / b);
                    }
                }
            }
            // number를 만들었는지 매 단계마다 확인
            if (dp.get(i).contains(number)) {
                return i;
            }
        }
        
        // 최솟값이 8보다 큰 경우
        return -1;
    }
}