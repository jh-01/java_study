import java.util.Arrays;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        // routes 배열 끝지점을 기준으로 정렬
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        
        int i = 1;
        int prev = routes[0][1];
        answer++;
        
        while(i < routes.length){
            int tempStart = routes[i][0];
            int tempEnd = routes[i][1];
            if(prev < tempStart) {
                answer++;
                prev = tempEnd;
            }
            i++;
        }
        
        return answer;
    }
}