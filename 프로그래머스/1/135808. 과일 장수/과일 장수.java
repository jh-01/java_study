import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int k, int m, int[] score) {
        Integer[] referScore = Arrays.stream(score).boxed().toArray(Integer[]::new);
        Arrays.sort(referScore, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) { // a는 앞의 수 b는 뒤의 수
                return b.compareTo(a); // 내림차순
            }
        });
        
        int answer = 0;
        for(int i = 0; i < referScore.length; i += m){
            if(i + m - 1 < referScore.length){
                answer += referScore[i + m - 1] * m;
            }
        }
        return answer;
    }
}