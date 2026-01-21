import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int N = points.length; // 포인트 수
        int X = routes.length; // 로봇 수
        int answer = 0;
        
        // 시간, (좌표, 해당 좌표 로봇 수)
        Map<Integer, Map<String, Integer>> timeMap = new HashMap<>();

        for(int i = 0; i < X; i++){ // i는 로봇 인덱스
            int time = 0;
            // 시작 좌표
            int x = points[routes[i][0] - 1][0];
            int y = points[routes[i][0] - 1][1];
            
            // time = 0 기록
            timeMap.putIfAbsent(0, new HashMap<>());
            Map<String, Integer> map0 = timeMap.get(0);
            String key0 = x + "," + y;
            
            int cnt0 = map0.getOrDefault(key0, 0) + 1;
            map0.put(key0, cnt0);
            if (cnt0 == 2) answer++;
            
            // 도착 좌표
            int endR = points[routes[i][1] - 1][0];
            int endC = points[routes[i][1] - 1][1];
            
            // routes의 각 구간 처리
            for (int r = 0; r < routes[i].length - 1; r++) {

                int endX = points[routes[i][r + 1] - 1][0];
                int endY = points[routes[i][r + 1] - 1][1];

                // 현재 → 다음 포인트까지 이동
                while (x != endX || y != endY) {

                    if (x != endX) {
                        x += Integer.compare(endX, x);
                    } else {
                        y += Integer.compare(endY, y);
                    }

                    time++;

                    timeMap.putIfAbsent(time, new HashMap<>());
                    Map<String, Integer> map = timeMap.get(time);

                    String key = x + "," + y;
                    int cnt = map.getOrDefault(key, 0) + 1;
                    map.put(key, cnt);

                    if (cnt == 2) answer++;
                }
            }
        }
        
        return answer;
    }
}