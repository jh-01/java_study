import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int N = routes.length;
        
        Arrays.sort(routes, (a,b) -> a[1] - b[1]);
        
        int answer = 1;
        int x = routes[0][1];
        for(int i = 1; i < N; i++){
            int y = routes[i][0];
            if(y > x){ // 카메라에 안걸림
                x = routes[i][1];
                answer++;
            }
        }
        
        return answer;
    }
}